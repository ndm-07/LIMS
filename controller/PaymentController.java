package com.example.payment.controller;

import com.example.payment.bean.Payment;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Load the Payment Home UI
    @GetMapping("/home")
    public String showPaymentHome(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        model.addAttribute("newPayment", new Payment());
        return "payment-home";
    }

    // makePayment() endpoint
    // Change this line in your PaymentController.java
    @PostMapping("/makePayment")
    public String makePayment(@ModelAttribute("newPayment") Payment payment) {
        paymentService.processMakePayment(payment);
        // Fixed: Redirect to the correct mapping /payment/home
        return "redirect:/payment/home";
    }

    // getPaymentsByPolicy() endpoint
    @GetMapping("/filter")
    public String getPaymentsByPolicy(@RequestParam("policyId") int policyId, Model model) {
        List<Payment> filtered = paymentService.getPaymentsByPolicy(policyId);
        model.addAttribute("payments", filtered);
        model.addAttribute("newPayment", new Payment());
        return "payment-home";
    }
}