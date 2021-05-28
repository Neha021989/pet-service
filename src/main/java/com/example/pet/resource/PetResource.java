package com.example.pet.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetResource {

	private List<Pet> pets = new ArrayList<Pet>();

	public PetResource() {
		Pet pet = new Pet("Barcley", "Horse");
		Pet pet1 = new Pet("Merci", "Cow");
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

	@PutMapping("/{name}")
	public Pet updatePetDetails(@PathVariable String name, @RequestBody Pet pet) {
		List<Pet> removedPets = new ArrayList<Pet>();
		pets.stream().filter(x -> x.getName().equals(name)).forEach(y -> removedPets.add(y));
		pets.remove(removedPets);
		pets.add(pet);
		return pet;
	}

	@DeleteMapping("/{name}")
	public void deletePetDetails(@PathVariable String name) {
		List<Pet> removedPets = new ArrayList<Pet>();
		pets.stream().filter(x -> x.getName().equals(name)).forEach(y -> removedPets.add(y));
		pets.remove(removedPets);
	}

}
