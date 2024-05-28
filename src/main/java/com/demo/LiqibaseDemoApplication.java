package com.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;


import liquibase.Liquibase;
import liquibase.integration.spring.SpringLiquibase;

@SpringBootApplication
public class LiqibaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiqibaseDemoApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/liqibase")
                .username("root")
                .password("Master@123")
                .build();
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/master.xml");
        return liquibase;
    }
}