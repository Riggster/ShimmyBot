package com.shimmybot.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimmybot.dtos.RoleDTO;
import com.shimmybot.services.RoleService;

@RestController
@RequestMapping("/api/auth/roles")
public class RoleController {

	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping
	public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO role) {
		RoleDTO createdRole = roleService.createRole(role);
		return ResponseEntity.ok(createdRole);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RoleDTO> getRoleById(@PathVariable UUID id) {
		RoleDTO role = roleService.getRoleById(id);
		return ResponseEntity.ok(role);
	}

	@GetMapping
	public ResponseEntity<List<RoleDTO>> getAllRoles() {
		List<RoleDTO> roles = roleService.getAllRoles();
		return ResponseEntity.ok(roles);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RoleDTO> updateRole(@PathVariable UUID id, @RequestBody RoleDTO roleDetails) {
		RoleDTO updatedRole = roleService.updateRole(id, roleDetails);
        return ResponseEntity.ok(updatedRole);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
		roleService.deleteRole(id);
		return ResponseEntity.noContent().build();
	}
}
