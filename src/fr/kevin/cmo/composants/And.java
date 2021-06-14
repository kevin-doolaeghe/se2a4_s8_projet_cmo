package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalLogique;

public class And extends Porte2Entrees {

    public And() { }

    public And(Composant in1, Composant in2) {
        setIn1(in1);
        setIn2(in2);
    }

    @Override
    public String getId() {
        return "And@" + this.hashCode();
    }

    @Override
    public String description() {
        String in1 = getIn1() == null ? "non connecte" : getIn1().getId();
        String in2 = getIn2() == null ? "non connecte" : getIn2().getId();
        return getId() + " in1: " + in1 + " in2: " + in2;
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        try {
            return getIn1().getEtat() && getIn2().getEtat();
        } catch (NullPointerException e) {
            throw new NonConnecteException(description(), e);
        }
    }

    @Override
    public SignalLogique evaluate() {
        try {
            return getIn1().evaluate().and(getIn2().evaluate());
        } catch (NullPointerException e) {
            return new SignalBas();
        }
    }

}
