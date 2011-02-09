package cn.edu.sjtu.petclinic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.utils.EncryptionUtils;
import cn.edu.sjtu.petclinic.dto.EmailRequest;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.EmailService;
import cn.edu.sjtu.petclinic.service.UserService;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedUsernameException;
import cn.edu.sjtu.petclinic.service.exception.InvalidClinicPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidStatusException;
import cn.edu.sjtu.petclinic.service.exception.UserNotExistsException;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

	@Autowired
	protected EmailService emailService;
	
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

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
	public void updatePassword(Long userId, String originalPassword, String newPassword) 
			throws UserInvalidPasswordException {
		
		// check original password
		User user = userDao.get(userId);
		if (user == null) return;
		if (!StringUtils.equals(user.getPassword(), EncryptionUtils.getMD5Str(originalPassword))
				&& !StringUtils.equals(user.getTempPassword(), EncryptionUtils.getMD5Str(originalPassword))) {
			throw new UserInvalidPasswordException();
		}
		
		// update password with new password
		user.setPassword(EncryptionUtils.getMD5Str(newPassword));
		user.setTempPassword(EncryptionUtils.getMD5Str(newPassword));
		userDao.save(user);
	}
	
	@Override
	public String requestTempPassword(String username) throws UserNotExistsException {
		User user = userDao.findUserByUsername(username);
		if (user == null) {
			throw new UserNotExistsException();
		}
		
		// generate random temp password
		String tempPassword = RandomStringUtils.randomAlphanumeric(6);
		
		// update temp password
		user.setTempPassword(EncryptionUtils.getMD5Str(tempPassword));
		userDao.save(user);
		
		// send email
		EmailRequest emailRequest = new EmailRequest();
		emailRequest.setToEmailAddress(user.getEmail());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("TEMP_PASSWORD", tempPassword);
		emailRequest.setModel(model);
		emailService.sendEmail(emailRequest);
		
		return tempPassword;
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
		veterinarianPojo.setUsername(veterinarian.getUsername());
		veterinarianPojo.setTitle(veterinarian.getTitle());
		veterinarianPojo.setName(veterinarian.getName());
		veterinarianPojo.setGender(veterinarian.getGender());
		veterinarianPojo.setBirthdate(veterinarian.getBirthdate());
		veterinarianPojo.setWorkingdate(veterinarian.getWorkingdate());
		veterinarianPojo.setTelephone(veterinarian.getTelephone());
		veterinarianPojo.setEmail(veterinarian.getEmail());
		veterinarianPojo.setSpecialityPetCategory(veterinarian.getSpecialityPetCategory());
		veterinarianPojo.setIntroduction(veterinarian.getIntroduction());
		veterinarianPojo.setLastModifiedTime(veterinarian.getLastModifiedTime());
		veterinarianPojo.setLastModifiedBy(veterinarian.getLastModifiedBy());
	}

	@Override
	public Page<User> queryVeterinarians(VeterinarianQuery query) {
		return userDao.findVeterinarians(query);
	}
	
	@Override
	public Page<User> queryActiveVeterinarians(VeterinarianQuery query) {
		query.setStatus(User.Status.ACTIVE);
		return userDao.findVeterinarians(query);
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
		Veterinarian veterinarianPojo = getVeterinarian(veterinarian.getId());
		veterinarianPojo.setStatus(User.Status.ACTIVE);
		userDao.save(veterinarianPojo);
	}
	
	@Override
	public void inactiveVeterinarian(Veterinarian veterinarian) {
		Veterinarian veterinarianPojo = getVeterinarian(veterinarian.getId());
		veterinarianPojo.setStatus(User.Status.INACTIVE);
		userDao.save(veterinarianPojo);
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

	@Override
	public List<User> findVeterinariansByClinic(Clinic clinic) {
		return userDao.findVeterinariansByClinic(clinic);
	}

}
