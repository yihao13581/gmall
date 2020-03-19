package com.itzyzx.gmall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @CLassName GmallUserServiceApplication
 * @Description: TODO
 * @date: 2020/3/18 17:14
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.itzyzx.gmall.user.mapper")
public class GmallUserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GmallUserServiceApplication.class,args);
	}
}
