package org.example.backend.controller;

import jakarta.validation.Valid;
import org.example.backend.dto.AuthDTO;
import org.example.backend.dto.ResponseDTO;
import org.example.backend.dto.UserDTO;
import org.example.backend.entity.Role;
import org.example.backend.service.UserService;
import org.example.backend.util.JwtUtil;
import org.example.backend.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    //constructor injection
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            int res = userService.saveUser(userDTO);
            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    System.out.println(token);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", authDTO.getToken()));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody @Valid AuthDTO authDTO) {
        try {
            UserDTO userDTO = userService.loadUserDetailsByUsername(authDTO.getEmail());
            if (userDTO == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "User Not Found", null));
            }
            String token = jwtUtil.generateToken(userDTO);
            if (token == null || token.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new ResponseDTO(VarList.Conflict, "Authorization Failure! Please Try Again", null));
            }
            AuthDTO authDTO1 = new AuthDTO();
            authDTO1.setEmail(userDTO.getEmail());
            authDTO1.setToken(token);
            authDTO1.setRole(Role.valueOf(userDTO.getRole()));
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Success", authDTO1));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

}
