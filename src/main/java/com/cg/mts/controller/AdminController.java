package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admin;
import com.cg.mts.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@PostMapping("/add/admin")
	public Admin add() {
		Admin admin = new Admin();
		admin = adminService.insertAdmin(admin);
		return admin;
	}
	
	@PutMapping("/update/admin")
	public Admin update() {
		Admin admin = new Admin("abc", "abc", "abc", "abc");
		admin = adminService.updateAdmin(admin);
		return admin;
	}
	
	@DeleteMapping("/delete/admin/{id}")
	public void delete(@PathVariable("id") int adminId) {
		Admin admin = adminService.deleteAdmin(adminId);
	}

}
