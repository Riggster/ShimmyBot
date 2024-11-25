package com.shimmybot.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shimmybot.domains.Role;

public  interface RoleRepository extends JpaRepository<Role, UUID> {
    
}
