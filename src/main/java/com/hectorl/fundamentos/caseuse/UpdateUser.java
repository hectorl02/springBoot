package com.hectorl.fundamentos.caseuse;

import com.hectorl.fundamentos.entity.User;
import com.hectorl.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService= userService;
    }

    public User update(User newUser, Long id) {
        return userService.upDate(newUser, id);
    }
}
