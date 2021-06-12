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
    public SignalLogique and(SignalLogique s) {
        if (value() && s.value())
            return new SignalHaut();
        else
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
        return "True";
    }
}
