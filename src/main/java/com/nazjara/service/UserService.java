package com.nazjara.service;

import com.nazjara.model.User;

import java.util.List;

/**
 * Created by Administrator on 18.10.2016.
 */
public interface UserService {

    void delete(int id);

    User save(User user);

    User update(User user);

    User get(Integer id);

    List<User> getAll();
}
