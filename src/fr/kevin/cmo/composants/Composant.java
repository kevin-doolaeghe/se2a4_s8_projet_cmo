package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.Evaluable;

public abstract class Composant implements Comparable, Evaluable {

    public String getId() {
        return getClass().getSimpleName() + "@" + this.hashCode();
    }

    public abstract String description();

    public abstract boolean getEtat() throws NonConnecteException;

    public abstract boolean isEntree();

    public abstract boolean isSortie();

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

}
