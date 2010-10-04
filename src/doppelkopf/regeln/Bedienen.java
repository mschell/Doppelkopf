/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf.regeln;

import doppelkopf.DoppelKopfBlatt;
import doppelkopf.Karte;
import java.util.Set;

/**
 *
 * @author ms
 */
public class Bedienen implements Rule{

    public Set<Karte> apply(Karte aufgespielteKarte) {
        if(aufgespielteKarte.isTrumpf()){
            return DoppelKopfBlatt.getTrumpf();
        }else{
            return DoppelKopfBlatt.getFarbe(aufgespielteKarte.getFarbe());
        }
    }


}
