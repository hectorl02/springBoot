package com.hectorl.fundamentos.configuration;

import com.hectorl.fundamentos.caseuse.GetUser;
import com.hectorl.fundamentos.caseuse.GetUserImplement;
import com.hectorl.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }
}
