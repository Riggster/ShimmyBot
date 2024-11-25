package com.shimmybot.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shimmybot.domains.User;
import com.shimmybot.dtos.UserDTO;
import com.shimmybot.mappers.UserMapper;
import com.shimmybot.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        User createdUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(createdUser);
    }

    public UserDTO getUserById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.INSTANCE.userToUserDTO(user.get());
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
            .map(UserMapper.INSTANCE::userToUserDTO)
            .collect(Collectors.toList());
    }

    public UserDTO updateUser(UUID id, UserDTO userDetails) {
        User user = userRepository.findById(id).get();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setIsActive(userDetails.getIsActive());
        User updatedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(updatedUser);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
