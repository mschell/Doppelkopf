/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static doppelkopf.Karte.*;
/**
 *
 * @author ms
 */
public class DoppelKopfBlatt {
    protected static final Set<Karte> karten;
    protected static final Map<Farbe,Set<Karte>>  farbKarten;
    protected static final Set<Karte> trumpfKarten;

    static{
        Set<Karte> tmpKarten = new HashSet<Karte>(40);
        for(Farbe f : Farbe.values()){
            for(Wert w : Wert.values()){
                tmpKarten.add(new Karte(f,w));
                tmpKarten.add(new Karte(f,w));
            }
        }
        karten = Collections.unmodifiableSet(tmpKarten);
        farbKarten = new HashMap<Farbe,Set<Karte>>();
        trumpfKarten = new HashSet<Karte>();

        for(Farbe f: Farbe.values()){
            HashSet<Karte> tmpKarten1 = new HashSet();
            for(Karte k : karten){
                if(k.is(f)){
                    tmpKarten1.add(k);
                }
                if(k.isTrumpf()){
                    trumpfKarten.add(k);
                }
            }
            farbKarten.put(f, tmpKarten1);
        }
    }

    public static Set<Karte> getKarten(){
        return karten;
    }

    public static Set<Karte> getFarbe(Farbe f){
        return Collections.unmodifiableSet(farbKarten.get(f));
    }

    public static Set<Karte> getTrumpf(){
        return Collections.unmodifiableSet(trumpfKarten);
    }

    private List<Karte> mischeKarten(){
        List<Karte> gemischteKarten = new ArrayList<Karte>(karten);
        Collections.shuffle(gemischteKarten);
        return gemischteKarten;
    }

    public Map<Person,Spieler> geben(){
        Map<Person,Spieler> spieler = new HashMap();

        List<Karte> gemischteKarten = mischeKarten();

        System.out.println("size" + gemischteKarten.size());

        Set<Karte> sp1 = new HashSet<Karte>(gemischteKarten.subList(0, 10));
        Set<Karte> sp2 = new HashSet<Karte>(gemischteKarten.subList(10, 20));
        Set<Karte> sp3 = new HashSet<Karte>(gemischteKarten.subList(20, 30));
        Set<Karte> sp4 = new HashSet<Karte>(gemischteKarten.subList(30, 40));

        spieler.put(Person.A, new Spieler(Person.A, new Karten(sp1)));
        spieler.put(Person.B, new Spieler(Person.B, new Karten(sp2)));
        spieler.put(Person.C, new Spieler(Person.C, new Karten(sp3)));
        spieler.put(Person.D, new Spieler(Person.D, new Karten(sp4)));
        
        return spieler;

    }
}
