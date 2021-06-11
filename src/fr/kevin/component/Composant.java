package fr.kevin.component;

import fr.kevin.exception.NonConnecteException;

public abstract class Composant implements Comparable {

    public abstract String getId();

    public abstract String description();

    public abstract boolean getEtat() throws NonConnecteException;

}
