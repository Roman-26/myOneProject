package com.roma.mainproject.service;

import com.roma.mainproject.dto.UserDTO;
import com.roma.mainproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findOne(Long id);
    Optional<User> findOne(String username);
    void delete(Long id);
    void delete(String username);
    List<User> findAll();
    void registerNewUserDTO(UserDTO userDTO);

}
