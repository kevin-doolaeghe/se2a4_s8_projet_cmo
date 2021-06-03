package fr.kevin.main;

import fr.kevin.test.AndTest;
import fr.kevin.test.OrTest;

public class Main {

    public static void main(String[] args) {
        AndTest andTest = new AndTest();
        andTest.creation();
        andTest.run();

        OrTest orTest = new OrTest();
        orTest.creation();
        orTest.run();
    }

}
