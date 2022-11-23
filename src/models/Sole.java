package models;

import enums.Sexe;
import interfaces.IPoisson;

public class Sole extends Herbivore{
    public Sole(String name) {
        super(name);
    }

    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof Sole) {
            if (poisson.getSexe() == this.getSexe()) {
                if (this.getSexe() == Sexe.MALE) {
                    this.setSexe(Sexe.FEMELLE);
                }
                else {
                    this.setSexe(Sexe.MALE);
                }
            }
            return new Bar("Bébé");
        }
        else return null;
    }
}
