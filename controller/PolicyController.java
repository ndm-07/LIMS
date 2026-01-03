package com.example.policy.controller;

import com.example.policy.bean.Policy;
import com.example.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    // 1. Policy Dashboard (Landing point from Main Home Page)
    @GetMapping("/home")
    public String showPolicyHome() {
        return "policy-home";
    }

    // 2. Show Add Policy Form
    @GetMapping("/add")
    public String showAddPolicyForm() {
        return "add-policy";
    }

    // 3. Save Policy (Consolidated for both form types)
    @PostMapping("/save")
    public String savePolicy(@ModelAttribute Policy policy) {
        policyService.savePolicy(policy);
        return "redirect:/policy/all";
    }

    // 4. View All Policies
    @GetMapping("/all")
    public ModelAndView getAllPolicies() {
        List<Policy> list = policyService.getAllPolicies();
        ModelAndView mav = new ModelAndView("policy-list");
        mav.addObject("policies", list);
        return mav;
    }

    // 5. Search by Policy Number (For the search bar in policy-home.html)
    @GetMapping("/view-by-number")
    public ModelAndView viewPolicyByNumber(@RequestParam("policyNumber") String policyNumber) {
        ModelAndView mav = new ModelAndView("policy-details");
        Optional<Policy> policy = policyService.getPolicyByNumber(policyNumber);

        if (policy.isPresent()) {
            mav.addObject("policy", policy.get());
        } else {
            mav.setViewName("policy-home");
            mav.addObject("error", "Policy " + policyNumber + " not found!");
        }
        return mav;
    }

    // 6. Delete Policy (Matches the link in policy-list.html)
    // The {id} in @GetMapping must match the @PathVariable Integer id
    @GetMapping("/delete/{id}")
    public String deletePolicy(@PathVariable("id") Integer id) {
        // Calls your service to remove the record from DB
        policyService.deletePolicy(id);

        // Redirects back to the table, which will now show the updated list
        return "redirect:/policy/all";
    }

    @PostMapping("/execute-delete")
    public String executeDelete(@RequestParam("policyNumber") String policyNumber) {
        boolean isDeleted = policyService.deleteByPolicyNumber(policyNumber);

        if (isDeleted) {
            // Redirect to the list to show it's gone
            return "redirect:/policy/all";
        } else {
            // Redirect back to home with an error parameter
            return "redirect:/policy/home?error=PolicyNotFound";
        }
    }

    // Updated: This mapping now handles the "Update Policy" button from Home
    @GetMapping("/updateform")
    public ModelAndView showUpdateList() {
        List<Policy> list = policyService.getAllPolicies();
        // Returns the list where user can pick which one to edit
        ModelAndView mav = new ModelAndView("policy-update-form");
        mav.addObject("policies", list);
        return mav;
    }

//    // 7. Show Edit Form with existing data (Triggered from the list)
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
//        ModelAndView mav = new ModelAndView("update-policy");
//        Optional<Policy> policy = policyService.getPolicyById(id);
//        if (policy.isPresent()) {
//            mav.addObject("policy", policy.get());
//        } else {
//            mav.setViewName("redirect:/policy/update");
//        }
//        return mav;
//    }

    // 7. Show Edit Form using Policy Number
    @GetMapping("/edit/{num}")
    public ModelAndView showEditForm(@PathVariable("num") String num) {
        ModelAndView mav = new ModelAndView("update-policy");

        // Using your existing service method that returns Optional<Policy>
        Optional<Policy> policy = policyService.getPolicyByNumber(num);

        if (policy.isPresent()) {
            mav.addObject("policy", policy.get());
        } else {
            // Redirect back if the policy number isn't found
            mav.setViewName("redirect:/policy/update");
        }
        return mav;
    }

    // 8. Process the Update
//    @PostMapping("/update")
//    public String updatePolicy(@ModelAttribute("policy") Policy policy) {
//        // JPA save() updates the record because policyID is present in the object
//        policyService.savePolicy(policy);
//        return "redirect:/policy/update";
//    }

    @PostMapping("/update")
    public String updatePolicy(@ModelAttribute("policy") Policy policy) {
        // Adding a print check to your console to see if the data arrives
        System.out.println("Updating Policy ID: " + policy.getPolicyId());

        policyService.savePolicy(policy);
        return "redirect:/policy/home";
    }
}