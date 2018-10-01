package com.yash.userloginregister.repository;

import com.yash.userloginregister.model.UserDetail;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailRepository extends CrudRepository<UserDetail, Integer> {
}
