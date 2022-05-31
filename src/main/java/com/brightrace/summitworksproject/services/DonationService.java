package com.brightrace.summitworksproject.services;

import javax.transaction.Transactional;

import com.brightrace.summitworksproject.model.Donation;
import com.brightrace.summitworksproject.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DonationService {

    @Autowired
    private DonationRepository repository;

    public List<Donation> listAll() { return repository.findAll(); }
    public void save(Donation donation) {
        repository.save(donation);
    }
    public Donation get(Integer id) {
        return repository.findById(id).get();
    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
