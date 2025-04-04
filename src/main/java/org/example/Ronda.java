package org.example;

public class Ronda {
    private Jugador jugador;
    private Jugador rival;
    private Mazo mazo;
    private String condicion;


    public Ronda(Jugador jugador, Jugador rival){
        this.jugador = jugador;
        this.rival = rival;
        this.mazo = new Mazo();
        this.condicion = "2 tríos";
    }

    public void iniciar(){
        mazo.crearMazo();
        mazo.barajar();

        for (int i = 0; i < 12; i++){
            jugador.robarCarta(mazo);
            rival.robarCarta(mazo);
        }

        jugador.mostrarMano();
        rival.mostrarMano();
        if (jugador.tieneTrios()) {
            System.out.println("el jugador " + jugador.getNombre() + " tiene dos trios");
        } else {
            System.out.println("el jugador " + jugador.getNombre() + " no tiene dos trios lol");
        }
    }





}
