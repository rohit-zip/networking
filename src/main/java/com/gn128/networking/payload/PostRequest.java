package com.gn128.networking.payload;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequest {

    private String title;
    private String description;
}
