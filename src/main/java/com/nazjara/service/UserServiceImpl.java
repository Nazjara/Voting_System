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
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public User save(User user) {
        Assert.notNull(user,"user must not be null");
        user.setId(null);
        return repository.save(user);
    }

    @Override
    public User update(User user, int id) {
        Assert.notNull(user,"user must not be null");
        user.setId(id);
        return repository.save(user);
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
