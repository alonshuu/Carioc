package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ronda {
    private Jugador jugador;
    private Jugador rival;
    private Mazo mazo;
    private String condicion;
    private List<Carta> pozo;


    public Ronda(Jugador jugador, Jugador rival){
        this.pozo = new ArrayList<>();
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

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            turnoJugador();

            List<List<Carta>> triosjugador = jugador.buscarTrios();

            if (triosjugador.size() == 2){
                System.out.println("Te has bajado con dos trios!");
                juegoTerminado = true;
                break;
            }

            boolean Rivalsebajo = turnoRival();

            if (Rivalsebajo) {
                System.out.println("El rival se ha bado");
                juegoTerminado = true;
                break;
            }


        }

    }

    // metodos del pozo

    public void mostrarPozo() {
        if (pozo.isEmpty()){
            System.out.println("El pozo esta vacío");
        } else {
            System.out.println("Carta en el pozo: "+ pozo.get(pozo.size() -1));
        }
    }


    public void botarCarta(Carta carta) {
        pozo.add(carta);
    }




    public void turnoJugador() {
        Scanner scanner = new Scanner(System.in);
        jugador.mostrarMano();
        mostrarPozo();

        System.out.println("¿De donde quieres sacar cartas");
        System.out.println("1: Del mazo");
        System.out.println("2: Del pozo");

        int opcion = scanner.nextInt();
        Carta cartaRobada;

        if (opcion == 2 & !pozo.isEmpty()){
            cartaRobada = pozo.remove(pozo.size()-1);
        } else {
            System.out.println("El pozo esta vacío, sacarás del mazo");
            cartaRobada = mazo.repartirCarta();
        }

        System.out.println("Robaste : " + cartaRobada);
        jugador.recibirCarta(cartaRobada);

        System.out.println("\n Tu mano actual");
        jugador.mostrarMano();

        System.out.println("¿Qué carta quieres botar? (Ingresa el índice de 0 a " + (jugador.getMano().size() -1) + ")");

        int IndiceAbotar = scanner.nextInt();

        Carta cartaBotada = jugador.getMano().remove(IndiceAbotar);

        pozo.add(cartaBotada);

        System.out.println("Botaste: "+ cartaBotada);

    }


    public boolean turnoRival() {
        System.out.println("Turno de " + rival.getNombre());

        Carta cartaRobada = mazo.repartirCarta();

        if (cartaRobada != null){
            rival.recibirCarta(cartaRobada);
            System.out.println(rival.getNombre() + "Robó una carta");
        }

        Random rand = new Random();

        int IndiceAbotar = rand.nextInt(rival.getMano().size());

        Carta cartaBotada = rival.getMano().remove(IndiceAbotar);
        pozo.add(cartaBotada);

        System.out.println(rival.getNombre() + " botó: " + cartaBotada);


        List<List<Carta>> trios = rival.buscarTrios();

        if (trios.size() == 2) {
            System.out.println(rival.getNombre() + "tiene dos trios, se bajará con");
            for (List<Carta> trio : trios ) {
                System.out.println("TRIO: ");
                for (Carta c : trio){
                    System.out.println(" -" + c);
                }
            }
            return true;
        }

        return false;


    }



}
