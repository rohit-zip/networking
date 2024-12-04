package com.gn128.networking.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author - rohit
 * Project - networking
 * Package - com.gn128.networking.payload
 * Created_on - December 04 - 2024
 * Created_at - 19:10
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private String email;
    private String password;
}
