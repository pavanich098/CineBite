package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.UserRepository;

@Service("/userService")

public class IUserServiceImpl implements IUserService 
{
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User createUser(User user) 
	{
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	@Override
	public User getUserById(int id) 
	{
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() 
	{
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User updateUser(int id, User user) 
	{
		Optional<User> existinguseropt=repo.findById(id);
		if(existinguseropt.isPresent())
		{
			User existingUser=existinguseropt.get();
			existingUser.setName(user.getName());
			existingUser.setPassword(user.getPassword());
			existingUser.setEmail(user.getEmail());
			existingUser.setAddress(user.getAddress());
			existingUser.setPhone(user.getPhone());
			existingUser.setRole(user.getRole());
			return repo.save(existingUser);
		}
		
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
