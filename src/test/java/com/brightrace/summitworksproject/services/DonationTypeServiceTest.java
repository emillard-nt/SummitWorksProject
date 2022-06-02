package com.brightrace.summitworksproject.services;

import com.brightrace.summitworksproject.model.DonationType;
import com.brightrace.summitworksproject.repository.DonationTypeRepository;
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
public class DonationTypeServiceTest {

    @Mock
    private DonationTypeRepository donationTypeRepository;

    @InjectMocks
    private DonationTypeService donationTypeService;

    @Test
    void listAllTest() {

        List<DonationType> donationTypeTest = new ArrayList();
        donationTypeTest.add(new DonationType(1, "SummitWorks Donation Drive 2020", true));
        donationTypeTest.add(new DonationType(2, "SummitWorks Donation Drive 2021", true));
        donationTypeTest.add(new DonationType(3, "SummitWorks Donation Drive 2022", true));

        given(donationTypeRepository.findAll()).willReturn(donationTypeTest);

        List<DonationType> donationTypeExpected = donationTypeService.listAll();

        assertEquals(donationTypeExpected, donationTypeTest);

    }

    @Test
    void saveTest() {

        DonationType donationTypeTest = new DonationType(1, "SummitWorks Donation Drive 2020", true);

        donationTypeService.save(donationTypeTest);
        donationTypeService.save(donationTypeTest);

        verify(donationTypeRepository, times(2)).save(donationTypeTest);

    }

    @Test
    void getTest() {

        final Integer id = 1;
        final DonationType donationTypeTest = new DonationType(1, "SummitWorks Donation Drive 2020", true);

        given(donationTypeRepository.findById(id)).willReturn(Optional.of(donationTypeTest));

        DonationType donationTypeExpected = donationTypeService.get(id);

        assertEquals(donationTypeExpected, donationTypeTest);

    }

    @Test
    void deleteTest() {

        Integer id = 1;

        donationTypeService.delete(id);
        donationTypeService.delete(id);

        verify(donationTypeRepository, times(2)).deleteById(id);

    }

}
