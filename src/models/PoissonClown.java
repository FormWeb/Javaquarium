package models;

import enums.Sexe;
import interfaces.IPoisson;

public class PoissonClown extends Carnivore{
    public PoissonClown(String name) {
        super(name);
    }

    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof PoissonClown) {
            if (poisson.getSexe() == this.getSexe()) {
                if (this.getSexe() == Sexe.MALE) {
                    this.setSexe(Sexe.FEMELLE);
                }
                else {
                    this.setSexe(Sexe.MALE);
                }
            }
            return new PoissonClown("Bébé");
        }
        else return null;
    }
}
