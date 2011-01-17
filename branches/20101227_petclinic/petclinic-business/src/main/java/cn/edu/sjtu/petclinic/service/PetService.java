package cn.edu.sjtu.petclinic.service;

import java.util.List;

import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetOwner;

public interface PetService {

	void addPet(Pet pet);
	
	void updatePet(Pet pet);
	
	List<Pet> getOwnerPets(PetOwner petOwner);
	
	Pet getPet(Long id);
	
}
