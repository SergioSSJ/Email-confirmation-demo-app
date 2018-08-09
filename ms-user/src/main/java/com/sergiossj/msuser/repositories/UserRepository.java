package com.sergiossj.msuser.repositories;

import com.sergiossj.msuser.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
