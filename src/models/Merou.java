package models;

import enums.Sexe;
import interfaces.IPoisson;

public class Merou extends Carnivore{
    public Merou(String name) {
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
                && poisson instanceof Merou
                && poisson.getSexe() != this.getSexe()) {

            return new Merou("Bébé");
        }
        else {
            System.out.println("Pas bébé");
            return null;
        }
    }
}
