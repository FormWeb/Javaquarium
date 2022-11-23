package models;

import interfaces.IPoisson;

public class Carpe extends Herbivore {
    public Carpe(String name) {
        super(name);
    }


    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof Carpe
                && poisson.getSexe() != this.getSexe()) {
            System.out.println("Bébé");
            return new Carpe("Bébé");
        }
        else return null;
    }
}
