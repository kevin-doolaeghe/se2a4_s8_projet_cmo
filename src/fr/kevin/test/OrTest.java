package fr.kevin.test;

import fr.kevin.component.Or;
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
        or = new Or();
    }

    @Test
    public void creation() {
        assertEquals("Or@" + or.hashCode(), or.getId());
    }

}
