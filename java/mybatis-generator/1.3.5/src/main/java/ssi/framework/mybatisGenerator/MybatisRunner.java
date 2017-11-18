package ssi.framework.mybatisGenerator;

import com.mysql.jdbc.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MybatisRunner {
    private static Logger logger = LogManager.getLogger(MybatisRunner.class);

    public static void run(String projectName, InputStream configStream) {
        logger.info(projectName + " start.");
        try {
            runCore(configStream);
        } catch (Exception ex) {
            logger.error(ex);
        }
        logger.info(projectName + " end.");
    }

    public static void run(String projectName, InputStream configStream, InputStream propertyStream) {
        logger.info(projectName + " start.");
        try {
            HashMap<String, String> properties = loadProperties(propertyStream);

            BufferedReader br = new BufferedReader(new InputStreamReader(configStream));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (!line.trim().equals("</context>")) {
                for (String key : properties.keySet()) {
                    int begin = line.indexOf(key);
                    if (begin >= 0) {
                        line = line.substring(0, begin) + properties.get(key) + line.substring(begin + key.length());
                    }
                }
                sb.append(line).append("\n");
                line = br.readLine();
            }
            br.close();
            addTableConfigs(sb, properties);
            sb.append("</context></generatorConfiguration>");
            DomainObjectNameUtils.registryDomainObjectName(sb.toString());
            configStream = new ByteArrayInputStream(sb.toString().getBytes());
            runCore(configStream);
        } catch (Exception ex) {
            logger.error("error:", ex);
        }
        logger.info(projectName + " end.");
    }

    private static void runCore(InputStream configStream)
            throws IOException, InvalidConfigurationException, XMLParserException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configStream);
        configStream.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings)
            System.out.println(warning);
    }

    private static HashMap<String, String> loadProperties(InputStream propertyStream) throws IOException {
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("${user.dir}", System.getProperty("user.dir").replaceAll("\\\\", "/"));
        properties.put("${user.home}", System.getProperty("user.home").replaceAll("\\\\", "/"));

        BufferedReader br = new BufferedReader(new InputStreamReader(propertyStream));
        String line = br.readLine();
        StringBuilder tables = new StringBuilder();
        while (line != null) {
            int index = line.indexOf('=');
            if (!line.startsWith("#") && index > 0) {
                String key = line.substring(0, index).trim();
                String value = line.substring(index + 1).trim();
                value = value.replace("&", "&amp;");
                value = value.replace("<", "&lt;");
                value = value.replace(">", "&gt;");

                if (key.length() > 0) {
                    if (key.startsWith("tables")) {
                        if (tables.length() > 0 && tables.charAt(tables.length() - 1) != ',') {
                            tables.append(',');
                        }
                        tables.append(value);
                    } else if (key.startsWith("shardingTables")) {
                        if (value.length() > 0) {
                            ShardingTableHelper.addAll(value.split(","));
                        }
                    } else {
                        if ("targetProject".equals(key)) {
                            value = new File(value).getCanonicalPath();
                            System.out.println("targetProject=" + value);
                            File targetProjectFile = new File(value);
                            if (!targetProjectFile.exists()) {
                                targetProjectFile.mkdirs();
                            }
                        }
                        key = "${" + key + "}";
                        if (properties.containsKey(key))
                            properties.remove(key);
                        properties.put(key, value);
                    }
                }
            }
            line = br.readLine();
        }
        br.close();
        properties.put("tables", tables.toString());
        return properties;
    }

    private static void addTableConfigs(StringBuilder sb, HashMap<String, String> properties) {
        String schema = properties.get("${schema}");
        String tableString = properties.get("tables");
        if (StringUtils.isNullOrEmpty(tableString))
            return;
        tableString = tableString.replaceAll("`", "");
        // ssi_role,ssi_user_role:UserRole
        String[] tables = tableString.split(",");
        for (String table : tables) {
            if (table.trim().length() > 0) {
                String[] ss = table.split(":");
                String tableName = ss[0].trim();
                boolean isShardingTable = ShardingTableHelper.isShardingTable(tableName);
                String shardingTableName = isShardingTable ? ShardingTableHelper.getShardingTableName(tableName) : null;
                String domainName;
                if (isShardingTable) {
                    domainName = shardingTableName.endsWith("_") ?
                            shardingTableName.substring(0, shardingTableName.length() - 1) :
                            shardingTableName;
                    domainName = DomainObjectNameUtils.toClassNameFromTableName(domainName);
                } else {
                    domainName = ss.length == 2 ? ss[1].trim() : DomainObjectNameUtils.toClassNameFromTableName(tableName);
                }
                if (sb.toString().indexOf("\"" + tableName + "\"") < 0) {
                    sb.append(String.format(
                            "<table schema=\"%s\" tableName=\"%s\" domainObjectName=\"%s\" enableDeleteByExample=\"true\" enableUpdateByExample=\"true\">",
                            schema, tableName, domainName));
                    sb.append("<property name=\"useActualColumnNames\" value=\"true\" />");
                    if (isShardingTable) {
                        sb.append(String.format("<property name=\"runtimeTableName\" value=\"%s\" />", shardingTableName));
                    }
                    sb.append("</table>").append("\r\n");
                }
            }
        }
    }
}
