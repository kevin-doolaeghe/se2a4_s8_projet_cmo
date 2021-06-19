package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.SignalLogique;

public class Or extends Porte2Entrees {

    public Or() { }

    public Or(Composant in1, Composant in2) {
        setIn1(in1);
        setIn2(in2);
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        try {
            return getIn1().getEtat() || getIn2().getEtat();
        } catch (NullPointerException e) {
            throw new NonConnecteException(description(), e);
        }
    }

    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        try {
            return getIn1().evaluate().or(getIn2().evaluate());
        } catch (NullPointerException e) {
            throw new NonConnecteException("non connecte", e);
        }
    }

}
