package interfaces;

import enums.Sexe;
import models.Poisson;

public interface IPoisson extends IEtreVivant {
    Sexe getSexe();
    String getName();
    IPoisson reproduce(IPoisson poisson);
}
