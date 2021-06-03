package fr.kevin.logic;

public abstract class LogicGate {

    protected boolean input1;
    protected boolean input2;
    protected boolean output;

    public abstract boolean run();

    public boolean isInput1() {
        return input1;
    }

    public void setInput1(boolean input1) {
        this.input1 = input1;
    }

    public boolean isInput2() {
        return input2;
    }

    public void setInput2(boolean input2) {
        this.input2 = input2;
    }

    public boolean isOutput() {
        return output;
    }

}
