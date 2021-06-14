package fr.kevin.cmo.circuits;

import fr.kevin.cmo.composants.Composant;
import fr.kevin.cmo.composants.Interrupteur;
import fr.kevin.cmo.composants.Vanne;
import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.Evaluable;
import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalLogique;

import java.util.*;
import java.util.stream.Collectors;

public class Circuit implements Evaluable {

    private List<Composant> composants;

    private String nom;

    public Circuit(String nom, Composant[] cps) {
        this.nom = nom;
        composants = new ArrayList<>();
        composants.addAll(Arrays.asList(cps));
        Collections.sort(composants);
    }

    public List<String> nomenclature() {
        return composants.stream().map(c -> c.getId()).collect(Collectors.toList());
    }

    public void description() {
        System.out.println(this.nom + ":");
        composants.forEach(c -> System.out.println("\t-" + c.description()));
    }

    public void traceEtats() {
        System.out.println(this.nom + ":");
        for (Composant composant : composants) {
            System.out.print("\t- " + composant.getId() + " ");
            try {
                System.out.println(composant.getEtat());
            } catch (NonConnecteException e) {
                System.out.println("non connecte");
            }
        }
    }

    public List<Interrupteur> getInputs() {
        List<Composant> res = new CircuitFilter(this).filtrerComposants("Interrupteur");
        return res.stream().map(c -> (Interrupteur) c).collect(Collectors.toList());
    }

    public List<Vanne> getOutputs() {
        List<Composant> res = new CircuitFilter(this).filtrerComposants("Vanne");
        return res.stream().map(c -> (Vanne) c).collect(Collectors.toList());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    @Override
    public SignalLogique evaluate() {
        try {
            return getOutputs().stream().map(v -> v.evaluate()).collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException e) {
            return new SignalBas();
        }
    }

}
