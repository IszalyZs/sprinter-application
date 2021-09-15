package com.codecool.dao;

import com.codecool.model.dto.UserStoryDTO;
import com.codecool.model.entity.UserStory;

import java.util.List;

public interface ServiceDAO {
    List<UserStory> getAll();

    void save(UserStoryDTO userStoryDTO);

    UserStoryDTO findById(Long id);
}
