package fr.kevin.cmo.composants;

import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalHaut;
import fr.kevin.cmo.signaux.SignalLogique;

public class Interrupteur extends Composant {

    private SignalLogique etat;

    public Interrupteur() {
        off();
    }

    public void on() {
        etat = new SignalHaut();
    }

    public void off() {
        etat = new SignalBas();
    }

    @Override
    public String description() {
        return getId();
    }

    @Override
    public boolean getEtat() {
        return etat.value();
    }

    @Override
    public boolean isEntree() {
        return true;
    }

    @Override
    public boolean isSortie() {
        return false;
    }

    @Override
    public SignalLogique evaluate() {
        return etat;
    }

}
