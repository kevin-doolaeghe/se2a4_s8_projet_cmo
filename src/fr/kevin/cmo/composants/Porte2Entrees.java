package fr.kevin.cmo.composants;

public abstract class Porte2Entrees extends Porte {

    private Composant in1;
    private Composant in2;

    @Override
    public String description() {
        String in1 = getIn1() == null ? "non connecte" : getIn1().getId();
        String in2 = getIn2() == null ? "non connecte" : getIn2().getId();
        return getId() + " in1: " + in1 + " in2: " + in2;
    }

    public Composant getIn1() {
        return in1;
    }

    public void setIn1(Composant in1) {
        this.in1 = in1;
    }

    public Composant getIn2() {
        return in2;
    }

    public void setIn2(Composant in2) {
        this.in2 = in2;
    }
}
