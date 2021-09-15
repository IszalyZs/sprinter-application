package com.codecool.controller;

import com.codecool.model.dto.UserStoryDTO;
import com.codecool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class StoryController {
    private UserService userService;


    @Autowired
    public StoryController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllData(Model model) {
        model.addAttribute("userStory", userService.getAll());
        return "index";
    }

    @GetMapping("story")
    public String addUserStory(Model model) {
        UserStoryDTO userStoryDTO = new UserStoryDTO();
        model.addAttribute("userStoryDTO", userStoryDTO);
        return "storyPage";
    }

    @PostMapping("story")
    public String saveUserStory(@Valid UserStoryDTO userStoryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "storyPage";
        }
        userService.save(userStoryDTO);
        return "redirect:/";
    }

    @GetMapping("story/{id}")
    public String updateUserStory(@PathVariable("id") Long id, Model model) {
        UserStoryDTO userStoryDTO = userService.findById(id);
        model.addAttribute("userStoryDTO", userStoryDTO);
        return "storyPage";
    }

}
