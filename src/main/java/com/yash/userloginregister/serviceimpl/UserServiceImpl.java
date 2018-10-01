package com.yash.userloginregister.serviceimpl;

import com.yash.userloginregister.model.User;
import com.yash.userloginregister.repository.UserRepository;
import com.yash.userloginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User authenticateUser(User user) {
        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    @Override
    public User findIfEmailExists(String email) {
        return userRepository.findByEmail(email);
    }
}
