package fr.kevin.main;

import fr.kevin.test.AndTest;
import fr.kevin.test.DescriptionTest;
import fr.kevin.test.OrTest;

public class Main {

    public void unitTest() {
        AndTest andTest = new AndTest();
        andTest.creation();

        OrTest orTest = new OrTest();
        orTest.creation();

        DescriptionTest descriptionTest = new DescriptionTest();
        descriptionTest.testDescription();
    }

    public static void main(String[] args) {
        new Main().unitTest();
    }

}
