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
    public SignalLogique and(SignalLogique s) {
        return new SignalBas();
    }

    @Override
    public SignalLogique or(SignalLogique s) {
        if (value() || s.value())
            return new SignalHaut();
        else
            return new SignalBas();
    }

    @Override
    public String toString() {
        return "False";
    }
}
