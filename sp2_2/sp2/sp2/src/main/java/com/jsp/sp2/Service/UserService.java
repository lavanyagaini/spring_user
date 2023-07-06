package com.jsp.sp2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.jsp.sp2.dao.UserDao;
import com.jsp.sp2.dto.User;
import com.jsp.sp2.util.ResponseStructure;


//by seeing the service annotation client will nderstand the it is bbusiness layer 
//serice layer maintains the business lodic

@Service
 public class UserService {
	
	@Autowired
	private UserDao dao;
	
	
	public ResponseStructure<User> saveUser(User user) {
		// TODO Auto-generated method stub
		User saveuser=dao.saveUser(user);
		if(saveuser!=null) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("user data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(saveuser);
		
		return structure;
		}
		return null;
	}
//	
//	public ResponseStructure<User> deleteUser(int id){
//		User user=dao.deleteById(id);
//		if(user!=null) {
//			ResponseStructure<User> structure=new ResponseStructure<User>();
//			structure.setMessage("deleted successfully");
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setData(user);
//			return structure;
//		}
//		return null;
//		
//	}

	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		User user=dao.deleteById(id);
		if(user!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage(" sorry id not present");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			
			//return throw Exception
		}
	}
		
		public ResponseEntity<ResponseStructure<User>> findById(int id){
			User user=dao.findById(id);
			if(user!=null) {
				ResponseStructure<User> structure=new ResponseStructure<User>();
				structure.setMessage("getting data is successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(user);
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			}else {
				ResponseStructure<User> structure=new ResponseStructure<User>();
				structure.setMessage(" sorry id not present");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(user);
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			}
	}


		public ResponseEntity<ResponseStructure<User>> updateUser(int id,User user) {
			
			User user1=dao.updateUser(id, user);
			if(user1!=null) {
				ResponseStructure<User> structure=new ResponseStructure<User>();
				structure.setMessage("getting data is successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(user1);
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			}else {
				ResponseStructure<User> structure=new ResponseStructure<User>();
				structure.setMessage(" sorry id not present");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(user1);
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			}
		}


		public ResponseEntity<List<ResponseStructure<User>>> GetAllUser(User user) {
			List<User> dbhospital=dao.GetAllUser(user);
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("getting data is successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbhospital);

			return new ResponseEntity<List<ResponseStructure<User>>> (HttpStatus.FOUND);
		}
	
	

	
}

	
