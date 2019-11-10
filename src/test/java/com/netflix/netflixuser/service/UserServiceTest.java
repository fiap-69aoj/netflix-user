package com.netflix.netflixuser.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.netflix.netflixuser.dto.UserRequest;
import com.netflix.netflixuser.dto.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 07/11/2019 08:23
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp () {
    }

    @Test
    void saveShouldReturnSuccess () {
        final UserRequest newUser = UserRequest.builder()
                .name("Daenerys Targaryen")
                .email("daenerys.targaryen@gmail.com")
                .password("drogon.viserion.rhaegal")
                .build();

        final UserResponse usrDaenerys = userService.save(newUser);

        assertNotNull(usrDaenerys);
        assertNotNull(usrDaenerys.getId());
        assertEquals("Daenerys Targaryen", usrDaenerys.getName());
    }

    @Test
    void save () {
        final UserRequest newUser = UserRequest.builder()
                .name("Daenerys Targaryen")
                .email("daenerys.targaryen@gmail.com")
                .build();

        assertThrows(ConstraintViolationException.class, () -> {
            userService.save(newUser);
        });
    }

    @Test
    void findUserShouldReturnUser () {
        final UserResponse usrFlavio = userService.findUserByEmailAndPassword("flavio@fiap.com",
                "$2y$12$5ksm2T4qeqZJfbvlXcqkY.dhvfpREdiPtulnkkuArzdjUi9miI4eu");

        assertNotNull(usrFlavio);
        assertEquals("flavio", usrFlavio.getName());
    }

    @Test
    void findUserShouldReturnNullWhenUserIsInvalid () {
        final UserResponse usrFlavio = userService.findUserByEmailAndPassword("flavio@fiap.com",
                "teste");

        assertNull(usrFlavio);
    }
}