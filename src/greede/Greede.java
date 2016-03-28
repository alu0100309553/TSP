package greede;

import java.util.ArrayList;

public class Greede {
  private ArrayList <Integer> camino = new ArrayList <Integer>();
  private int actual = 0;
  private int distancia = 0;
  private final int INFINITO = 100000000;
  public void caminominimo (int [][] distancias){
    int masCercano = 0;
    int costeMasCercano = INFINITO;
    camino.add(0);
    for (int i = 0; i < distancias.length-1; i++){
      costeMasCercano = INFINITO;
      for (int j = 0; j < distancias [actual].length ; j++){
        if (distancias [actual][j] < costeMasCercano && !camino.contains(j)){
          masCercano = j;
          costeMasCercano = distancias [actual][j]; 
        }
      }
      distancia += costeMasCercano;
      camino.add(masCercano);
      actual = masCercano;
    }
    distancia += distancias [actual][0];
    camino.add(0);
  }
  
  public int getDistancia () {
   return distancia; 
  }
  
  public String getCamino () {
    String aux = "";
    for (int i = 0; i < camino.size()-1; i++){
      aux += camino.get(i) + "-->"; 
    }
    aux += camino.get(camino.size()-1);
    return aux;
  }

}
