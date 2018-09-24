package com.yash.userloginregister.serviceimpl;

import com.yash.userloginregister.entity.User;
import com.yash.userloginregister.repository.UserRepository;
import com.yash.userloginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */
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
