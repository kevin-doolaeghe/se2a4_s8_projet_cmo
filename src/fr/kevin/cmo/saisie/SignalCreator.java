package fr.kevin.cmo.saisie;

import fr.kevin.cmo.exception.SignalBuilderException;
import fr.kevin.cmo.signaux.SignalLogique;

public class SignalCreator {

    private CommandLineInterface cli;

    public SignalCreator() {
        cli = new CommandLineInterface();
    }

    public SignalLogique saisieSignal(String composant) {
        SignalBuilder builder = new SignalBuilder();
        try {
            System.out.print("Enter state for switch " + composant + ": ");
            return builder.build(cli.scanCommand());
        } catch (SignalBuilderException e) {
            System.out.println(e.getMessage());
            return saisieSignal(composant);
        }
    }

}
