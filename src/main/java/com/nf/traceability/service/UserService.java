package com.nf.traceability.service;

import com.nf.traceability.domain.User;
import com.nf.traceability.exception.domain.UserNotFoundException;
import com.nf.traceability.exception.domain.UsernameExistException;

import java.util.List;

public interface UserService {

    User register(String username) throws UserNotFoundException, UsernameExistException;

    List<User> getUsers();

    User findUserByUsername(String username);

}
