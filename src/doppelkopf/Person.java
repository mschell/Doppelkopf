/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doppelkopf;

/**
 *
 * @author ms
 */
public enum Person {
    A,B,C,D;

    public Person next(){
        switch(this){
            case A:
                return B;
            case B:
                return C;
            case C:
                return D;
            case D:
                return A;
            default:
                assert false;
                return null;
        }
    }

    public Person closest(Person a, Person b){
        if(this.equals(a)){
            return this;
        }
        if(this.equals(b)){
            return this;
        }
        return this.next().closest(a, b);
    }
}
