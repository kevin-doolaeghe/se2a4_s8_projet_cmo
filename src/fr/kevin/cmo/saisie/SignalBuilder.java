package fr.kevin.cmo.saisie;

import fr.kevin.cmo.exception.SignalBuilderException;
import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalHaut;
import fr.kevin.cmo.signaux.SignalLogique;

public class SignalBuilder {

    public SignalLogique build(String data) throws SignalBuilderException {
        try {
            int state = Integer.parseInt(data);
            switch (state) {
                case 1:
                    return new SignalHaut();
                case 0:
                    return new SignalBas();
                default:
                    throw new SignalBuilderException("Data input must be either 0 or 1");
            }
        } catch (NumberFormatException e) {
            throw new SignalBuilderException("Data input must be integer", e);
        }
    }

}
