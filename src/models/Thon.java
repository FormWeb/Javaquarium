package models;

import interfaces.IPoisson;

public class Thon extends Carnivore {
    public Thon(String name) {
        super(name);
    }

    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof Thon
                && poisson.getSexe() != this.getSexe()) {
            return new Thon("Bébé");
        }
        else return null;
    }
}
