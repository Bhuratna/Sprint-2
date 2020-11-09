package com.cg.mts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.InvalidCabException;
import com.cg.mts.repository.ICabRepository;
import com.cg.mts.service.CabService;
import com.cg.mts.service.ICabService;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class CabTesting {
		@Autowired
		private CabService service;

		@MockBean
		private ICabRepository repo;
		@BeforeEach
		void setUp() throws Exception {
		}
		
		@Test
		 void testCreateCab() throws InvalidCabException {

			Cab cab = new Cab();
			cab.setCabId(5);
			cab.setCarType("Mishra");
			cab.setPerKmRate(20.5f);

			Mockito.when(repo.save(cab)).thenReturn(cab);
			assertThat(service.insertCab(cab)).isEqualTo(cab);

		}
		@Test
		void testGetCab() throws CabNotFoundException {

			Cab cab = new Cab();
			cab.setCabId(5);
			cab.setCarType("Bhuratna");
			cab.setPerKmRate(30.5f);

			Optional<Cab> ocust = Optional.of(cab);
			Mockito.when(repo.save(cab)).thenReturn(cab);
			assertThat(service.updateCab(cab)).isEqualTo(cab);

		}
	}