package generator;

import java.io.IOException;

import ssi.framework.mybatisGenerator.MybatisRunner;

public class AntcoinDataCodeGenerator {
	public static void main(String[] args) throws IOException {
		MybatisRunner.run("antcoin",
				AntcoinDataCodeGenerator.class.getClassLoader().getResourceAsStream("generatorConfig.xml"),
				AntcoinDataCodeGenerator.class.getClassLoader().getResourceAsStream("generatorProperites.txt"));
	}
}