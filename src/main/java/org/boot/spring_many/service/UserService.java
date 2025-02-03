package org.boot.spring_many.service;

import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.boot.spring_many.dto.UserDTO;
import org.boot.spring_many.entity.Role;
import org.boot.spring_many.entity.User;
import org.boot.spring_many.exceptions.NoUsersFoundException;
import org.boot.spring_many.repository.RoleRepository;
import org.boot.spring_many.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinylog.Logger;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void saveWithRole(UserDTO dto) {
        Role role = roleRepository.findByName(dto.getRole().getName())
                .orElseThrow(() -> new NullPointerException("Role not found with name: " + dto.getRole().getName()));
        User user = new User();
        user.setUsername(dto.getName());
        user.setPassword(dto.getPassword());
        user.setRole(role);

        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.findAllUsers();

        if (users == null || users.isEmpty()) {
            Logger.error("No users found in the database");
            throw new NoUsersFoundException("No users found in the system");
        }

        return users;
    }

    @Transactional
    public List<UserDTO> getUsersByRole(String roleName) {
        return userRepository.findAllUsersByRoleName(roleName)
                .stream()
                .map(UserDTO::new)
                .toList();
    }
}
