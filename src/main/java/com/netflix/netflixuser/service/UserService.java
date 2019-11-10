package com.netflix.netflixuser.service;

import com.netflix.netflixuser.converter.UserConverter;
import com.netflix.netflixuser.dto.UserRequest;
import com.netflix.netflixuser.dto.UserResponse;
import com.netflix.netflixuser.entity.UserEntity;
import com.netflix.netflixuser.repository.UserRepository;
import com.netflix.netflixuser.kafka.producer.UserCreatedProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 20/10/2019 22:46
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserCreatedProducer userCreatedProducer;

    public UserResponse save(final UserRequest userRequest) {
        UserEntity userEntity = userRepository.save(userConverter.toUserEntity(userRequest));
        final UserResponse userResponse = userConverter.toUserResponse(userEntity);
        userCreatedProducer.sendMessage(userConverter.toUserConverter(userResponse));
        return userResponse;
    }

    public UserResponse findUserByEmailAndPassword(final String email, final String password) {
        final Optional<UserEntity> userResult = userRepository.findByEmailAndPassword(email, password);
        if(userResult.isPresent()) {
            return userConverter.toUserResponse(userResult.get());
        }
        return null;
    }

}
