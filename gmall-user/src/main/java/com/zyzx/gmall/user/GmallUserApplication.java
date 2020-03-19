package com.zyzx.gmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @CLassName GmallUserApplication
 * @Description: TODO
 * @date: 2020/3/18 17:08
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zyzx.gmall.user.mapper")
public class GmallUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(GmallUserApplication.class,args);
	}
}
