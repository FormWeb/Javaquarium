package models;

import enums.Sexe;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Aquarium implements IAquarium {
    private ArrayList<IEtreVivant> contenu;

    public Aquarium() {
        this.contenu = new ArrayList<>();
    }

    public int getNombreAlgue() {
        return contenu.stream()
                .filter(e -> e instanceof IAlgue)
                .toList().size();
    }

    public List<IPoisson> getPoissons() {
        return contenu.stream()
                .filter(e -> e instanceof IPoisson)
                .map(e -> (IPoisson) e).toList();
    }

    public List<IAlgue> getAlgues() {
        return contenu.stream()
                .filter(e -> e instanceof IAlgue)
                .map(e -> (IAlgue) e).toList();
    }

    public void ajouterPoisson(IPoisson poisson) {
        contenu.add(poisson);
    }

    public void ajouterAlgue(IAlgue algue) {
        contenu.add(algue);
    }

    public void passerNuit() {
        Random random = new Random();
        List<IPoisson> poissons = this.getPoissons();
        List<IAlgue> algues = this.getAlgues();

        for (IEtreVivant etreVivant : contenu) {
            etreVivant.passerTour();
        }

        for (IPoisson poisson : poissons) {
            IPoisson newPoisson = poisson.reproduce(poissons.get(random.nextInt(poissons.size())));
            if (newPoisson != null) {
                System.out.println("Un nouveau né !");
                contenu.add(newPoisson);
            }
        }

        for (IAlgue algue : algues) {
            IAlgue newAlgue = algue.seReproduire();
            if (newAlgue != null) {
                contenu.add(newAlgue);
            }
        }

        for (IEtreVivant etreVivant : contenu) {

            if (etreVivant instanceof ICarnivore) {
                if (poissons.size() > 0) {
                    ((ICarnivore) etreVivant).manger(poissons.get(random.nextInt(poissons.size())));
                }
            }

            if (etreVivant instanceof IHerbivore) {
                if (algues.size() > 0) {
                    ((IHerbivore) etreVivant).manger(algues.get(random.nextInt(algues.size())));
                }
            }
        }

        nettoyerAquarium();
    }

    public void nettoyerAquarium() {
        this.contenu = new ArrayList<>(contenu.stream()
                .filter(e -> e.getHP() > 0 && e.getAge() < 21)
                .toList());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Contenu de l'aquarium : \n");

        for (IEtreVivant etreVivant : contenu) {
            result.append(etreVivant).append("\n");
        }

        result.append("Nombre d'algue : " + getNombreAlgue());

        return result.toString();
    }
}
