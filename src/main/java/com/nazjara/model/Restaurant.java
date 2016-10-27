package com.nazjara.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name",name = "restaurants_unique_name_idx")})
public class Restaurant extends BaseEntity
{
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE, mappedBy = "restaurant")
    protected List<Meal> menu;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, mappedBy = "restaurant")
    protected List<User> users;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", users=" + users +
                '}';
    }
}
