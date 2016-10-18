package com.nazjara.repository;

import com.nazjara.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

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
