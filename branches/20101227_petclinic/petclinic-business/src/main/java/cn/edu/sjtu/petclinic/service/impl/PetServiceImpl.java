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
		petDao.save(pet);
	}

	@Override
	public List<Pet> getOwnerPets(PetOwner petOwner) {
		return petDao.findPetsByOwner(petOwner);
	}

	@Override
	public Pet getPet(Long id) {
		return petDao.get(id);
	}

	@Override
	public void updatePet(Pet pet) {
		Pet petPojo = getPet(pet.getId());
		copyToPetPojo(pet, petPojo);
		petDao.save(petPojo);
	}

	private void copyToPetPojo(Pet pet, Pet petPojo) {
		petPojo.setOwner(pet.getOwner());
		petPojo.setCategory(pet.getCategory());
		petPojo.setName(pet.getName());
		petPojo.setGender(pet.getGender());
		petPojo.setBirthdate(pet.getBirthdate());
		petPojo.setIntroduction(pet.getIntroduction());
		petPojo.setLastModifiedTime(pet.getLastModifiedTime());
		petPojo.setLastModifiedBy(pet.getLastModifiedBy());
		
	}

	@Override
	public List<PetCategory> getAllPetCategories() {
		return petCategoryDao.getAll();
	}

}
