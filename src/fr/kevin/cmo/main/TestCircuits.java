package fr.kevin.cmo.main;

import fr.kevin.cmo.circuits.Circuit;
import fr.kevin.cmo.composants.*;
import fr.kevin.cmo.saisie.SignalCreator;

import java.util.ArrayList;
import java.util.List;

public class TestCircuits {

    public static void test(Circuit circuit) {
        circuit.description();

        System.out.println("ID list:");
        List<String> ids = circuit.nomenclature();
        for (String id : ids)
            System.out.println("\t- " + id);

        System.out.println("Inputs:");
        List<Interrupteur> inputs = circuit.getInputs();
        for (Interrupteur i : inputs)
            System.out.println("\t- " + i.getId());

        System.out.println("Outputs:");
        List<Vanne> outputs = circuit.getOutputs();
        for (Vanne o : outputs)
            System.out.println("\t- " + o.getId());

        circuit.traceEtats();
    }

    public static void traitementSignaux(Circuit c) {
        List<Interrupteur> inputs = c.getInputs();
        SignalCreator selector = new SignalCreator();
        for (Interrupteur input : inputs) {
            if (selector.saisieSignal(input.getId()).value()) input.on();
            else input.off();
        }
        System.out.println("Le circuit " + c.getNom() + " est " + (c.evaluate().value() ? "allumé." : "éteint."));
    }

    public static void main(String[] args) {
        Interrupteur i1 = new Interrupteur();
        Interrupteur i2 = new Interrupteur();
        Interrupteur is = new Interrupteur();
        Or or = new Or(i1, i2);
        Not not = new Not(is);
        And and = new And(or, not);
        Vanne vanne = new Vanne(and);

        i1.on();
        i2.off();
        is.on();

        List<Composant> composants = new ArrayList<>();
        composants.add(i1);
        composants.add(i2);
        composants.add(is);
        composants.add(or);
        composants.add(not);
        composants.add(and);
        composants.add(vanne);

        Composant[] cps = composants.toArray(new Composant[0]);
        Circuit circuit = new Circuit("monCircuit", cps);

        test(circuit);
        traitementSignaux(circuit);
    }

}
