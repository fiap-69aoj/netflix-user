package com.netflix.netflixuser.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 26/10/2019 15:49
 */
@Builder
@Getter
@ToString
public class UserRequest implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private String email;

    private String phone;

    @NotNull
    private String password;

}
