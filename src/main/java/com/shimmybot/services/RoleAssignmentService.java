package com.shimmybot.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shimmybot.domains.Role;
import com.shimmybot.domains.RoleAssignment;
import com.shimmybot.domains.User;
import com.shimmybot.dtos.RoleAssignmentDTO;
import com.shimmybot.mappers.RoleAssignmentMapper;
import com.shimmybot.repositories.RoleAssignmentRepository;
import com.shimmybot.repositories.RoleRepository;
import com.shimmybot.repositories.UserRepository;

@Service
public class RoleAssignmentService {
    
    private final RoleAssignmentRepository roleAssignmentRepository;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
		
	public RoleAssignmentService(RoleAssignmentRepository roleAssignmentRepository, RoleRepository roleRepository, UserRepository userRepository) {
		this.roleAssignmentRepository = roleAssignmentRepository;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}

    public RoleAssignmentDTO createRoleAssignment(RoleAssignmentDTO dto) {
		
		User user = userRepository.findById(dto.getUser().getId()).get();
		Role role = roleRepository.findById(dto.getRole().getId()).get();
		RoleAssignment roleAssignment = RoleAssignment.builder()
			.user(user)
			.role(role)
			.assignedOn(dto.getAssignedOn())
			.revokedOn(dto.getRevokedOn())
			.build();
			
		RoleAssignment createdRoleAssignment = roleAssignmentRepository.save(roleAssignment);
		return RoleAssignmentMapper.INSTANCE.roleAssignmentToRoleAssignmentDTO(createdRoleAssignment);
	}

	public RoleAssignmentDTO getRoleAssignmentById(UUID id) {
		Optional<RoleAssignment> roleAssignment = roleAssignmentRepository.findById(id);
		return RoleAssignmentMapper.INSTANCE.roleAssignmentToRoleAssignmentDTO(roleAssignment.get());
	}

	public List<RoleAssignmentDTO> getAllRoleAssignments() {
		List<RoleAssignment> roleAssignments = roleAssignmentRepository.findAll();
		return roleAssignments.stream()
            .map(RoleAssignmentMapper.INSTANCE::roleAssignmentToRoleAssignmentDTO)
            .collect(Collectors.toList());
	}

	public RoleAssignmentDTO updateRoleAssignment(UUID id, RoleAssignmentDTO dto) {
		Optional<RoleAssignment> roleAssignmentOptional = roleAssignmentRepository.findById(id);
		Optional<User> user = userRepository.findById(dto.getUser().getId());
		Optional<Role> role = roleRepository.findById(dto.getRole().getId());
		RoleAssignment roleAssignment = roleAssignmentOptional.get();
		roleAssignment.setUser(user.get());
		roleAssignment.setRole(role.get());
		roleAssignment.setAssignedOn(dto.getAssignedOn());
		roleAssignment.setRevokedOn(dto.getRevokedOn());
		RoleAssignment updatedRoleAssignment = roleAssignmentRepository.save(roleAssignment);
		return RoleAssignmentMapper.INSTANCE.roleAssignmentToRoleAssignmentDTO(updatedRoleAssignment);
	}

	public void deleteRoleAssignment(UUID id) {
		roleAssignmentRepository.deleteById(id); 
	}
}
