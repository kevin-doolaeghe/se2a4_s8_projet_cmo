package fr.kevin.cmo.composants;

public abstract class Porte extends Composant {

    @Override
    public boolean isEntree() {
        return false;
    }

    @Override
    public boolean isSortie() {
        return false;
    }

}
