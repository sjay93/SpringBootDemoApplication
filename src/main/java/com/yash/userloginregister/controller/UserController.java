package com.yash.userloginregister.controller;

import com.yash.userloginregister.model.User;
import com.yash.userloginregister.model.UserDetail;
import com.yash.userloginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/addUser")
    public String registerUser(@Valid @ModelAttribute User user, @Valid @ModelAttribute UserDetail userDetail) {
        User userExists = userService.findIfEmailExists(user.getEmail());
        if (userExists != null)
            return "register";
        else {
            user.setUserDetail(userDetail);
            userDetail.setUser(user);
            userService.saveUser(user);
            return "login";
        }
    }

    @PostMapping("/authenticateUser")
    public String authenticateUser(@RequestParam String userName, @RequestParam String password, Model model) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User user1 = userService.authenticateUser(user);
        if (user1 == null) {
            return "login";
        }
        model.addAttribute("user", user1.getUserDetail());
        return "welcome";
    }

    @GetMapping("/register")
    public String openRegister() {
        return "register";
    }

}
