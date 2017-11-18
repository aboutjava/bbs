package ssi.framework.mybatisGenerator.xmlmapper;

import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;

public class SsiJavaClientGenerator extends JavaMapperGenerator{
	@Override
    public AbstractXmlGenerator getMatchedXMLGenerator() {
        return new SsiXMLMapperGenerator();
    }
}
