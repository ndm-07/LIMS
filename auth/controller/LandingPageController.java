package com.example.auth.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    /**
     * Shows the LifeShield Home Page.
     * The cards in landing-page.html will check the session.user automatically.
     */
    @GetMapping("/landingpage")
    public String showLandingPage() {
        return "landing-page";
    }

    /**
     * Protects the profile route.
     * If session is empty, it redirects back to login.
     */
//    @GetMapping("/profile")
//    public ModelAndView viewProfile(HttpSession session) {
//        User loggedInUser = (User) session.getAttribute("user");
//
//        if (loggedInUser == null) {
//            // If someone types /profile manually without logging in
//            return new ModelAndView("redirect:/auth/login");
//        }
//
//        ModelAndView mav = new ModelAndView("user-profile");
//        mav.addObject("user", loggedInUser);
//        return mav;
//    }

    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        // Safe check: verify user is actually in session
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        return "user-profile"; // This must match user-profile.html exactly
    }

    @GetMapping("/support")
    public String showSupportPage() {
        // This looks for src/main/resources/templates/support.html
        return "support";
    }
}