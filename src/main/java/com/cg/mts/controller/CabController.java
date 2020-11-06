package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Cab;
import com.cg.mts.service.ICabService;

@RestController
public class CabController {

	@Autowired
	private ICabService cabService;

	@PostMapping("/add/cab")
	public Cab add() {
		Cab cab = new Cab();
		cab = cabService.insertCab(cab);
		return cab;
	}

	@PutMapping("/update/cab")
	public Cab update() {
		Cab cab = new Cab("abc", 4.5f);
		cab = cabService.updateCab(cab);
		return cab;
	}

	@DeleteMapping("/delete/cab")
	public void delete(Cab cab) {
		cab = cabService.deleteCab(cab);
	}
	
	@GetMapping("/get/cabsOfType/{cabType}")
	public List<Cab> getCabsOfType(@PathVariable("cabType")String cabType) {
		List<Cab> cabs = cabService.viewCabsOfType(cabType);
		return cabs;
	}
	
	@GetMapping("/get/countOfCabsType/{cabType}")
	public int getCountCabsOfType(@PathVariable("cabType")String cabType) {
		int count = cabService.countCabsOfType(cabType);
		return count;
	}
}
