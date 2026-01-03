package com.example.beneficiary.controller;

import com.example.beneficiary.bean.Beneficiary;
import com.example.beneficiary.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping("/home")
    public ModelAndView showBeneficiaryPage() {
        ModelAndView mav = new ModelAndView("beneficiary-home");
        mav.addObject("beneficiaries", beneficiaryService.listAll());
        // Map the form to 'newBeneficiary' to match th:object in your HTML
        mav.addObject("newBeneficiary", new Beneficiary());
        return mav;
    }

    @PostMapping("/add")
    public String addBeneficiary(@ModelAttribute("newBeneficiary") Beneficiary beneficiary) {
        beneficiaryService.save(beneficiary);
        return "redirect:/beneficiary/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteBeneficiary(@PathVariable("id") int id) {
        beneficiaryService.remove(id);
        return "redirect:/beneficiary/home";
    }
}