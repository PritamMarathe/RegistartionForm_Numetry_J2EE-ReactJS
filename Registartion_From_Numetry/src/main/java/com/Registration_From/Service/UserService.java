package com.Registration_From.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registration_From.Entity.User;
import com.Registration_From.Repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public Iterable<User> listAll() {
		return this.repo.findAll();
	}

	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(User user) {
		repo.save(user);
	}

	
	public User getByUsername(String username) {
		return repo.getReferenceById(username).get();
	}
	
	public void update(User user, String username) {
		repo.save(user);
	}

	public void delete(String username) {
		repo.deleteById(username);
	}

}
