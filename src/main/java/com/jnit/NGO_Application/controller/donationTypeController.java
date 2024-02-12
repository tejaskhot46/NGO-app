
package com.jnit.NGO_Application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jnit.NGO_Application.model.donation;
import com.jnit.NGO_Application.model.donationtype;
import com.jnit.NGO_Application.model.event;
import com.jnit.NGO_Application.repository.donationTypeRepository;

import com.jnit.NGO_Application.service.donationTypeService;


public class donationTypeController implements donationTypeService {
 private donationTypeRepository donationTypeRepository;

 public donationTypeController(donationTypeRepository donationTypeRepository) {
     this.donationTypeRepository = donationTypeRepository;
 }

 public donationtype createDonationType(String username, String email, String password) {
     donationtype newDonationType = new donationtype();
     return donationTypeRepository.save(newDonationType);
 }

 public donationtype getDonationTypeById(int donationTypeId) {
     return donationTypeRepository.findById(donationTypeId);
 }

// public void updateDonationType(donationtype donationType) {
//     donationTypeRepository.update(donationType);
// }
//
// public void deleteDonationType(int donationTypeId) {
//     donationTypeRepository.delete(donationTypeId);
// }



@GetMapping("/donationtype")
public List<donationtype> getdonationtype(){
	return donationTypeRepository.findAll();
}

@PostMapping("/donationtype")
public ResponseEntity<donationtype> createDonationType(@RequestBody donationtype newDonationType) {
    donationtype createdDonationType = donationTypeRepository.save(newDonationType);
    return new ResponseEntity<>(createdDonationType, HttpStatus.CREATED);
}
}