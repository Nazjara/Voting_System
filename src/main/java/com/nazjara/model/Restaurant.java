package com.nazjara.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name",name = "restaurants_unique_name_idx")})
public class Restaurant extends BaseEntity
{
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, mappedBy = "restaurant")
    private List<Meal> menu;

    @Column(name = "votes", columnDefinition = "default 0")
    private Integer votes;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Meal> menu) {
        super(id, name);
        this.menu = menu;
        this.votes = 0;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", votes=" + votes +
                '}';
    }
}
