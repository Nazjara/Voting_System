package com.nazjara.service;

import com.nazjara.model.User;
import com.nazjara.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public User save(User user) {
        Assert.notNull(user,"user must not be null");
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        Assert.notNull(user,"user must not be null");
        return repository.update(user);
    }

    @Override
    public User get(Integer id) {
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
