package fr.kevin.cmo.signaux;

import fr.kevin.cmo.exception.NonConnecteException;

public interface Evaluable {

    public SignalLogique evaluate() throws NonConnecteException;

}
