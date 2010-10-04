/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

import doppelkopf.Karte.Trumpf;
import doppelkopf.Karte.Wert;

/**
 *
 * @author ms
 */
public class GespielteKarte {

    protected final GespielteKarte  aufspiel;
    protected final Karte  karte;
    protected final Person person;


    public GespielteKarte(Karte karte, Person spieler) {
        this.aufspiel = this;
        this.karte = karte;
        this.person = spieler;
    }

    public GespielteKarte(GespielteKarte aufspiel, Karte karte, Person spieler) {
        this.aufspiel = aufspiel;
        this.karte = karte;
        this.person = spieler;
    }

    public Karte getKarte() {
        return karte;
    }

    public Person getPerson() {
        return person;
    }

    public boolean bedient(){
        if(aufspiel.getKarte().isTrumpf() && this.getKarte().isTrumpf()){
            return true;
        }
        if(aufspiel.getKarte().getFarbe().equals(this.getKarte().getFarbe())){
            return true;
        }
        return false;
    }

    public boolean getrumpft(){
        if(!aufspiel.getKarte().isTrumpf() && this.getKarte().isTrumpf()){
            return true;
        }
        return false;
    }


    public boolean stichtAufspiel() {
        if(getrumpft()){
            return true;
        }
        if(!bedient()){
            return false;
        }

        return !Karte.sticht(aufspiel.karte,karte);
    }



    public static GespielteKarte sticht(GespielteKarte a, GespielteKarte b ){
        assert(a.aufspiel == b.aufspiel);


        Person first = a.aufspiel.getPerson().closest(a.getPerson(), b.getPerson());

        if(first == b.getPerson()){
            GespielteKarte tmp = a;
            a = b;
            b = tmp;
        }

        if(a.stichtAufspiel()){
            if(b.stichtAufspiel()){
               if(Karte.sticht(a.getKarte(), b.getKarte())){
                   return a;
               }else{
                   return b;
               }  
           } else {
               return a;
           }
        }else{
           if(b.stichtAufspiel()){
               return b;
           } else {
               return a.aufspiel;
           }
        }
    }
}
