/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doppelkopf;

/**
 *
 * @author ms
 */
public class Karte implements Comparable<Karte>{


    public enum Farbe {

        Kreuz, Pik, Herz, Karo
    }

    public enum Wert {

        Ass(11),
        Zehn(10),
        Koenig(4),
        Dame(3),
        Bube(2);

        public final int wert;

        Wert(int wert) {
            this.wert = wert;
        }

        public static boolean sticht(Wert a, Wert b){
            return (a.wert >= b.wert);

        }
    }


    public enum Trumpf{

        Dulle(Farbe.Herz,Wert.Zehn),
        ReDame(Farbe.Kreuz,Wert.Dame),
        PikDame(Farbe.Pik,Wert.Dame),
        HerzDame(Farbe.Herz,Wert.Dame),
        KaroDame(Farbe.Karo,Wert.Dame),
        Charly(Farbe.Kreuz,Wert.Bube),
        PikBube(Farbe.Pik,Wert.Bube),
        HerzBube(Farbe.Herz,Wert.Bube),
        KaroBube(Farbe.Karo,Wert.Bube),
        Fuchs(Farbe.Karo,Wert.Ass),
        KaroZehn(Farbe.Karo,Wert.Zehn),
        KaroKoenig(Farbe.Karo,Wert.Koenig);


        public final Farbe farbe;
        public final Wert wert;

        Trumpf(Farbe f, Wert w){
            farbe = f;
            wert = w;
        }

        public static boolean sticht( Trumpf a, Trumpf b ){

            if(a.equals(b)){
                if(a.equals(Dulle)){
                    return false;
                }else{
                    return true;
                }
            }

            if(a.ordinal() < b.ordinal()){
                return true;
            }else{
                return false;
            }
        }

        public static Trumpf getTrumpf(final Karte k){
            for(Trumpf t : values()){
                if(k.is(t.farbe,t.wert)){
                    return t;
                }
            }
            return null;
        }
    }


    protected final Farbe farbe;
    protected final Wert wert;
    protected final Trumpf trumpf;
    protected boolean gespielt;

    public Karte(Farbe f, Wert w) {
        this.farbe = f;
        this.wert = w;
        trumpf = Trumpf.getTrumpf(this);
    }

   
    public final boolean isTrumpf() {
        return trumpf != null;
    }

    public Trumpf getTrumpf(){
        return trumpf;
    }


    public Farbe getFarbe(){
        return farbe;
    }

    public Wert getWert(){
        return wert;
    }

    public final boolean is(Farbe f){
        return farbe.equals(f);
    }

    public final boolean is(Wert w){
        return wert.equals(w);
    }

    public final boolean is(Farbe f, Wert w){
        return  is(f) && is(w);
    }

    public final boolean is(Karte k){
        return is(k.farbe,k.wert);
    }

    public boolean isGespielt(){
        return gespielt;
    }


    @Override
    public String toString() {
        return "{" + farbe + " " + wert + "}";
    }

    public static boolean sticht(Karte a, Karte b ){
        if(a.isTrumpf()){
            if(b.isTrumpf()){
                return Trumpf.sticht(a.getTrumpf(), b.getTrumpf());
            }else{
                return true;
            }
        }else{
            if(b.isTrumpf()){
                return false;
            }else{
                return Wert.sticht(a.getWert(),b.getWert());
            }
       }
    }


    public int ordinal(){
        if(isTrumpf()){
            return getTrumpf().ordinal();
        }else{
            int t = Trumpf.KaroKoenig.ordinal();
            int f = farbe.ordinal() * 100;
            int w = wert.ordinal() * 1000;

            return t+f+w;
        }
    }

    // sortiere nach Trumpf: Dulle->KaroKønig + Fehl Kreuz,Pik,Herz
    public int compareTo(Karte o) {       
        return this.ordinal()-o.ordinal();
    }



}
