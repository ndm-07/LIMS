package com.example.claim.controller;

import com.example.claim.bean.Claim;
import com.example.claim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/home")
    public ModelAndView showClaimsHome() {
        ModelAndView mav = new ModelAndView("claims-home");

        // Pass the list to the UI
        mav.addObject("claims", claimService.getAllClaims());

        // Pass a blank object for the 'File New Claim' form
        mav.addObject("newClaim", new Claim());

        return mav;
    }

    @PostMapping("/add")
    public String addClaim(@ModelAttribute("newClaim") Claim claim) {
        claimService.submitClaim(claim);
        return "redirect:/claims/home";
    }

    @GetMapping("/view/{id}")
    public ModelAndView getClaimDetails(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("claim-details");
        Claim claim = claimService.getClaimDetails(id);
        mav.addObject("claim", claim);
        return mav;
    }
}