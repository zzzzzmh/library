package com.lashouinc.library.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.lashouinc.library.service.UserService;
import com.lashouinc.library.service.domain.User;
import com.lashouinc.library.service.mappers.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	UserMapper userMapper;
	
	@Resource
	HashedCredentialsMatcher credentialsMatcher;
	
	
	public User createUser(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		userMapper.saveUser(user);
		return user;
	}
	
	private String hashPassword(String password) {
		String salt = "library-salt";
		String password2 = new Md5Hash(password, salt, 2).toHex();
		return password2;		
	}

	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(userId);
		user.setPassword(hashPassword(newPassword));
		userMapper.updateUser(user);
	}

	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
	}

	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	public User findByUsername(String username) {
		return userMapper.findUserByName(username);
	}

	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
