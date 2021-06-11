package fr.kevin.component;

import fr.kevin.exception.NonConnecteException;

public class Or extends Porte2Entrees {

    public Or() { }

    public Or(Composant in1, Composant in2) {
        setIn1(in1);
        setIn2(in2);
    }

    @Override
    public String getId() {
        return "Or@" + this.hashCode();
    }

    @Override
    public String description() {
        String in1 = getIn1() == null ? "non connecte" : getIn1().getId();
        String in2 = getIn2() == null ? "non connecte" : getIn2().getId();
        return getId() + " in1: " + in1 + " in2: " + in2;
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        if (getIn1() == null || getIn2() == null) {
            throw new NonConnecteException();
        }
        return getIn1().getEtat() || getIn2().getEtat();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

}
