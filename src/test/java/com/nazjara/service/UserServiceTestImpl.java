package com.nazjara.service;

import com.nazjara.model.Role;
import com.nazjara.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.nazjara.UserTestData.ADMIN;
import static com.nazjara.UserTestData.MATCHER;
import static com.nazjara.UserTestData.USER;

public class UserServiceTestImpl extends AbstractServiceTest {

    @Autowired
    protected UserService service;

    @Test
    public void testSave() throws Exception {
        User newUser = new User(null, "New", "new@gmail.com", "newPass", Role.ROLE_USER);
        User created = service.save(newUser);
        newUser.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER, newUser), service.getAll());
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateSave() throws Exception {
        User duplicateUser = new User(null, "Duplicate", "user@gmail.com", "newPass", Role.ROLE_USER);
        service.save(duplicateUser);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(USER.getId());
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), service.getAll());
    }

    @Test
    public void testGet() throws Exception {
        User user = service.get(USER.getId());
        MATCHER.assertEquals(USER, user);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<User> all = service.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), all);
    }

    @Test
    public void testUpdate() throws Exception {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        updated.setEmail("updated@gmail.com");
        service.update(updated, updated.getId());
        MATCHER.assertEquals(updated, service.get(USER.getId()));
    }
}