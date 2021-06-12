package fr.kevin.cmo.circuits;

import fr.kevin.cmo.composants.Composant;

import java.util.ArrayList;
import java.util.List;

public class CircuitFilter {

    private Circuit circuit;

    public CircuitFilter(Circuit circuit) {
        this.circuit = circuit;
    }

    public List<Composant> filtrerComposants(String nom) {
        List<Composant> composants = new ArrayList<>();
        for (Composant composant : composants) {
            if ((composant.getId().split("@"))[0].compareTo(nom) == 0)
                composants.add(composant);
        }
        return composants;
    }

}
