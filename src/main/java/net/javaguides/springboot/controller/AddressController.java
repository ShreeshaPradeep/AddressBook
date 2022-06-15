package net.javaguides.springboot.controller;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.address;
import net.javaguides.springboot.repository.AddressRepository;

@RestController
@RequestMapping("/api/v1/")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository; 
	
	// get address
	@GetMapping("address1")
	public List<address> getAllAddress(){
		return this.addressRepository.findAll();
	}
	
	
	// get address by id 
	@GetMapping("/address1/{id}")
	public ResponseEntity<address> getAddressById(@PathVariable(value = "id") Long addressId)
	throws ResourceNotFoundException{
		address address1 = addressRepository.findById(addressId)
				.orElseThrow(()-> new ResourceNotFoundException("Address not found for this id ::" + addressId));
		return ResponseEntity.ok().body(address1);
		
	}
	

	
	
	// save address
	@PostMapping("address1")
	
	public address createAddress(@Valid @RequestBody address address1) {
		
		return this.addressRepository.save(address1);
		
	}
	
	// update address
	@PutMapping("address1/{id}")
	
	public ResponseEntity<address> updateAddress(@PathVariable(value="id") Long addressId,
			  @RequestBody address addressDetails) throws ResourceNotFoundException{
		address address1 = addressRepository.findById(addressId)
					.orElseThrow(()-> new ResourceNotFoundException("Address not found for this id ::" + addressId));
		
		address1.setEmail(addressDetails.getEmail());
		address1.setFirstName(addressDetails.getFirstName());
		address1.setLastName(addressDetails.getLastName());  
		address1.setAddress(addressDetails.getAddress());
		return ResponseEntity.ok(this.addressRepository.save(address1));
	}
	
	
	// delete address
	@DeleteMapping("address1/{id}")
	public Map<String , Boolean> deleteAddress(@PathVariable(value = "id")Long  addressId) throws ResourceNotFoundException{

		address address1 = addressRepository.findById(addressId) 
				.orElseThrow(()-> new ResourceNotFoundException("Address not found for this id ::" + addressId));
		this.addressRepository.delete(address1);
		Map<String,Boolean> response =  new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response; 
	}
	
}
