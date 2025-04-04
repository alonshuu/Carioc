package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private List<Carta> mano;
    private String nombre;




    // constructor de clase jugador
    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }


    // metodo para sacar cartas, llama a la clase mazo y repartircarta, en este caso este entrega una carta aleatoria y en el caso de que esta carta
    // no se trate de un null ( caso que ocurriría si fue sacada antess) se añade al mazo del jugador


    public void robarCarta(Mazo mazo){
        Carta cartaRobada = mazo.repartirCarta();
        if (cartaRobada != null){
            mano.add(cartaRobada);
        }
    }

    // metodo mostrar mano, facilmente muestra los atributos y la carta, en este caso es
    //facil de implementar ya que nosotros ya añadimos un metodo para la representacion en String de la carta

    public void mostrarMano() {
        System.out.println("Mano de " + nombre + ":");
        for (Carta carta : mano){
            System.out.println(" - " + carta);
        }
    }




}
