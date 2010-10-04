/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf.regeln;

import doppelkopf.Karte;
import doppelkopf.Karten;
import doppelkopf.Stich;
import java.util.Set;

/**
 *
 * @author ms
 */
public interface Rule {

    Set<Karte> apply(Karte aufgespielteKarte);

}
