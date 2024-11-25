package com.shimmybot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimmybot.dtos.RoleAssignmentDTO;
import com.shimmybot.services.RoleAssignmentService;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/auth/role-assignments")
public class RoleAssignmentController {

    private final RoleAssignmentService roleAssignmentService;

    public RoleAssignmentController(RoleAssignmentService roleAssignmentService) {
        this.roleAssignmentService = roleAssignmentService;
    }

    @PostMapping
    public ResponseEntity<RoleAssignmentDTO> createRoleAssignment(@RequestBody RoleAssignmentDTO roleAssignment) {
        RoleAssignmentDTO createdRoleAssignment = roleAssignmentService.createRoleAssignment(roleAssignment);
        return ResponseEntity.ok(createdRoleAssignment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleAssignmentDTO> getRoleAssignmentById(@PathVariable UUID id) {
        RoleAssignmentDTO roleAssignment = roleAssignmentService.getRoleAssignmentById(id);
        return ResponseEntity.ok(roleAssignment);
    }

    @GetMapping
	public ResponseEntity<List<RoleAssignmentDTO>> getAllRoleAssignments() {
		List<RoleAssignmentDTO> roleAssignments = roleAssignmentService.getAllRoleAssignments();
		return ResponseEntity.ok(roleAssignments);
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<RoleAssignmentDTO> updateRoleAssignment(@PathVariable UUID id, @RequestBody RoleAssignmentDTO roleAssignmentDetails) {
        RoleAssignmentDTO updatedRoleAssignment = roleAssignmentService.updateRoleAssignment(id, roleAssignmentDetails);
        return ResponseEntity.ok(updatedRoleAssignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleAssignment(@PathVariable UUID id) {
        roleAssignmentService.deleteRoleAssignment(id);
        return ResponseEntity.noContent().build();
    }
    
}
