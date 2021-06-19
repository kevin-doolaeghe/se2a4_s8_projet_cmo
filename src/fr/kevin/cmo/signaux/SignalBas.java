package fr.kevin.cmo.signaux;

public class SignalBas extends SignalLogique {

    @Override
    public boolean value() {
        return false;
    }

    @Override
    public SignalLogique not() {
        return new SignalHaut();
    }

    @Override
    public String toString() {
        return "False";
    }

}
