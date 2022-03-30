package com.hectorl.fundamentos.caseuse;

import com.hectorl.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService= userService;
    }

    public void remove(Long id) {
        userService.delete(id);
    }
}
