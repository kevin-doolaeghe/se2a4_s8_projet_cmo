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
    public String description() {
        try {
            return getId() + " in: " + getIn().getId();
        } catch (NullPointerException e) {
            return getId() + " in: non connecte";
        }
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        try {
            return !in.getEtat();
        } catch (NullPointerException e) {
            throw new NonConnecteException(description(), e);
        }
    }

    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        try {
            return in.evaluate().not();
        } catch (NullPointerException e) {
            throw new NonConnecteException("non connecte", e);
        }
    }

}
