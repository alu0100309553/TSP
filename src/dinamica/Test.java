package dinamica;

import grafo.Grafo;

public class Test {

  public static void main(String[] args) {
    Grafo migrafo = new Grafo("tsp1.txt");
    //NDinamica prueba = new NDinamica();
    Dinamica prueba = new Dinamica();
    int [][] aux =  {{0, 9, 15, 6},{2, 0, 7, 3},{9, 6, 0, 12},{10, 4, 8, 0}};
    prueba.setDistancias(migrafo.getDistancias());
    prueba.caminoMinimo();
    System.out.println(prueba.getDistancia());
    //System.out.println(prueba.caminoTotal);
  }

}
