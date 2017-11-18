package demo;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import ssi.framework.mybatisGenerator.MybatisRunner;

public class Main {
	public static void main(String[] args) {
		MybatisRunner.run("aikezhan",
				Main.class.getClassLoader().getResourceAsStream("generatorConfig.xml"),
				Main.class.getClassLoader().getResourceAsStream("generatorProperites.txt"));
	}
}