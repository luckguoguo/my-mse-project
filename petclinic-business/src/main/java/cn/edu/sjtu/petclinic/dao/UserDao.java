package cn.edu.sjtu.petclinic.dao;

import java.util.List;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.User;

public interface UserDao {

	User findUserByUsername(String username);
	
	void save(User user);
	
	User get(Long id);
	
	Page<User> findVeterinarians(VeterinarianQuery query);
	
	List<User> findVeterinariansByClinic(Clinic clinic);
	
}
