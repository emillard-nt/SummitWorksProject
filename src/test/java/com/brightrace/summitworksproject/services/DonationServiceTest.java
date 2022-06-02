package com.brightrace.summitworksproject.services;

import com.brightrace.summitworksproject.model.Donation;
import com.brightrace.summitworksproject.repository.DonationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DonationServiceTest {

    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private DonationService donationService;

    @Test
    void listAllTest() {

        List<Donation> donationTest = new ArrayList();
        donationTest.add(new Donation(1, 1, 1, "Albert", "Allen", "1/1/2022", 1000.11));
        donationTest.add(new Donation(2, 2, 1, "Billy", "Baker", "1/1/2022", 1000.11));
        donationTest.add(new Donation(3, 2, 2, "Billy", "Baker", "1/1/2022", 1000.11));

        given(donationRepository.findAll()).willReturn(donationTest);

        List<Donation> donationExpected = donationService.listAll();

        assertEquals(donationExpected, donationTest);

    }

    @Test
    void saveTest() {

        Donation donationTest = new Donation(1, 1, 1, "Albert", "Allen", "1/1/2022", 1000.11);

        donationService.save(donationTest);
        donationService.save(donationTest);

        verify(donationRepository, times(2)).save(donationTest);

    }

    @Test
    void getTest() {

        final Integer id = 1;
        final Donation donationTest = new Donation(1, 1, 1, "Albert", "Allen", "1/1/2022", 1000.11);

        given(donationRepository.findById(id)).willReturn(Optional.of(donationTest));

        Donation donationExpected = donationService.get(id);

        assertEquals(donationExpected, donationTest);

    }

    @Test
    void deleteTest() {

        Integer id = 1;

        donationService.delete(id);
        donationService.delete(id);

        verify(donationRepository, times(2)).deleteById(id);

    }

}
