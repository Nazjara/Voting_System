package com.nazjara.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant extends BaseEntity
{
    private List<Meal> menu;

    private AtomicInteger voteCounter;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Meal> menu) {
        super(id, name);
        this.menu = menu;
        this.voteCounter.set(0);
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    public int getVoteCounter() {
        return voteCounter.get();
    }

    public void setVoteCounter(int voteCounter) {
        this.voteCounter = new AtomicInteger(voteCounter);
    }

    public int incrementVoteCounter()
    {
        return this.voteCounter.incrementAndGet();
    }

    public int decrementVoteCounter()
    {
        return this.voteCounter.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", voteCounter=" + voteCounter +
                '}';
    }
}
