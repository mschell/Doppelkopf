/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ms
 */
public class DoppelKopfSpiel {

    private DoppelKopfBlatt blatt = new DoppelKopfBlatt();

    private Map<Person, Spieler> spieler;  // Geber


    private static Logger logger = Logger.getLogger("Doko");

    public DoppelKopfSpiel(){
       this.spieler = blatt.geben();
    }


    public void spiel(){


        Person aufspiel = Person.A;

        for(Person p : Person.values()){
            System.out.println(spieler.get(p).toBigString());
        }


        for(int i=0; i < 10; i++){
            System.out.println("====================================");
            Stich stich = new Stich(i,aufspiel);

            Person p = stich.getAufspieler();

            legeKarte(stich,p);
            p = p.next();
            legeKarte(stich,p);
            p = p.next();
            legeKarte(stich,p);
            p = p.next();
            legeKarte(stich,p);
            

            Person gewinner = stich.getGewinner();
            spieler.get(gewinner).addStich(stich);
            aufspiel = gewinner;
        }
         System.out.println("====================================");
        for(Person p : spieler.keySet()){
            Spieler s = spieler.get(p);
            System.out.println(s + "{" + s.getPartei() + "}:" + s.getPunkte());
        }

    }



    private void legeKarte(Stich stich, Person p){
        Karte k = spieler.get(p).legeKarte(stich);
        stich.putKarte(k,p);
        System.out.println(spieler.get(p) + "> " + k );
    }
}
