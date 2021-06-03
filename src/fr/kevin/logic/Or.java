package fr.kevin.logic;

public class Or extends LogicGate {

    public Or() {
        this(false, false);
    }

    public Or(boolean i1, boolean i2) {
        setInput1(i1);
        setInput2(i2);
    }

    @Override
    public boolean run() {
        return isInput1() || isInput2();
    }

}
