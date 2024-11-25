package com.shimmybot.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shimmybot.domains.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
