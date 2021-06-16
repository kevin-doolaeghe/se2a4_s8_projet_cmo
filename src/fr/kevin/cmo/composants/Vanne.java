package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalLogique;

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
        try {
            return getId() + " in: " + getIn().getId();
        } catch (NullPointerException e) {
            return getId() + " in: non connecte";
        }
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        try {
            return in.getEtat();
        } catch (NullPointerException e) {
            throw new NonConnecteException(description(), e);
        }
    }

    @Override
    public boolean isEntree() {
        return false;
    }

    @Override
    public boolean isSortie() {
        return true;
    }

    @Override
    public SignalLogique evaluate() {
        try {
            return in.evaluate();
        } catch (NullPointerException e) {
            return new SignalBas();
        }
    }
}
