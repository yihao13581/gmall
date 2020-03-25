package com.itzyzx.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @CLassName GmallManageServiceApplication
 * @Description: TODO
 * @date: 2020/3/20 9:36
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.itzyzx.gmall.manage.mapper")
public class GmallManageServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GmallManageServiceApplication.class,args);
	}
}
