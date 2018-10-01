package com.yash.userloginregister.repository;

import com.yash.userloginregister.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserNameAndPassword(String userName, String password);

    User findByEmail(String email);
}
