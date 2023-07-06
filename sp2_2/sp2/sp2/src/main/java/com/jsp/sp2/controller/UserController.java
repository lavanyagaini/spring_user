package com.jsp.sp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.sp2.Service.UserService;
import com.jsp.sp2.dao.UserDao;
import com.jsp.sp2.dto.User;
import com.jsp.sp2.util.ResponseStructure;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseStructure<User> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> DeleteUser(@RequestParam int id){
		return service.deleteUser(id);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<User>> findById(@RequestParam int id){
		return service.findById(id);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>>  updateUser(@RequestParam int id,@RequestBody User user){
		return service.updateUser(id, user);
	}
	
	@GetMapping("/findAll")
	
	public ResponseEntity<List<ResponseStructure<User>>> GetAllUser(@RequestBody User user){
		return service.GetAllUser(user);
		
	}
}
	
//	@Autowired
//	private UserDao dao;
//	
//	@PostMapping("/save")
//	public User saveUser(@RequestBody User user)
//	{
//		return dao.saveUser(user);
//	}
//	
//	@GetMapping("/get")
//	public User findById(@RequestParam int id) {
//		return dao.findById(id);
//	}
//	
//	@GetMapping("/findAll")
//	
//	public List<User> FindAllUser(@RequestBody User user){
//		return dao.GetAllUser(user);
//		
//	}
//	
//	@DeleteMapping("/delete")
//	public User deleteById(@RequestParam int id) {
//		return dao.deleteById(id);
//		
//	}
//	
//	@PutMapping("/update")
//	public User updateUser(@RequestParam int id, @RequestBody User user ) {
//		return dao.updateUser(id,user);
//		
//	}
//}
// this only class which is communicate with Postman 
//because of RequestMapping


// post man madhe return karyla we use return