package com.hectorl.fundamentos.configuration;

import com.hectorl.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation (){
        // return new MyBeanImplement();
        // nueva "version"
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation (){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency (MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }

}
