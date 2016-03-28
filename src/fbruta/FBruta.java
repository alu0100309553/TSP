package fbruta;

import java.util.ArrayList;

public class FBruta {
  private final int INFINITO = 1000000;
  private int mindist = INFINITO;
  private int[][] distancias;
  private ArrayList <Integer> caminoMejor = new ArrayList <Integer> ();
  private final int NODOINICIAL = 0;
  
  public void run (int [][] distancias){
    this.distancias = distancias;
    ArrayList<Integer> noVisitados = new ArrayList<Integer>();
    for (int i = 1; i < distancias.length; i++){
      noVisitados.add(i);
    }
    buscarcamino (noVisitados, 0, NODOINICIAL, new ArrayList<Integer>());
  }
  
  private void buscarcamino (ArrayList<Integer> noVisitados, int distancia, int ultimoNodo, ArrayList<Integer> camino){
    if (noVisitados.size()==0){
      camino.add(ultimoNodo);
      distancia += distancias [ultimoNodo][NODOINICIAL];
      camino.add(NODOINICIAL);
      if (distancia < mindist){
        mindist = distancia;
        caminoMejor = camino;
      }

    }else{
      for (int i = 0; i < noVisitados.size(); i++){
        Integer ndistancia = new Integer(distancia + distancias [ultimoNodo][noVisitados.get(i)]);
        ArrayList<Integer> ncamino = new ArrayList<Integer>(camino);
        ncamino.add(ultimoNodo);
        Integer nultimoNodo = new Integer(noVisitados.get(i));
        ArrayList<Integer> nnoVisitados = new ArrayList<Integer>(noVisitados);
        nnoVisitados.remove(i);
        if(ndistancia <= mindist){
          buscarcamino (nnoVisitados, ndistancia, nultimoNodo,ncamino);
          }
      }
    }

  }
  
  public int getDistancia () {
    return mindist; 
   }
   
   public String getCamino () {
     String aux = "";
     for (int i = 0; i < caminoMejor.size()-1; i++){
       aux += caminoMejor.get(i) + "-->"; 
     }
     aux += caminoMejor.get(caminoMejor.size()-1);
     return aux;
   }

}
