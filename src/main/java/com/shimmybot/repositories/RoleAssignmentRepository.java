package com.shimmybot.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shimmybot.domains.RoleAssignment;

public interface RoleAssignmentRepository extends JpaRepository<RoleAssignment, UUID> {
    
}
