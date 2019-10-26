package com.netflix.netflixuser.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 26/10/2019 15:48
 */
@Builder
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;

}
