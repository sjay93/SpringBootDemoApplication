package com.yash.userloginregister.service;

import com.yash.userloginregister.model.User;

public interface UserService {
    void saveUser(User user);

    User authenticateUser(User user);

    User findIfEmailExists(String email);
}
