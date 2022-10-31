package com.yobombel.homesuppliesmonitor.Repository;

import com.yobombel.homesuppliesmonitor.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}