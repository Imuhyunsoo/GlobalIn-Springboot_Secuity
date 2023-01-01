package edu.global.ex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "main";
    }

    @GetMapping("/user/userHome")
    public String userHome() {

        log.info("userHome() ..");

        return "user/userHome";
    }

    @GetMapping("/admin/adminHome")
    public void adminHome() {

        log.info("adminHome() ..");

        // return "admin/adminHome"; void 설정 시 String return 값으로 전달 하는 방식과 동일한 방식이다.
    }
}
