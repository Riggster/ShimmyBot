package com.shimmybot.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class UserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Boolean isActive;
}
