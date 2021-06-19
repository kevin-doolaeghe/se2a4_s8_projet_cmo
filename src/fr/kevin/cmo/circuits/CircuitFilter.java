package fr.kevin.cmo.circuits;

import fr.kevin.cmo.composants.Composant;
import fr.kevin.cmo.composants.Interrupteur;
import fr.kevin.cmo.composants.Vanne;
import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.SignalLogique;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CircuitFilter {

    private final Circuit circuit;

    public CircuitFilter(Circuit circuit) {
        this.circuit = circuit;
    }

    public List<String> filtrerId() {
        return circuit
                .getComposants()
                .stream()
                .map(c -> c.getId())
                .collect(Collectors.toList());
    }

    public List<Interrupteur> filtrerEntrees() {
        Predicate<Composant> filtre = c -> c.isEntree();
        return circuit
                .getComposants()
                .stream()
                .filter(filtre)
                .map(c -> (Interrupteur) c)
                .collect(Collectors.toList());
    }

    public List<Vanne> filtrerSorties() {
        Predicate<Composant> filtre = c -> c.isSortie();
        return circuit
                .getComposants()
                .stream()
                .filter(filtre)
                .map(c -> (Vanne) c)
                .collect(Collectors.toList());
    }

    public List<SignalLogique> evaluerSignaux() throws NonConnecteException {
        List<SignalLogique> signaux = new ArrayList<>();
        for (Vanne vanne : filtrerSorties()) signaux.add(vanne.evaluate());
        return signaux;
    }

}
