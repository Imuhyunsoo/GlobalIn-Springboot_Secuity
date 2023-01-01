package edu.global.ex.mapper;

import edu.global.ex.vo.UserVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testGetUser() {
        UserVO user = userMapper.getUser("user");
        System.out.println(user);

        UserVO admin = userMapper.getUser("admin");
        System.out.println(admin);

        UserVO member = userMapper.getUser("member");
        System.out.println(member);

        UserVO john = userMapper.getUser("john");
        System.out.println(john);
    }

    @Test
    // 암호화 하지 않고 데이터베이스에 넣을 경우
    void testInsertUser() {

        UserVO user = new UserVO();
        user.setUsername("john");
        user.setPassword("john");
        user.setEnabled(1);

        userMapper.insertUser(user);
        userMapper.insertAuthorities(user);
    }

    @Disabled
    @Test
    void testInsertUser2() {

        UserVO user = new UserVO();
        user.setUsername("john2");
        user.setPassword(new BCryptPasswordEncoder().encode("john2"));
        user.setEnabled(1);

        userMapper.insertUser(user);
        userMapper.insertAuthorities(user);
    }

    @Test
    void testCheckJohe2() {

        UserVO user = userMapper.getUser("john2");

        boolean isPass = new BCryptPasswordEncoder().matches("john2", user.getPassword());

        System.out.println(isPass);
    }
}