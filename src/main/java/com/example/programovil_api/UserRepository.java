package com.example.programovil_api;


import java.util.List;

import org.springframework.data.repository.Repository;


public interface UserRepository extends Repository<User,Integer> {
    User findByEmail(String email);
    void save(User user);
    List<User> findAll();
}
