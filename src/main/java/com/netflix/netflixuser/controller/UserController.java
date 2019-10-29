package com.netflix.netflixuser.controller;

import com.netflix.netflixuser.dto.UserRequest;
import com.netflix.netflixuser.dto.UserResponse;
import com.netflix.netflixuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 20/10/2019 22:45
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody final UserRequest userRequest) {
        final UserResponse userResponse = userService.save(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<String> teste() {
        return new ResponseEntity<>("Teste", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserResponse> findUserByEmailAndPassword(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password) {
        final UserResponse userResponse = userService.findUserByEmailAndPassword(email, password);
        if(userResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    
}
