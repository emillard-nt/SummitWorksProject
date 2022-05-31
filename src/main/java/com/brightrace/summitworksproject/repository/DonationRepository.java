package com.brightrace.summitworksproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brightrace.summitworksproject.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

}
