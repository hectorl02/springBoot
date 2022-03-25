package com.hectorl.fundamentos.configuration;

import com.hectorl.fundamentos.bean.MyBeanProperties;
import com.hectorl.fundamentos.bean.MyBeanPropertiesImplement;
import com.hectorl.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
