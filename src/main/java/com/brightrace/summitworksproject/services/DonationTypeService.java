package com.brightrace.summitworksproject.services;

import javax.transaction.Transactional;

import com.brightrace.summitworksproject.model.DonationType;
import com.brightrace.summitworksproject.repository.DonationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DonationTypeService {

    @Autowired
    private DonationTypeRepository repository;

    public List<DonationType> listAll() { return repository.findAll(); }
    public void save(DonationType donationType) {
        repository.save(donationType);
    }
    public DonationType get(Integer id) {
        return repository.findById(id).get();
    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
