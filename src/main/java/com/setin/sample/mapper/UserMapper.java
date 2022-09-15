package com.setin.sample.mapper;

import com.setin.sample.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<UserDto> selectUsers();

    UserDto selectUser(int i);

    void insertUser(UserDto newUser);

    void deleteUser(int id);
}
