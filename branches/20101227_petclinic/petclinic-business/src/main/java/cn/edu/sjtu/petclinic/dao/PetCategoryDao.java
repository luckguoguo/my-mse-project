package cn.edu.sjtu.petclinic.dao;

import java.util.List;

import cn.edu.sjtu.petclinic.entity.PetCategory;

public interface PetCategoryDao {

	List<PetCategory> getAll();
	
}
