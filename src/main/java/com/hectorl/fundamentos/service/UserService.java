package com.hectorl.fundamentos.service;

import com.hectorl.fundamentos.entity.User;
import com.hectorl.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional (List<User> users) {
        users.stream()
                .peek(user -> LOG.info("usuario_add: "+ user))
                //.forEach(user -> userRepository.save(user));
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User save(User newUser) {
        return  userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User upDate(User newUser, Long id) {
        return userRepository.findById(id)
        .map( user -> {
                user.setEmail(newUser.getEmail());
                user.setName(newUser.getName());
                user.setBirthDate(newUser.getBirthDate());
                return userRepository.save(user);
            }
        ).get();
    }
}

