import interfaces.IAlgue;
import interfaces.IPoisson;
import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        IPoisson p1 = new Carpe("Jean");
        IPoisson p3 = new Carpe("Jean-Jacques");

        IAlgue a1 = new Algue();
        IAlgue a2 = new Algue();

        Aquarium aquarium = new Aquarium();
        aquarium.ajouterPoisson(p1);
        aquarium.ajouterPoisson(p3);

        aquarium.ajouterAlgue(a1);
        aquarium.ajouterAlgue(a2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(aquarium);
            scanner.nextLine();
            aquarium.passerNuit();
        }
    }
}