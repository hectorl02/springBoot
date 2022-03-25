package com.hectorl.fundamentos.configuration;

import com.hectorl.fundamentos.bean.MyBeanProperties;
import com.hectorl.fundamentos.bean.MyBeanPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
