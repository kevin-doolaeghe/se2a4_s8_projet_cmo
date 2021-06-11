package fr.kevin.component;

import fr.kevin.exception.NonConnecteException;

public class Vanne extends Composant {

    private Composant in;

    public Vanne() { }

    public Vanne(Composant in) {
        setIn(in);
    }

    public Composant getIn() {
        return in;
    }

    public void setIn(Composant in) {
        this.in = in;
    }

    @Override
    public String getId() {
        return "Vanne@" + this.hashCode();
    }

    @Override
    public String description() {
        if (in == null)
            return getId() + " in: non connecte";
        else
            return getId() + " in: " + getIn().getId();
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        if (in == null) {
            throw new NonConnecteException();
        }
        return in.getEtat();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

}
