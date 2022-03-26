package com.hectorl.fundamentos.configuration;

import com.hectorl.fundamentos.bean.MyBeanProperties;
import com.hectorl.fundamentos.bean.MyBeanPropertiesImplement;
import com.hectorl.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;
    @Value("${value.lastname}")
    private String apellido;
    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanProperties function(){
        return new MyBeanPropertiesImplement(name,apellido);
    }

    @Bean
    public DataSource dataSource () {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("hector");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

}
