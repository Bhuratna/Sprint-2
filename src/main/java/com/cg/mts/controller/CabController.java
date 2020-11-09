package com.cg.mts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.service.ICabService;

@RequestMapping("/cab")
@RestController
public class CabController {

	@Autowired
	private ICabService cabService;

	@PostMapping("/add")
	public Cab add(@RequestBody Cab cab) {
		Cab newCab = new Cab(cab.getCarType(), cab.getPerKmRate());
		cab = cabService.insertCab(newCab);
		return cab;
	}

	@PutMapping("/update/{id}")
	public Cab update(@PathVariable("id") int cabId, @RequestBody Cab newCab) {
		newCab.setCabId(cabId);
		newCab = cabService.updateCab(newCab);
		return newCab;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Cab cab) {
		cab = cabService.deleteCab(cab);
	}
	
	@GetMapping("/get/cabsOfType/{cabType}")
	public ResponseEntity<List<Cab>> getCabsOfType(@PathVariable("cabType")String cabType) {
		List<Cab> cabs = cabService.viewCabsOfType(cabType);
		if(cabs.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(cabs));
	}
	
	@GetMapping("/get/countOfCabsType/{cabType}")
	public int getCountCabsOfType(@PathVariable("cabType")String cabType) {
		int count = cabService.countCabsOfType(cabType);
		return count;
	}
}