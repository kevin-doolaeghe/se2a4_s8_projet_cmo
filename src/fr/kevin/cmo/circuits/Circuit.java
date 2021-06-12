package fr.kevin.cmo.circuits;

import fr.kevin.cmo.composants.Composant;
import fr.kevin.cmo.composants.Interrupteur;
import fr.kevin.cmo.composants.Vanne;
import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.Evaluable;
import fr.kevin.cmo.signaux.SignalLogique;

import java.util.*;

public class Circuit implements Evaluable {

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
        for (Composant composant : composants) {
            System.out.print("\t- " + composant + " ");
            try {
                System.out.println(composant.getEtat());
            } catch (NonConnecteException e) {
                System.out.println("non connecte");
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public SignalLogique evaluate() {
        List<Vanne> liste = getOutputs();
        List<SignalLogique> signaux = new ArrayList<>();
        for (Vanne vanne : liste)
            signaux.add(vanne.evaluate());
        return signaux.get(0);
    }

}
