/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

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
public class GespielteKarteTest {

    public GespielteKarteTest() {
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
     * Test of stichtAufspiel method, of class GespielteKarte.
     */
    @Test
    public void testStichtAufspiel() {
        System.out.println("stichtAufspiel");
        GespielteKarte aufspiel = new GespielteKarte(new Karte(Karte.Farbe.Karo,Karte.Wert.Bube), Person.A);
        GespielteKarte zehn = new GespielteKarte(aufspiel,new Karte(Karte.Farbe.Karo,Karte.Wert.Zehn), Person.B);
        boolean expResult = true;
        boolean result = zehn.stichtAufspiel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



}