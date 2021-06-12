package fr.kevin.cmo.test;

import fr.kevin.cmo.composants.And;
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
        and = new And();
    }

    @Test
    public void creation() {
        assertEquals("And@" + and.hashCode(), and.getId());
    }

}
