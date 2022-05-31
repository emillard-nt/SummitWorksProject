package com.brightrace.summitworksproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brightrace.summitworksproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
