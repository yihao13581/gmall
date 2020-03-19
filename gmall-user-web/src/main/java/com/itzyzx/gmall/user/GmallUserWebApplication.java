package com.itzyzx.gmall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @CLassName GmallUserWebApplication
 * @Description: TODO
 * @date: 2020/3/18 17:33
 * @Version 1.0
 */
@SpringBootApplication
public class GmallUserWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(GmallUserWebApplication.class,args);
	}
}
