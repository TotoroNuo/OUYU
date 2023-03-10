package com.ouyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author a1315
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ouyu.mapper")
public class OuyuApplication {

	public static void main(String[] args) {
		SpringApplication.run(OuyuApplication.class, args);
	}

}
