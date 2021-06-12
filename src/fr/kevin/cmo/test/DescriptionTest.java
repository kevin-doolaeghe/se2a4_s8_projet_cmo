package fr.kevin.cmo.test;

import fr.kevin.cmo.composants.And;
import fr.kevin.cmo.composants.Not;
import org.junit.Test;

import static org.junit.Assert.*;

public class DescriptionTest {

    @Test
    public void testDescription() {
        Not not = new Not();
        And and = new And();
        and.setIn2(not);

        assertEquals("And@" + and.hashCode() + " in1: non connecte in2: Not@" + not.hashCode(),
                and.description());
    }

}
