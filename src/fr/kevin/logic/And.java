package fr.kevin.logic;

public class And extends LogicGate {

    public And() {
        this(false, false);
    }

    public And(boolean i1, boolean i2) {
        setInput1(i1);
        setInput2(i2);
    }

    @Override
    public boolean run() {
        return isInput1() && isInput2();
    }

}
