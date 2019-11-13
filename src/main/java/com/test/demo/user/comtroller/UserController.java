package com.test.demo.user.comtroller;

import com.test.demo.user.all.MyHttpSessionListener;
import com.test.demo.user.model.User;
import com.test.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/user-save")
    public Object userList(@RequestBody User user) {
        int i = this.userService.insert(user);
        return i;
    }

    @GetMapping(value="/user-info/{id}")
    public Object getUserInfo(@PathVariable("id") Integer id) {
        User user = this.userService.selectByPrimaryKey(id);
        return user;
    }

    @GetMapping("/index")
    public Object index(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("zxc", "zxc");
        return  "index";
    }

    @GetMapping("/online")
    public Object online() {
        return  "当前在线人数：" + MyHttpSessionListener.online + "人";
    }
}