package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        mazo.crearMazo();
        mazo.barajar();

        Jugador jugador1 = new Jugador("Alonso");

        for (int i = 0; i < 12; i++){
            jugador1.robarCarta(mazo);
        }

        jugador1.mostrarMano();


    }
}