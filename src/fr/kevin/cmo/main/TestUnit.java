package fr.kevin.cmo.main;

import fr.kevin.cmo.test.AndTest;
import fr.kevin.cmo.test.DescriptionTest;
import fr.kevin.cmo.test.OrTest;
import fr.kevin.cmo.test.SignalTest;

public class TestUnit {

    public static void unitTest() {
        AndTest test = new AndTest();
        test.creation();

        OrTest orTest = new OrTest();
        orTest.creation();

        DescriptionTest descriptionTest = new DescriptionTest();
        descriptionTest.testDescription();

        SignalTest signalTest = new SignalTest();
        signalTest.value();
        signalTest.not();
        signalTest.and();
        signalTest.or();
    }

    public static void main(String[] args) {
        unitTest();
    }

}
