package main;

import java.util.Random;

import clock.Clock;
import dinamica.Dinamica;
import fbruta.FBruta;
import greede.Greede;
import tsp.TSP;

public class Main {

  public static void main(String[] args) {
    System.out.println("Greede , , , Fbruta , , , Dinámica");
    System.out.println("Distancia , Tiempo , Camino , Distancia , Tiempo , Camino , Distancia , Tiempo , Camino");
    for (int i = 18; i < 25; i++){
      for (int r = 0; r < 1; r++){
        Clock timer = new Clock();
        Random aleatorio = new Random ();
        int [][] grafo = new int [i][i];
        for (int j = 0; j<i; j++){
          for (int k = j; k < i; k++){
            if ( k != j){
              int valor = aleatorio.nextInt(100); 
              grafo [j][k] = valor;
              grafo [k][j] = valor;
            }
            else {
              grafo [k][j] = 0;
            }
          }
        }

        Greede voraz = new Greede();
        FBruta bruta = new FBruta();
        Dinamica dinamica = new Dinamica();
        dinamica.setDistancias(grafo);


        timer.start();
        voraz.caminominimo(grafo);
        timer.stop();
        long tgreede = timer.elapsedTime();
        timer.start();
        bruta.run(grafo);
        timer.stop();
        long tbruta = timer.elapsedTime();
        timer.start();
        dinamica.caminoMinimo();
        timer.stop();
        long tdinamica = timer.elapsedTime();
        System.out.println("" + i + " , " + voraz.getDistancia() + " , " + tgreede + " , " + voraz.getCamino() + " , " + bruta.getDistancia() + " , " + tbruta + " , " + bruta.getCamino()  + " , " + dinamica.getDistancia() + " , " + tdinamica + " , " + "no hay");



      }

    }
  }
}
