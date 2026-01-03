package com.example.auth.controller;

import com.example.auth.bean.User;
import com.example.auth.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/submit-login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Optional<User> userOpt = authService.authenticate(email, password);
        if (userOpt.isPresent()) {
            session.setAttribute("user", userOpt.get());
            return "redirect:/landingpage";
        }
        return "redirect:/auth/login?error=true";
    }

    @PostMapping("/submit-register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        boolean isSaved = authService.registerUser(user);
        if (isSaved) {
            return new ModelAndView("redirect:/auth/login?registered=true");
        }
        return new ModelAndView("Failure");
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/landingpage";
    }
}