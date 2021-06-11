package fr.kevin.component;

import fr.kevin.exception.NonConnecteException;

import java.util.*;

public class Circuit {

    List<Composant> composants;
    private String nom;

    public Circuit(String nom, Composant[] cps) {
        composants = Arrays.asList(cps);
        Collections.sort(composants);
        this.nom = nom;
    }

    public List<String> nomenclature() {
        List<String> liste = new ArrayList<>();
        for (Composant c : composants)
            liste.add(c.getId());

        return liste;
    }

    public void description() {
        System.out.println(this.nom + ":");
        for (Composant c : composants)
            System.out.println("\t-" + c.description());
    }

    public void traceEtats() {
        System.out.println(this.nom + ":");
        for (Composant c : composants) {
            try {
                System.out.println("\t- " + c.getEtat());
            } catch (NonConnecteException e) {
                System.out.println("\t- non connecte");
            }
        }
    }

    public List<Interrupteur> getInputs() {
        List<Interrupteur> liste = new ArrayList<>();

        for (Composant c : composants) {
            if ((c.getId().split("@"))[0].compareTo("Interrupteur") == 0)
                liste.add((Interrupteur) c);
        }

        return liste;
    }

    public List<Vanne> getOutputs() {

        List<Vanne> liste = new ArrayList<>();

        for (Composant c : composants) {
            if ((c.getId().split("@"))[0].compareTo("Vanne") == 0)
                liste.add((Vanne) c);
        }

        return liste;
    }

}
