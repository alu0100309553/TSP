package tsp;

import grafo.Grafo;

public class Test {

  public static void main(String args[]) {

      TSP ht = new TSP();
      Grafo migrafo = new Grafo("tsp1.txt");

      ht.caminoMinimo(migrafo.getDistancias());
      System.out.println(ht.getCamino());
      System.out.println(ht.getDistancia());
      
  }


}
