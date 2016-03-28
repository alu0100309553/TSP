package fbruta;

import grafo.Grafo;

public class Test {

  public static void main(String[] args) {
    FBruta problema = new FBruta();
    Grafo migrafo = new Grafo("tsp1.txt");
    int [][] aux = {{0, 1, 15, 6},{2, 0, 7, 3},{9, 6, 0, 12},{10, 4, 8, 0}};
    problema.run(migrafo.getDistancias());
    System.out.println(problema.getDistancia());
    System.out.println(problema.getCamino());
  }

}
