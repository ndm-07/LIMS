package com.example.payment.service;

import com.example.payment.bean.Payment;
import com.example.payment.dao.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    // Implementation of getPaymentDetails()
    public List<Payment> getAllPayments() {
        return (List<Payment>) repository.findAll();
    }

    // Implementation of getPaymentsByPolicy()
    public List<Payment> getPaymentsByPolicy(int policyId) {
        return repository.findByPolicyId(policyId);
    }

    // Implementation of makePayment() with Mock Logic
    public Payment processMakePayment(Payment payment) {
        payment.setPaymentDate(LocalDate.now());

        // MOCK PAYMENT GATEWAY LOGIC
        // Simulating a real-world scenario: 90% chance of success
        double chance = Math.random();
        if (chance > 0.1) {
            payment.setPaymentStatus("SUCCESS");
        } else {
            payment.setPaymentStatus("FAILED");
        }

        return repository.save(payment);
    }
}