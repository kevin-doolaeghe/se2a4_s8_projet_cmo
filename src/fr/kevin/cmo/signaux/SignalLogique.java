package fr.kevin.cmo.signaux;

public abstract class SignalLogique {

    public abstract boolean value();

    public abstract SignalLogique not();

    public SignalLogique and(SignalLogique s) {
        if (value() && s.value())
            return new SignalHaut();
        else
            return new SignalBas();
    }

    public SignalLogique or(SignalLogique s) {
        if (value() || s.value())
            return new SignalHaut();
        else
            return new SignalBas();
    }

    public abstract String toString();

}
