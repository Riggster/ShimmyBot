package com.shimmybot.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import com.shimmybot.dtos.RoleDTO;
import com.shimmybot.domains.Role;

@Mapper(uses = {RoleMapper.class})
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "isActive", source = "isActive")
    RoleDTO roleToRoleDTO(Role role);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "isActive", source = "isActive")
    @Mapping(target = "roleAssignments", ignore = true)
    Role roleDTOToRole(RoleDTO roleDTO);
}
