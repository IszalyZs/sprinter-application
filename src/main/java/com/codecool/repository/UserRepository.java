package com.codecool.repository;

import com.codecool.model.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserStory, Long> {
}
