package com.shimmybot.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class RoleDTO {
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive;
}
