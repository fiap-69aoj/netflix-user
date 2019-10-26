package com.netflix.netflixuser.converter;

import com.netflix.netflixuser.dto.UserRequest;
import com.netflix.netflixuser.dto.UserResponse;
import com.netflix.netflixuser.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 26/10/2019 15:48
 */
@Component
public class UserConverter {

    public UserEntity toUserEntity(final UserRequest userRequest) {
        return UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phone(userRequest.getPhone())
                .build();
    }

    public UserResponse toUserResponse(final UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phone(userEntity.getPhone())
                .build();
    }

}
