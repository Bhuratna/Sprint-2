package com.cg.mts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;


import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.InvalidCabException;
import com.cg.mts.repository.ICabRepository;
import com.cg.mts.service.CabService;
import com.cg.mts.service.ICabService;


@ExtendWith(MockitoExtension.class)
	public class CabServiceTesting {
		@InjectMocks
		private CabService service;

		@Mock
		private ICabRepository repo;
		@BeforeEach
		void setUp() throws Exception {
		}
		
		@Test
		 void testInsertCab() throws InvalidCabException {
			
			Cab cab = Mockito.mock(Cab.class);
			Cab updated=Mockito.mock(Cab.class);
			Mockito.when(repo.save(cab)).thenReturn(updated); 
			 Cab result =service.insertCab(cab);
			assertEquals(updated,result);

		}
		/*
			@Test
		 void testCountCab() throws InvalidCabException {

			Cab cab = new Cab();
			cab.setCabId(5);
			cab.setCarType("Mishra");
			cab.setPerKmRate(20.5f);

			Mockito.when(repo.countCabsOfType(carType)).thenReturn(carType); 
			assertThat(service.countCabsOfType("hi")).isEqualTo(count);

		}
			
		@Test
		void testGetCab() throws CabNotFoundException {

			Cab cab = new Cab();
			cab.setCabId(5);
			cab.setCarType("Bhuratna");
			cab.setPerKmRate(30.5f);

			Optional<Cab> ocust = Optional.of(cab);
			Mockito.when(repo.findByCarType("a")).thenReturn((List<Cab>) ocust.get());
			assertThat(service.viewCabsOfType("Audi")).isEqualTo(ocust.get());

		}
		*/
		@Test
		void testUpdateCab_1()  {
			Cab cab = Mockito.mock(Cab.class);
			Cab updated=Mockito.mock(Cab.class);
		   int cabId=50;
		   Mockito.when(cab.getCabId()).thenReturn(50);
			Mockito.when(repo.existsById(50)).thenReturn(true);
			
			Mockito.when(repo.save(cab)).thenReturn(updated);
			Cab result=service.updateCab(cab);
			assertEquals(updated,result);

		}
		@Test
		void testUpdateCab_2()
		{
			Cab cab = Mockito.mock(Cab.class);
			int cabId=20;
			 Mockito.when(cab.getCabId()).thenReturn(cabId);
				Mockito.when(repo.existsById(cabId)).thenReturn(false);
				Executable exe=()->service.updateCab(cab);
				assertThrows(InvalidCabException.class,exe);
		}
		@Test
		public void testDeleteCab() {
			Cab cab = new Cab();
			cab.setCabId(5);
			cab.setCarType("Bhuratna");
			cab.setPerKmRate(30.5f);
			
			Mockito.when(repo.findById(1)).thenReturn(Optional.of(cab));
			Mockito.when(repo.existsById(cab.getCabId())).thenReturn(false);

			assertFalse(repo.existsById(cab.getCabId()));
		}
	
	
}