package com.nseit.blogSpringBoot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private Integer id;
    private String userName;
    private String role;
}
