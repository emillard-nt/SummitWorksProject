package com.brightrace.summitworksproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brightrace.summitworksproject.model.DonationType;

@Repository
public interface DonationTypeRepository extends JpaRepository<DonationType, Integer> {

}
