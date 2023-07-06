package com.jsp.sp2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.jsp.sp2.dto.User;
import com.jsp.sp2.repository.UserRepository;
import com.jsp.sp2.util.ResponseStructure;

@Repository
public class UserDao {
	
	// we accesss interface method by useing Autowired and that refernce variable 
	//userRepository to userdao we are accessing
	
	@Autowired
	private UserRepository repo;
	//inside this userRepository your all the methods are present because we make as autowired 
	
	
	public User saveUser(User user)
	{
		return repo.save(user);
	}


	public User findById(int id) {
		Optional<User> user=repo.findById(id);
		return user.get();
	}
	
	public List<User> GetAllUser(User user) {
		List<User> user1=repo.findAll();
		return  user1;
	}


	public User deleteById(int id) {
		Optional<User> user=repo.findById(id);
		if(user.isPresent()) {
			User user1=user.get();
			repo.delete(user1);
			return user1;
		}else {
			return null;
		}
	}


	public User updateUser(int id, User user) {
		Optional<User> user2=repo.findById(id);
		if(user2.isPresent()) {
			//update the data
			user.setId(id);
			repo.save(user);
			return user;
		}
		return null;
	}


	

}

	
		/*
		    1) we are saving data by  use persist method
		whether it is from your EntityManager ---> yes
		
		In springs we are having Somebody who is going to give me all the methods to perform crud operation that is your JPA REPOSITORY
		
		      2) but spring is take care all thing because spring is having all build method to perform Crud operation 
		      3) that all method inside in one interface called JpaRepository
		      
		       but we need to gave implementation for that interface to access method and perform crud operation
		         like merge() , persist() , remove()
		         
		         ** now how to access that method which is present inside interface
		       
		      4) this implementation is given by spring only 
		      5) you need to create one interface which is extends JapRepository
		      
		      6) Now your methods to perform all your crud operation is inside your created interface 
		      
		       ** how to access that method which is present in created interface
			7)WIth the help of your referenceVariable
			8) How to access that reference variable that is with your @autowired annotation

				@Autowired 
			UserRepo repo;

          9)with the help of this(repo) reference variable i can access all the methods to perform crud operation 
		           	userRepository.save(user);
		

		*/
		
		