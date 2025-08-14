package com.nt.service;

import java.util.List;

import com.nt.entity.User;

public interface IUserService 
{
   User createUser(User user);
   User getUserById(int id);
   List<User> getAllUsers();
   User updateUser(int id,User user);
   void deleteUser(int id);
}
