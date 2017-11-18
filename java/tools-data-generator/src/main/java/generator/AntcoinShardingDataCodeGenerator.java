package generator;

import ssi.framework.mybatisGenerator.MybatisRunner;

import java.io.IOException;

public class AntcoinShardingDataCodeGenerator {
	public static void main(String[] args) throws IOException {
		MybatisRunner.run("antcoin",
				AntcoinShardingDataCodeGenerator.class.getClassLoader().getResourceAsStream("generatorConfig-sharding.xml"),
				AntcoinShardingDataCodeGenerator.class.getClassLoader().getResourceAsStream("generatorProperites-sharding.txt"));
	}
}