package fr.kevin.cmo.circuits;

import fr.kevin.cmo.composants.Composant;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CircuitFilter {

    private Circuit circuit;

    public CircuitFilter(Circuit circuit) {
        this.circuit = circuit;
    }

    public List<Composant> filtrerComposants(String nom) {
        Predicate<Composant> filtre = c -> c.getId().split("@")[0].compareTo(nom) == 0;
        return circuit.getComposants().stream().filter(filtre).collect(Collectors.toList());
    }

}
