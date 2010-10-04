/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ms
 */
public class Stich {

    enum Type{
        NORMAL, CHARLY, DOPPELKOPF, FUCHS
    }

    protected Person aufspieler;
    protected Map<Person,GespielteKarte> gespielteKarten= new HashMap(4);


    
    protected final int nummer;



    public Stich(int i, Person aufspieler){
        this.aufspieler = aufspieler;
         nummer = i;
    }


    public Person getAufspieler(){
        return aufspieler;
    }

    public GespielteKarte getAufspiel(){
        return getGespielteKarte(aufspieler);
    }

    public GespielteKarte getGespielteKarte(Person p){
        return gespielteKarten.get(p);

    }

    public void putKarte(Karte k,Person p){
        if(p.equals(aufspieler)){
            gespielteKarten.put(p, new GespielteKarte(k,p));
        }else{
            gespielteKarten.put(p, new GespielteKarte(getAufspiel(), k, p));
        }
    }

    public int getPunkte(){
        int wert = 0;
        for(GespielteKarte k : gespielteKarten.values()){
            wert += k.getKarte().getWert().wert;
        }
        return wert;
    }

    public Person getGewinner(){
        GespielteKarte KarteB = getGespielteKarte(aufspieler.next());
        GespielteKarte KarteC = getGespielteKarte(aufspieler.next().next());
        GespielteKarte KarteD = getGespielteKarte(aufspieler.next().next().next());

        GespielteKarte a = GespielteKarte.sticht(KarteB, KarteC);
        return GespielteKarte.sticht(a, KarteD).getPerson();
    }
}
