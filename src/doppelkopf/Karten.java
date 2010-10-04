/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

import doppelkopf.Karte.Farbe;
import doppelkopf.Karte.Wert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ms
 */
public class Karten extends HashSet<Karte>{

    

    public Karten(Set<Karte> karten){
        super(karten);
    }




    public boolean contains(Farbe f){
        for(Karte k : this){
           if(k.is(f)){
               return true;
           }
        }
        return false;
    }

    public boolean contains(Wert w){
        for(Karte k : this){
           if(k.is(w)){
               return true;
           }
        }
        return false;
    }

    public boolean contains(Farbe f, Wert w){
        for(Karte k : this){
           if(k.is(f,w)){
               return true;
           }
        }
        return false;
    }

  public Set<Karte> union(Set<Karte> setB) {
    Set<Karte> tmp = new TreeSet<Karte>(this);
    tmp.addAll(setB);
    return tmp;
  }

  public Set<Karte> intersection(Set<Karte> setB) {
    Set<Karte> tmp = new TreeSet<Karte>();
    for (Karte x : this)
      if (setB.contains(x))
        tmp.add(x);
    return tmp;
  }

  public Set<Karte> difference(Set<Karte> setB) {
    Set<Karte> tmp = new TreeSet<Karte>(setB);
    tmp.removeAll(setB);
    return tmp;
  }

  public boolean isSubset(Set<Karte> setB) {
    return setB.containsAll(this);
  }

  public boolean isSuperset(Set<Karte> setB) {
    return this.containsAll(setB);
  }

    @Override
    public String toString() {
        String s="";
        List<Karte> list = new ArrayList(this);
        Collections.sort(list);
        for(Karte k : list){
            s += k.toString();
        }
        return s;
    }




}
