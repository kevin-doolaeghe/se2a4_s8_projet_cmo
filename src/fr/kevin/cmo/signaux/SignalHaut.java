package fr.kevin.cmo.signaux;

public class SignalHaut extends SignalLogique {

    @Override
    public boolean value() {
        return true;
    }

    @Override
    public SignalLogique not() {
        return new SignalBas();
    }

    @Override
    public String toString() {
        return "True";
    }

}
