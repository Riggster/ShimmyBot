package com.shimmybot.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shimmybot.domains.Role;
import com.shimmybot.dtos.RoleDTO;
import com.shimmybot.mappers.RoleMapper;
import com.shimmybot.repositories.RoleRepository;

@Service
public class RoleService {
    
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = RoleMapper.INSTANCE.roleDTOToRole(roleDTO);
        Role createdRole = roleRepository.save(role);
        return RoleMapper.INSTANCE.roleToRoleDTO(createdRole);
    }

    public RoleDTO getRoleById(UUID id) {
        Optional<Role> role = roleRepository.findById(id);
        return RoleMapper.INSTANCE.roleToRoleDTO(role.get());
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
            .map(RoleMapper.INSTANCE::roleToRoleDTO)
            .collect(Collectors.toList());
    }

    public RoleDTO updateRole(UUID id, RoleDTO roleDetails) {
        Role role = roleRepository.findById(id).get();
        role.setName(roleDetails.getName());
        role.setDescription(roleDetails.getDescription());
        role.setIsActive(roleDetails.getIsActive());
        Role updatedRole = roleRepository.save(role);
        return RoleMapper.INSTANCE.roleToRoleDTO(updatedRole);
    }

    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }
}
