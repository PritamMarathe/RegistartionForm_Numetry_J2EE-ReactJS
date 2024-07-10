package com.Registration_From.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration_From.Entity.User;
import com.Registration_From.Service.UserService;

@RestController

@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService services;

	@GetMapping("/getall")
	public Iterable<User> getUser() {
		return services.listAll();
	}

	@PostMapping(value = "/save")
	private String saveBook(@RequestBody User user) {
		services.saveOrUpdate(user);
		return user.getUsername();
	}

	@RequestMapping("/student/{username}")
	private User getBooks(@PathVariable(name = "username") String username) {
		return services.getByUsername(username);
	}

	@PutMapping("/edit/{username}")
	private User update(@RequestBody User user) {
		services.saveOrUpdate(user);
		return user;
	}

	@DeleteMapping("/delete/{username}")
	private void deleteStudent(@PathVariable("username") String username) {
		services.delete(username);
	}

}
