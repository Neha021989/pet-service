package com.example.pet.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetResource {

	@GetMapping
	public String getPetDetails() {
		return "dog";
	}

}
