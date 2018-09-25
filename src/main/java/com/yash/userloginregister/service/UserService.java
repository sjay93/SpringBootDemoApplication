package com.yash.userloginregister.service;

import com.yash.userloginregister.model.User;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Save user.
     *
     * @param user the user
     */
    void saveUser(User user);

    /**
     * Authenticate user user.
     *
     * @param user the user
     * @return the user
     */
    User authenticateUser(User user);

    /**
     * Find if email exists user.
     *
     * @param email the email
     * @return the user
     */
    User findIfEmailExists(String email);
}
