package com.yobombel.homesuppliesmonitor.repository;

import com.yobombel.homesuppliesmonitor.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}