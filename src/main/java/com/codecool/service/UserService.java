package com.codecool.service;

import com.codecool.dao.ServiceDAO;
import com.codecool.model.dto.UserStoryDTO;
import com.codecool.model.entity.UserStory;
import com.codecool.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceDAO {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserStory> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserStoryDTO userStoryDTO) {
        userRepository.save(modelMapper.map(userStoryDTO, UserStory.class));
    }

    @Override
    public UserStoryDTO findById(Long id) {
        Optional<UserStory> optionalUserStory = userRepository.findById(id);
        if (optionalUserStory.isPresent()) {
            return modelMapper.map(optionalUserStory.get(), UserStoryDTO.class);
        } else return null;
    }
}
