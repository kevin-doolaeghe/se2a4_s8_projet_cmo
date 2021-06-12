package fr.kevin.cmo.test;

import fr.kevin.cmo.signaux.SignalBas;
import fr.kevin.cmo.signaux.SignalHaut;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class SignalTest {

    private SignalHaut haut;
    private SignalBas bas;

    public SignalTest() {
        setup();
    }

    @BeforeEach
    private void setup() {
        haut = new SignalHaut();
        bas = new SignalBas();
    }

    @Test
    public void value() {
        assertTrue(haut.value());
        assertFalse(bas.value());
    }

    @Test
    public void not() {
        assertTrue(haut.not() instanceof SignalBas);
        assertTrue(bas.not() instanceof SignalHaut);
    }

    @Test
    public void and() {
        assertTrue(bas.and(bas) instanceof SignalBas);
        assertTrue(haut.and(bas) instanceof SignalBas);
        assertTrue(bas.and(haut) instanceof SignalBas);
        assertTrue(haut.and(haut) instanceof SignalHaut);
    }

    @Test
    public void or() {
        assertTrue(bas.or(bas) instanceof SignalBas);
        assertTrue(haut.or(bas) instanceof SignalHaut);
        assertTrue(bas.or(haut) instanceof SignalHaut);
        assertTrue(haut.or(haut) instanceof SignalHaut);
    }

}
