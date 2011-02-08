package cn.edu.sjtu.petclinic.service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.exception.InvalidClinicPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidStatusException;
import cn.edu.sjtu.petclinic.service.exception.UserNotExistsException;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedUsernameException;

public interface UserService {

	User authenticate(String username, String password) 
			throws UserNotExistsException, UserInvalidPasswordException, UserInvalidStatusException;
	
	void updatePassword(Long userId, String originalPassword, String newPassword)
			throws UserInvalidPasswordException;
	
	String requestTempPassword(String username) throws UserNotExistsException;
	
	void checkUser(User user) throws DuplicatedUsernameException;
	
	void addVeterinarian(Veterinarian veterinarian, String clinicPassword) 
			throws InvalidClinicPasswordException, DuplicatedUsernameException;
	
	void updateVeterinarian(Veterinarian veterinarian, String clinicPassword) 
			throws InvalidClinicPasswordException, DuplicatedUsernameException;
	
	Page<User> queryVeterinarians(VeterinarianQuery query);
	
	Page<User> queryActiveVeterinarians(VeterinarianQuery query);
	
	Veterinarian getVeterinarian(Long id);
	
	void activeVeterinarian(Veterinarian veterinarian);
	
	void inactiveVeterinarian(Veterinarian veterinarian);
	
	void addPetOwner(PetOwner petOwner) throws DuplicatedUsernameException;
	
	void updatePetOwner(PetOwner petOwner) throws DuplicatedUsernameException;
	
	PetOwner getPetOwner(Long id);
	
}
