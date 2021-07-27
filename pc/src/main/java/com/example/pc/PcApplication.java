package com.example.pc;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.example.pc","com.example.common"})
@MapperScan({"com.example.common.mapper","com.example.pc.mapper"})
public class PcApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder()
                .sources(PcApplication.class)
                .run(args);
    }

}
