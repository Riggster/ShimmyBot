package com.shimmybot.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.shimmybot.domains.RoleAssignment;
import com.shimmybot.dtos.RoleAssignmentDTO;

@Mapper(uses = {UserMapper.class, RoleMapper.class})
public interface RoleAssignmentMapper {
    RoleAssignmentMapper INSTANCE = Mappers.getMapper(RoleAssignmentMapper.class);
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "assignedOn", target = "assignedOn")
    @Mapping(source = "revokedOn", target = "revokedOn")
    RoleAssignmentDTO roleAssignmentToRoleAssignmentDTO(RoleAssignment roleAssignment);
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "assignedOn", target = "assignedOn")
    @Mapping(source = "revokedOn", target = "revokedOn")
    RoleAssignment roleAssignmentDTOToRoleAssignment(RoleAssignmentDTO roleAssignmentDTO);
}
