package com.nazjara.repository;

import com.nazjara.model.User;
import java.util.List;

public interface UserRepository {

    boolean delete(int id);

    User save(User user);

    User get(Integer id);

    List<User> getAll();
}
