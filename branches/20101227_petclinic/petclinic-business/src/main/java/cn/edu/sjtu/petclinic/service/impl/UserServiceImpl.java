package cn.edu.sjtu.petclinic.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.utils.EncryptionUtils;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.UserService;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedUsernameException;
import cn.edu.sjtu.petclinic.service.exception.InvalidClinicPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidStatusException;
import cn.edu.sjtu.petclinic.service.exception.UserNotExistsException;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

	@Override
	public User authenticate(String username, String password)
			throws UserNotExistsException, UserInvalidPasswordException, UserInvalidStatusException {
		
		User user = userDao.findUserByUsername(username);
		
		if (user == null) {
			log.debug("user " + username + " not exists");
			throw new UserNotExistsException();
		}
		
		if (!EncryptionUtils.getMD5Str(password).equalsIgnoreCase(user.getPassword()) 
				&& !EncryptionUtils.getMD5Str(password).equalsIgnoreCase(user.getTempPassword())) {
			log.debug("user " + username + "'s password is invalid");
			throw new UserInvalidPasswordException();
		}
		
		if (user.getStatus() != User.Status.ACTIVE) {
			log.debug("user " + username + " is not active");
			throw new UserInvalidStatusException();
		}
		
		return user;
	}
	
	@Override
	public void updatePassword(User user, String originalPassword) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String requestTempPassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void checkUser(User user) throws DuplicatedUsernameException {
		if (isUsernameRegistered(user)) throw new DuplicatedUsernameException();
	}
	
	private boolean isUsernameRegistered(User user) {
		User userPojo = userDao.findUserByUsername(user.getUsername());
		log.debug("userPojo: " + userPojo);
		if (userPojo == null) return false;
		log.debug("found userPojo");
		if (user.isNewEntity()) {
			// a new user
			log.debug("new user's username is same as pojo's");
			return true;
		}
		log.debug("!user.getId().equals(userPojo.getId()): " + !user.getId().equals(userPojo.getId()));
		return (!user.getId().equals(userPojo.getId()));
	}
	
	@Override
	public void addVeterinarian(Veterinarian veterinarian, String clinicPassword)
			throws InvalidClinicPasswordException, DuplicatedUsernameException {
		
		// check clinic mgrPassword
		checkMgrPassword(veterinarian, clinicPassword);
		
		// check username
		checkUser(veterinarian);
		
		// register veterinarian
		veterinarian.setPassword(EncryptionUtils.getMD5Str(veterinarian.getPassword()));
		veterinarian.setStatus(User.Status.ACTIVE);
		userDao.save(veterinarian);
	}

	private void checkMgrPassword(Veterinarian veterinarian,
			String clinicPassword) throws InvalidClinicPasswordException {
		Clinic clinic = clinicDao.get(veterinarian.getClinic().getId());
		if (clinic == null 
				|| !StringUtils.equals(clinic.getMgrPassword(), EncryptionUtils.getMD5Str(clinicPassword))) {
			throw new InvalidClinicPasswordException();
		}
	}
	
	@Override
	public void updateVeterinarian(Veterinarian veterinarian,
			String clinicPassword) throws InvalidClinicPasswordException, DuplicatedUsernameException {
		
		// check clinic mgrPassword
		checkMgrPassword(veterinarian, clinicPassword);
		
		// check username
		checkUser(veterinarian);
		
		Veterinarian veterinarianPojo = getVeterinarian(veterinarian.getId());
		copyToVeterinarianPojo(veterinarian, veterinarianPojo);
		userDao.save(veterinarianPojo);
	}
	
	private void copyToVeterinarianPojo(Veterinarian veterinarian,
			Veterinarian veterinarianPojo) {
		
		veterinarianPojo.setClinic(veterinarian.getClinic());
		veterinarianPojo.setUsername(veterinarian.getName());
		veterinarianPojo.setTitle(veterinarian.getTitle());
		veterinarianPojo.setName(veterinarian.getName());
		veterinarianPojo.setGender(veterinarian.getGender());
		veterinarianPojo.setBirthdate(veterinarian.getBirthdate());
		veterinarianPojo.setWorkingdate(veterinarian.getWorkingdate());
		veterinarianPojo.setTelephone(veterinarian.getTelephone());
		veterinarianPojo.setEmail(veterinarian.getEmail());
		veterinarianPojo.setIntroduction(veterinarian.getIntroduction());
		veterinarianPojo.setLastModifiedTime(veterinarian.getLastModifiedTime());
		veterinarianPojo.setLastModifiedBy(veterinarian.getLastModifiedBy());
	}

	@Override
	public Page<Veterinarian> queryVeterinarians(VeterinarianQuery query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Veterinarian getVeterinarian(Long id) {
		User veterinarian = userDao.get(id);
		if (veterinarian instanceof Veterinarian)
			return (Veterinarian) veterinarian;
		return null;
	}
	
	@Override
	public void activeVeterinarian(Veterinarian veterinarian) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void inactiveVeterinarian(Veterinarian veterinarian) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPetOwner(PetOwner petOwner)
			throws DuplicatedUsernameException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updatePetOwner(PetOwner petOwner) 
			throws DuplicatedUsernameException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PetOwner getPetOwner(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
