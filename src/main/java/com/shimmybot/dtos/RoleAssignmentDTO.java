package com.shimmybot.dtos;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class RoleAssignmentDTO {
    private UUID id;
    private UserDTO user;
    private RoleDTO role;
    private ZonedDateTime assignedOn;
    private ZonedDateTime revokedOn;
}
