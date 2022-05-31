package com.brightrace.summitworksproject.controller;

import com.brightrace.summitworksproject.model.Donation;
import com.brightrace.summitworksproject.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DonationController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/donations")
    public List<Donation> getList()
    {
        return donationService.listAll();
    }

    @GetMapping("/donations/{id}")
    public ResponseEntity<Donation> get(@PathVariable int id) {

        try {
            Donation donation = donationService.get(id);
            return new ResponseEntity<Donation>(donation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Donation>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/donations")
    public void add(@RequestBody Donation donation) {
        donationService.save(donation);
    }

    @PutMapping("/donations/{id}")
    public ResponseEntity<?> update(@RequestBody Donation donation, @PathVariable Integer id) {

        try {
            Donation existDonation = donationService.get(id);
            donation.setId(id);

            donationService.save(donation);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        donationService.delete(id);
    }

}
