package com.hectorl.fundamentos.caseuse;

import com.hectorl.fundamentos.entity.User;
import com.hectorl.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser {
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll(){
        return userService.getAllUsers();
    }

}
