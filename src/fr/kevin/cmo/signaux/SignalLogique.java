package fr.kevin.cmo.signaux;

public abstract class SignalLogique {

    public abstract boolean value();

    public abstract SignalLogique not();

    public abstract SignalLogique and(SignalLogique s);

    public abstract SignalLogique or(SignalLogique s);

    public abstract String toString();

}
