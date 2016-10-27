package com.nazjara.service;

import com.nazjara.model.User;

import java.util.List;

public interface UserService {

    void delete(int id);

    User save(User user);

    User update(User user, int id);

    User get(Integer id);

    List<User> getAll();
}
