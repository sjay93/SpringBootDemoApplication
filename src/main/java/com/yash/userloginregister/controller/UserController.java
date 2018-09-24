package com.yash.userloginregister.controller;

import com.yash.userloginregister.entity.User;
import com.yash.userloginregister.entity.UserDetail;
import com.yash.userloginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * The type User controller.
 */
@Controller
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Index string.
     *
     * @return the string
     */
    @GetMapping("/")
    public String index() {
        return "login";
    }

    /**
     * Register user string.
     *
     * @param user       the user
     * @param userDetail the user detail
     * @return the string
     */
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

    /**
     * Authenticate user string.
     *
     * @param user          the user
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @PostMapping("/authenticateUser")
    public String authenticateUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        User user1 = userService.authenticateUser(user);
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("firstName", user1.getUserDetail().getFirstName());
        model.addAttribute("lastName", user1.getUserDetail().getLastName());
        return "welcome";
    }

    /**
     * Open register string.
     *
     * @return the string
     */
    @GetMapping("/register")
    public String openRegister() {
        return "register";
    }

}
