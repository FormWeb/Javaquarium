package models;

import enums.Sexe;
import interfaces.IPoisson;

public class Bar extends Herbivore{
    public Bar(String name) {
        super(name);
    }

    @Override
    public Sexe getSexe() {
        if (this.getAge() < 10) {
            return Sexe.MALE;
        }
        else {
            return Sexe.FEMELLE;
        }
    }

    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
            && poisson instanceof Bar
            && poisson.getSexe() != this.getSexe()) {

            return new Bar("Bébé");
        }
        else return null;
    }
}
