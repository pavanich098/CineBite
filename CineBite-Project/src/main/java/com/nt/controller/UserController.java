package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.User;
import com.nt.service.IUserService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")

public class UserController 
{
   @Autowired 
   private IUserService service;
   
   //@CrossOrigin(origins = "http://localhost:5173")

   @PostMapping("/create")
   public User createUser(@RequestBody User user)
   {
	   return service.createUser(user);
   }
   @GetMapping("/all")
   public List<User> fetchallUsers()
   {
	   return service.getAllUsers();
   }
   
   @GetMapping("/{id}")
   public User getUserById(@PathVariable int id)
   {
	   return service.getUserById(id);
   }
   
   @PutMapping("/update/{id}")
   public User updateUser(@PathVariable int id,@RequestBody User user)
   {
	   return service.updateUser(id, user);
   }
   
//   @DeleteMapping("/delete/{id}")
//   public void deleteUser(@PathVariable int id)
//   {
//	   service.deleteUser(id);
//   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteUser(@PathVariable int id) {
       service.deleteUser(id);
       return ResponseEntity.ok("User deleted successfully");
   }
   
}
