package com.sdl.controller;

import com.sdl.model.User;
import com.sdl.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Resource
    LoginService loginService;

    @RequestMapping("/login")
    public String userlogin(){
        return "login";
    }
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(User user, Model model, HttpServletRequest request){
        User loginUser = loginService.findUser(user.getUsername(),user.getUserpassword());
        if(loginUser!=null){
            request.getSession().setAttribute("loginUser",loginUser);
          //  model.addAttribute("loginUser",loginUser);
            String loginUserType = loginUser.getUsertype();
            System.out.println("=========>>>>>>>"+loginUserType);
            if (loginUserType.endsWith("admin")){
                System.out.println("转发到管理员登录页面=========>>>>>>>"+loginUserType);
                return "/admin/adminHome";
            } else if (loginUserType.endsWith("user")){
                System.out.println("转发到User登录页面=========>>>>>>>"+loginUserType);
                return "/user/userHome";
            } else if (loginUserType.endsWith("doctor")){
                System.out.println("转发到Doctor登录页面=========>>>>>>>"+loginUserType);
                return "/doctor/doctorHome";
            }
        }else{
            return "/error";
        }
        return "/login";
    }
}
