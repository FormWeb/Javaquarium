package models;

import interfaces.IAlgue;

public class Algue extends EtreVivant implements IAlgue {
    public Algue() {
        this.setHP(5);
        this.setAge(0);
    }

    public Algue(int pv) {
        this();
        this.setHP(pv);
    }

    @Override
    public void passerTour() {
        this.setHP(this.getHP() + 1);
        this.setAge(this.getAge() + 1);
    }

    public IAlgue seReproduire() {
        if (this.getHP() > 9) {
            this.setHP(this.getHP() / 2);
            return new Algue(this.getHP() / 2);
        }
        else {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Je suis une algue avec %s pv !", this.getHP());
    }
}
