package com.gn128.networking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Author - rohit
 * Project - networking
 * Package - com.gn128.networking.entity
 * Created_on - November 29 - 2024
 * Created_at - 20:27
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    private String roleId;
    private String role;
}
