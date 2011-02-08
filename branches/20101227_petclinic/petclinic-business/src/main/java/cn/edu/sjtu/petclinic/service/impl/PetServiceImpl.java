package cn.edu.sjtu.petclinic.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetCategory;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.service.PetService;

@Service
public class PetServiceImpl extends AbstractService implements PetService {

	@Override
	public void addPet(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pet> getOwnerPets(PetOwner petOwner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet getPet(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePet(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PetCategory> getAllPetCategories() {
		return petCategoryDao.getAll();
	}

}
