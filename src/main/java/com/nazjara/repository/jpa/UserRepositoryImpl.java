package com.nazjara.repository.jpa;

import com.nazjara.model.Role;
import com.nazjara.model.User;
import com.nazjara.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createQuery("DELETE FROM User u WHERE u.id=:id").setParameter("id",id).executeUpdate() != 0;
    }

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    public User get(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u",User.class).getResultList();
    }
}
