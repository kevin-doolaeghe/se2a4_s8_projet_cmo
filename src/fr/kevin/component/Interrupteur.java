package fr.kevin.component;

import fr.kevin.exception.NonConnecteException;

public class Interrupteur extends Composant {

    protected boolean etat;

    public void on() {
        etat = true;
    }

    public void off() {
        etat = false;
    }

    @Override
    public String getId() {
        return "Interrupteur@" + this.hashCode();
    }

    @Override
    public String description() {
        return getId();
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        return etat;
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

}
