package fr.kevin.cmo.main;

import fr.kevin.cmo.circuits.Circuit;
import fr.kevin.cmo.composants.*;
import fr.kevin.cmo.exception.NonConnecteException;
import fr.kevin.cmo.saisie.SignalCreator;

import java.util.List;

public class TestCircuits {

    public static void traceEtats(List<Composant> composants) {
        composants.forEach(composant -> {
            System.out.print("\t- " + composant.description() + " -> ");
            try {
                System.out.println(composant.getEtat());
            } catch (NonConnecteException e) {
                System.out.println("non connecte");
            }
        });
    }

    public static void test(Circuit circuit) {
        circuit.description();

        System.out.println("ID list:");
        circuit.nomenclature().forEach(id -> System.out.println("\t- " + id));

        System.out.println("Inputs:");
        circuit.getInputs().forEach(i -> System.out.println("\t- " + i.getId()));

        System.out.println("Outputs:");
        circuit.getOutputs().forEach(o -> System.out.println("\t- " + o.getId()));

        circuit.traceEtats();
    }

    public static void traitementSignaux(Circuit c) {
        SignalCreator selector = new SignalCreator();
        c.getInputs().forEach(i -> {
            if (selector.saisieSignal(i.getId()).value()) i.on();
            else i.off();
        });

        System.out.print("Le circuit " + c.getNom() + " est ");
        try {
            System.out.println(c.evaluate().value() ? "allumé." : "éteint.");
        } catch (NonConnecteException e) {
            System.out.println(e.getMessage());
        }
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

        List<Composant> composants = List.of(i1, i2, is, or, not, and, vanne);

        Composant[] cps = composants.toArray(new Composant[0]);
        Circuit circuit = new Circuit("monCircuit", cps);

        System.out.println("-------------------------------------------------------------------");
        traceEtats(composants);
        System.out.println("-------------------------------------------------------------------");
        test(circuit);
        System.out.println("-------------------------------------------------------------------");
        traitementSignaux(circuit);
        System.out.println("-------------------------------------------------------------------");
    }

}
