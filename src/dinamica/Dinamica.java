package dinamica;

import java.util.ArrayList;
import java.util.Hashtable;

public class Dinamica {
  
  private int [][] distancias;
  private int disttotal = 0;
  private Hashtable<String,Integer> tabla = new Hashtable<String,Integer>();
  
  public void setDistancias(int [][] dist){
    distancias = dist;
  }
  
  public int getDistancia(){
    return disttotal;
  }
  
  public void caminoMinimo (){
    ArrayList<Integer> conjunto = new ArrayList<Integer>();
    
    for (int i = 1; i < distancias.length; i++){
      conjunto.add(i);
    }
    disttotal = solve (0, conjunto);
  }
  
  private int solve (int origen, ArrayList<Integer> conjunto){
    ArrayList<Integer> distparc = new ArrayList<Integer>();
    
    int min = 100000;
    if (conjunto.size() == 0){
      return distancias[0][origen];
    }
    if (conjunto.size() == 1){
      ArrayList<Integer> aux = new ArrayList<Integer>(conjunto);
      aux.remove(0);
      if (tabla.containsKey(""+ conjunto.get(0) + aux)){
        return tabla.get(""+ origen + aux) + distancias [conjunto.get(0)][origen];
      }
      else{
        int temp = solve (conjunto.get(0), aux);
        tabla.put(""+ origen + conjunto, temp + distancias [conjunto.get(0)][origen]);
        return temp + distancias [conjunto.get(0)][origen];
      }
    }
    for (int i = 0; i < conjunto.size();  i++){
      ArrayList<Integer> aux = new ArrayList<Integer>(conjunto);
      aux.remove(i);
      int temp = conjunto.get(i);
      if (tabla.containsKey(""+ temp + aux)){
        distparc.add(tabla.get(""+ temp + aux) + distancias [temp][origen]);
      }
      else{ 
        distparc.add(solve (temp, aux) + distancias [temp][origen]);
      }

    }
    for (int i = 0; i < distparc.size(); i++ ){
      if (distparc.get(i) < min){
        min = distparc.get(i);
        
      }
    }
    tabla.put(""+ origen + conjunto, min);
    return min;
  }

}
