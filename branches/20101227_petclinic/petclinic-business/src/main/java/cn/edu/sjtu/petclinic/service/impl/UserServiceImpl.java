package cn.edu.sjtu.petclinic.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.utils.EncryptionUtils;
import cn.edu.sjtu.petclinic.dao.UserDao;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
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
public class UserServiceImpl implements UserService {

	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
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
	public void updatePassword(User user, String originalPassword) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String requestTempPassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addVeterinarian(Veterinarian veterinarian, String clinicPassword)
			throws InvalidClinicPasswordException, DuplicatedUsernameException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateVeterinarian(Veterinarian veterinarian,
			String clinicPassword) throws InvalidClinicPasswordException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Page<Veterinarian> queryVeterinarians(VeterinarianQuery query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Veterinarian getVeterinarian(Long id) {
		// TODO Auto-generated method stub
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
	public void updatePetOwner(PetOwner petOwner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PetOwner getPetOwner(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
