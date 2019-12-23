package com.test.demo.event.test2.controller;

import com.test.demo.event.test2.service.UserService;
import com.test.demo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class User2Controller {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(HttpServletRequest request){
        /*ServletContext application = request.getServletContext();
        User user = (User)application.getAttribute("user");
        System.out.println("user:" + user);*/

        User user = this.userService.getUser2();
        return user;
    }
}
