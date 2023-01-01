package edu.global.ex.controller;

import edu.global.ex.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
/* RestController 기존의 JSP 기반의 Controller 가 아님을 알려준다.
Restful 기반임을 알려주는 애너테이션 */
@RestController
@RequestMapping("/restful")
public class RestfullController {

//    @Autowired
//    private UserMapper userMapper;

    @GetMapping("/")
    public String restMain() {

        return "안녕히 가세요!";
    }


}
