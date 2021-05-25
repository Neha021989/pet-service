package com.example.pet.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetResource {

	private List pets = new ArrayList();

	public PetResource() {
		Pet pet = new Pet("Barcley", "Dog");
		Pet pet1 = new Pet("Merci", "Cat");
		pets.add(pet);
		pets.add(pet1);
	}

	@GetMapping
	public Pet getPetDetails() {
		return (Pet) pets.get(0);
	}

	@PostMapping
	public void savePetDetails(@RequestBody Pet pet) {
		pets.add(pet);
	}

}
