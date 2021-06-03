package fr.kevin.test;

import fr.kevin.logic.Or;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class OrTest {

    private Or or;

    public OrTest() {
        setup();
    }

    @BeforeEach
    private void setup() {
        or = new Or(true, false);
    }

    @Test
    public void creation() {
        assertTrue(or.isInput1());
        assertFalse(or.isInput2());
    }

    @Test
    public void run() {
        assertFalse(new Or(false, false).run());
        assertTrue(new Or(false, true).run());
        assertTrue(new Or(true, false).run());
        assertTrue(new Or(true, true).run());
    }

}
