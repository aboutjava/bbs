package ssi.framework.mybatisGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunzone on 2017/6/13.
 */
public final class ShardingTableHelper {
    private static List<String> shardingTables = new ArrayList<String>();

    public static void add(String shardingTable) {
        shardingTables.add(shardingTable);
    }

    public static void addAll(String[] shardingTable) {
        shardingTables.addAll(Arrays.asList(shardingTable));
    }

    public static boolean isShardingTable(String fullTableName) {
        for (String shardingTable : shardingTables) {
            if (fullTableName.startsWith(shardingTable)) return true;
        }
        return false;
    }

    public static String getShardingTableName(String fullTableName) {
        for (String shardingTable : shardingTables) {
            if (fullTableName.startsWith(shardingTable)) return shardingTable;
        }
        return "";
    }
}
