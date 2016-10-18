package com.nazjara.service;

import com.nazjara.model.User;
import com.nazjara.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
