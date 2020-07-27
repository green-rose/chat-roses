package com.gfa.chat.controllers;

import com.gfa.chat.models.User;
import com.gfa.chat.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {

    public MainController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;


    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("user")==null) return "redirect:/register";
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    String registered(@ModelAttribute User user, Model m) {
        ResponseEntity<?> response = this.userService.registered(user);
        if (response.getStatusCode()== HttpStatus.OK){
            m.addAttribute((User) response.getBody());
            return "login";
        } else {
            m.addAttribute((User) response.getBody());
            return "errorPage";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    String toLogin(@ModelAttribute User user, Model m, HttpSession session) {
        ResponseEntity<?> response = this.userService.login(user);
        if (response.getStatusCode()== HttpStatus.OK){
            User loggedUser = (User)response.getBody();
            m.addAttribute("user",loggedUser);
            session.setAttribute("user", loggedUser);
            return "index";
        } else {
            m.addAttribute((User) response.getBody());
            return "errorPage";
        }
    }

    @GetMapping("/update")
    public String update(HttpSession session){
        if (session.getAttribute("user")==null) return "redirect:/register";
        return "update";
    }

    @PostMapping("/update")
    String toUpdate(@ModelAttribute User user, Model m, HttpSession session) {
        ResponseEntity<?> response = this.userService.update(user);
        if (response.getStatusCode()== HttpStatus.OK){
            User loggedUser = (User)response.getBody();
            m.addAttribute("user",loggedUser);
            session.setAttribute("user", (loggedUser));
            return "index";
        } else {
            m.addAttribute((User) response.getBody());
            return "errorPage";
        }
    }


}
