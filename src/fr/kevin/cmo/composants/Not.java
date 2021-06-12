package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.SignalLogique;

public class Not extends Porte {

    private Composant in;

    public Not() { }

    public Not(Composant in) {
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
        return "Not@" + this.hashCode();
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
        return !in.getEtat();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

    @Override
    public SignalLogique evaluate() {
        return in.evaluate().not();
    }

}
