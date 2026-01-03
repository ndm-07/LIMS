package com.example.payment.dao;

import com.example.payment.bean.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    // Linked to getPaymentsByPolicy()
    List<Payment> findByPolicyId(int policyId);
}