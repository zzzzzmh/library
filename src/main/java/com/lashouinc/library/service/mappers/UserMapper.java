package com.lashouinc.library.service.mappers;

import com.lashouinc.library.service.domain.User;

public interface UserMapper {
	int saveUser(User user);
	int updateUser(User user);
	User findUserByName(String name);
}