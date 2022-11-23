package models;

import interfaces.IEtreVivant;

public abstract class EtreVivant implements IEtreVivant {
    private int HP;
    private int age;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }
}
