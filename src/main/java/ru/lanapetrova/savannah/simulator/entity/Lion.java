package ru.lanapetrova.savannah.simulator.entity;

public class Lion {

    // 100 hp
    // 100 энергии
    // коэффициент зубов - сколько энергии волк получает, когда кого-то съест

    private int health = 100;
    private int energy = 100;
    private double attack = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getAttack() {
        return this.attack;
    }
}
