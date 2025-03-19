package org.example.backend.service;


import org.example.backend.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);


    UserDTO loadUserDetailsByUsername(String email);
}