package com.gn128.networking.payload;

import lombok.*;

/**
 * Author - rohit
 * Project - networking
 * Package - com.gn128.networking.payload
 * Created_on - December 04 - 2024
 * Created_at - 19:23
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String accessToken;
    private Integer userId;
}
