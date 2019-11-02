package com.netflix.netflixuser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 26/10/2019 15:48
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;

}
