package com.brightrace.summitworksproject.controller;

import com.brightrace.summitworksproject.model.DonationType;
import com.brightrace.summitworksproject.services.DonationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DonationTypeController {

    @Autowired
    private DonationTypeService donationTypeService;

    @GetMapping("/donationTypes")
    public List<DonationType> getList()
    {
        return donationTypeService.listAll();
    }

    @GetMapping("/donationTypes/{id}")
    public ResponseEntity<DonationType> get(@PathVariable int id) {

        try {
            DonationType donationType = donationTypeService.get(id);
            return new ResponseEntity<DonationType>(donationType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DonationType>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/donationTypes")
    public void add(@RequestBody DonationType donationType) {
        donationTypeService.save(donationType);
    }

    @PutMapping("/donationTypes/{id}")
    public ResponseEntity<?> update(@RequestBody DonationType donationType, @PathVariable Integer id) {

        try {
            DonationType existDonationType = donationTypeService.get(id);
            donationType.setId(id);

            donationTypeService.save(donationType);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/donationTypes/{id}")
    public void delete(@PathVariable Integer id) {
        donationTypeService.delete(id);
    }

}
