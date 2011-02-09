package cn.edu.sjtu.petclinic.dao;

import java.util.List;

import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetOwner;

public interface PetDao {
	
	void save(Pet pet);
	
	List<Pet> findPetsByOwner(PetOwner owner);
	
	Pet get(Long id);
	
}
