package com.yash.userloginregister.repository;

import com.yash.userloginregister.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Find by user name and password user.
     *
     * @param userName the user name
     * @param password the password
     * @return the user
     */
    User findByUserNameAndPassword(String userName, String password);

    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    User findByEmail(String email);
}
