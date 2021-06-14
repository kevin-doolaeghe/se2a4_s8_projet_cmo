package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.Evaluable;

public abstract class Composant implements Comparable, Evaluable {

    public abstract String getId();

    public abstract String description();

    public abstract boolean getEtat() throws NonConnecteException;

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

}
