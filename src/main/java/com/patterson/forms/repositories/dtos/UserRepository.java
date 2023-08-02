package com.patterson.forms.repositories.dtos;

import com.patterson.forms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
