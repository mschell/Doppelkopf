/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

import doppelkopf.regeln.Bedienen;
import doppelkopf.regeln.Rule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ms
 */
public class Spieler {
    private final Person person;
    private final Partei partei;  // Hochzeit nicht unterstüzt
    private final Karten kartenAufDerHand;

    private List<Stich> stiche;


    public Spieler(Person p, Karten hand){
        this.person = p;
        this.kartenAufDerHand = hand;

        if(kartenAufDerHand.contains(Karte.Farbe.Kreuz, Karte.Wert.Dame)){
            partei = Partei.Re;
        }else{
            partei = Partei.Kontra;
        }
        stiche = new ArrayList<Stich>();
    }

    public Karte legeKarte(Stich s){

        if(s.getAufspieler() == person){
            Karte k =kartenAufDerHand.iterator().next();
            kartenAufDerHand.remove(k);
            return k;
        }



        Rule r = new Bedienen();
                
        Set<Karte> karten = r.apply(s.getAufspiel().getKarte());

        Set<Karte> bedienbareKarten = kartenAufDerHand.intersection(karten);

        if(!bedienbareKarten.isEmpty()){
            Karte k = bedienbareKarten.iterator().next();
            kartenAufDerHand.remove(k);
            return k;
        }else{
            Karte k = kartenAufDerHand.iterator().next();
            kartenAufDerHand.remove(k);
            return k;
        }
        
    }


    public void addStich(Stich s){
        stiche.add(s);
    }

    public int getPunkte(){
        int punkte = 0;
        for(Stich s : stiche){
            punkte += s.getPunkte();
        }
        return punkte;
    }

    public Partei getPartei(){
        return partei;
    }

    @Override
    public String toString() {
        return "Spieler{" + person + '}';
    }

    public String toBigString(){
       return toString() + '{' + kartenAufDerHand.toString() + '}';
    }

}
