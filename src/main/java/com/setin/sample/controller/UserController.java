package com.setin.sample.controller;

import com.setin.sample.dto.UserDto;
import com.setin.sample.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserMapper mapper;


    @GetMapping
    public List<UserDto> getUsers() {
        return mapper.selectUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUsers(@PathVariable("id") int id) {
        return mapper.selectUser(id);
    }


    @PostMapping
    public UserDto insertUser(@RequestBody UserDto userDto) {
         mapper.insertUser(userDto);
         return mapper.selectUser(userDto.getId());
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        mapper.deleteUser(id);
    }


}
