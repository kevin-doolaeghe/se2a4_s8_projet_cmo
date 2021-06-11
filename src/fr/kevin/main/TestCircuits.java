package fr.kevin.main;

import fr.kevin.component.*;
import fr.kevin.exception.NonConnecteException;

import java.util.ArrayList;
import java.util.List;

public class TestCircuits {

    public void traceEtats(ArrayList<Composant> circuit) {
        for(Composant composant : circuit) {
            try {
                System.out.println(composant.description() + " -> " + composant.getEtat());
            } catch (NonConnecteException e) {
                System.out.println(composant.description() + " -> non connecte");
            }
        }
    }

    public static void test(Circuit circ) {
        System.out.println("Identifiants:");
        List<String> ids = circ.nomenclature();
        for (String id : ids)
            System.out.println("\t- " + id);

        circ.description();

        System.out.println("Entrées:");
        List<Interrupteur> inputs = circ.getInputs();
        for (Interrupteur i : inputs)
            System.out.println("\t- " + i.getId());

        System.out.println("Sorties:");
        List<Vanne> outputs = circ.getOutputs();
        for (Vanne o : outputs)
            System.out.println("\t- " + o.getId());

        inputs.get(2).off();
        circ.traceEtats();
    }

    public static void main(String[] args) {
        Interrupteur i1 = new Interrupteur();
        Interrupteur i2 = new Interrupteur();
        Interrupteur securite = new Interrupteur();
        Or or = new Or(i1, i2);
        Not not = new Not(securite);
        And and = new And(or, not);
        Vanne vanne = new Vanne(and);

        i1.on();
        i2.off();
        securite.on();

        List<Composant> composants = new ArrayList<>();
        composants.add(i1);
        composants.add(i2);
        composants.add(securite);
        composants.add(or);
        composants.add(not);
        composants.add(and);
        composants.add(vanne);

        // new TestCircuits().traceEtats(composants);

        Composant[] cps = composants.toArray(new Composant[0]);
        Circuit circuit = new Circuit("monCircuit", cps);
        test(circuit);
    }

}
