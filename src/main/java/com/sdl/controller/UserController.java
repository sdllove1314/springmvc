package com.sdl.controller;
import com.sdl.model.User;
import com.sdl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/hello")
public class UserController {
    @Resource
    public UserService userService;
    @GetMapping("/hi")
    public String findAll(){
        User user = userService.findAll(1001);
        System.out.println(user);
        return "hello";
    }
}
