package org.boot.spring_many.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.boot.spring_many.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String password;
    private RoleDTO role;

    public UserDTO(int id, String name, Role role) {
        this.name = name;
        this.role = new RoleDTO(role.getId(), role.getName());
    }

    public UserDTO(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
