package org.example;


// primer metodo del programa
public class Carta {
     // creada la clase Carta, en este caso defini sus valores principales que tendra, el valor en si de la carta y su String.

    private int valor;
    private String pinta;

    // devuelve el valor de la carta

    public String toString() {
        return valor + " de " + pinta;
    }

    // constructor de una carta
    public Carta(int valor, String pinta){
        this.valor = valor;
        this.pinta = pinta;
    }


    public int getValor(){
        return this.valor;
    }

    public String getPinta(){
        return this.pinta;
    }

    public boolean esIgual(Carta otra){
        return this.valor == otra.valor && this.pinta.equals(otra.pinta);
    }


}
