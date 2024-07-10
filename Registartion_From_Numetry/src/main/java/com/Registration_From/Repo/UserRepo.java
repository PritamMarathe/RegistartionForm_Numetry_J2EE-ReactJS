package com.Registration_From.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Registration_From.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
