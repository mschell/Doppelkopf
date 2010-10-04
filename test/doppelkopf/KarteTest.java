/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

import doppelkopf.Karte.Farbe;
import doppelkopf.Karte.Trumpf;
import doppelkopf.Karte.Wert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ms
 */
public class KarteTest {

    public KarteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of sticht method, of class Karte.
     */
    @Test
    public void testSticht() {
        System.out.println("sticht");
        Karte a = new Karte(Farbe.Karo,Wert.Bube);
        Karte b = new Karte(Farbe.Karo,Wert.Zehn);

        boolean result = Karte.sticht(a, b);
        assertEquals(true, result);
     
    }



}