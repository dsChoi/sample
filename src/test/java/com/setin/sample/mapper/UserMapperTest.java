package com.setin.sample.mapper;

import com.setin.sample.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest
@Transactional
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectUsers() {
        List<UserDto> userDtos = userMapper.selectUsers();
        log.info("userDtos = {}", userDtos);
        assertThat(userDtos).isNotNull();
        assertThat(userDtos.size()).isGreaterThan(1);
    }

    @Test
    void selectUser() {
        UserDto user = userMapper.selectUser(1);
        log.info("user = {}", user);
        assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Rollback
    void createUser() {
        UserDto newUser = new UserDto();
        newUser.setId(3);
        newUser.setName("test");
        newUser.setHpNo("010-010-0101");
        userMapper.insertUser(newUser);
        UserDto userDto = userMapper.selectUser(3);
        assertThat(userDto).isNotNull();
        assertThat(userDto.getId()).isEqualTo(3);
    }

}