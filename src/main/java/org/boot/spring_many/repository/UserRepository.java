package org.boot.spring_many.repository;

import org.boot.spring_many.dto.UserDTO;
import org.boot.spring_many.entity.Role;
import org.boot.spring_many.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new org.boot.spring_many.dto.UserDTO(u.id, u.username, u.role) from User u")
    List<UserDTO> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.role.name = :roleName")
    List<User> findAllUsersByRoleName(@Param("roleName") String roleName);
}
