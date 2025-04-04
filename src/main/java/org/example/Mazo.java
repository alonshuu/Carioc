package org.example;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private List<Carta> cartas;

    public void crearMazo(){
        cartas = new ArrayList<>();

        String[] pintas = {"Trébol", "Diamante","Corazón","Pica"};
        for (int valor = 1; valor <= 13; valor ++){
            for (String pinta : pintas){
                cartas.add(new Carta(valor, pinta));
            }
        }
        cartas.add(new Carta(0,"Joker"));
        cartas.add(new Carta(0, "Joker"));

    }
    public void barajar(){
        Collections.shuffle(cartas);
    }

    public Carta repartirCarta(){
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }
    public int tamaño() {
        return cartas.size();
    }







}
