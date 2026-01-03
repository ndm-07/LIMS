package com.example.beneficiary.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary") // Ensure this matches your MySQL table name exactly
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beneficiaryId;

    private int policyId;
    private String name;
    private String relationship;

    @Column(name = "percentageShare")
    private double percentageShare;

    // Default Constructor (Required by JPA)
    public Beneficiary() {}

    // Getters and Setters...
    public int getBeneficiaryId() { return beneficiaryId; }
    public void setBeneficiaryId(int beneficiaryId) { this.beneficiaryId = beneficiaryId; }
    public int getPolicyId() { return policyId; }
    public void setPolicyId(int policyId) { this.policyId = policyId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }
    public double getPercentageShare() { return percentageShare; }
    public void setPercentageShare(double percentageShare) { this.percentageShare = percentageShare; }
}