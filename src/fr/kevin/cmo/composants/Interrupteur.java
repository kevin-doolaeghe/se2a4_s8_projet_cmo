package fr.kevin.cmo.composants;

import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalHaut;
import fr.kevin.cmo.signaux.SignalLogique;

public class Interrupteur extends Composant {

    protected SignalLogique etat;

    public void on() {
        etat = new SignalHaut();
    }

    public void off() {
        etat = new SignalBas();
    }

    @Override
    public String getId() {
        return "Interrupteur@" + this.hashCode();
    }

    @Override
    public String description() {
        return getId();
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        return etat.value();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode();
    }

    @Override
    public SignalLogique evaluate() {
        return etat;
    }

}
