package com.brightrace.summitworksproject.model;

import javax.persistence.*;

@Entity
public class Donation {

    private Integer id;
    private Integer userId;
    private Integer donationTypeId;
    private String firstName;
    private String lastName;
    private String date;
    private Double amount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() { return id; }
    public Integer getUserId() { return userId; }
    public Integer getDonationTypeId() { return donationTypeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDate() { return date; }
    public Double getAmount() { return amount; }

    public void setId(Integer id) { this.id = id; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public void setDonationTypeId(Integer donationTypeId) { this.donationTypeId = donationTypeId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDate(String date) { this.date = date; }
    public void setAmount(Double amount) { this.amount = amount; }

}
