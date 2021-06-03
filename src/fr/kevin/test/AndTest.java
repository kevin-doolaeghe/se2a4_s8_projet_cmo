package fr.kevin.test;

import fr.kevin.logic.And;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class AndTest {

    private And and;

    public AndTest() {
        setup();
    }

    @BeforeEach
    private void setup() {
        and = new And(true, false);
    }

    @Test
    public void creation() {
        assertTrue(and.isInput1());
        assertFalse(and.isInput2());
    }

    @Test
    public void run() {
        assertFalse(new And(false, false).run());
        assertFalse(new And(false, true).run());
        assertFalse(new And(true, false).run());
        assertTrue(new And(true, true).run());
    }

}
