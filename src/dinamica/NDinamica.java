package dinamica;

import java.util.ArrayList;

public class NDinamica {

    
    private int [][] distancias;
    public int disttotal = 0;
    public ArrayList<Integer> caminoTotal = new ArrayList<Integer>();
    
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
      disttotal = solve (0, conjunto).valor;
    }
    
    public Pairs solve (int origen, ArrayList<Integer> conjunto){
      ArrayList<Integer> distparc = new ArrayList<Integer>();
      ArrayList<Integer> distparcnodo = new ArrayList<Integer>();
      Pairs auxnode = new Pairs();
      auxnode.valor = 10000;
      int min = 100000;
      if (conjunto.size() == 0){
        auxnode.valor = distancias[0][origen];
        auxnode.pareja = 0;
        return auxnode;
      }
      if (conjunto.size() == 1){
        ArrayList<Integer> aux = new ArrayList<Integer>(conjunto);
        aux.remove(0);
        auxnode = solve (conjunto.get(0), aux);
        auxnode.valor += distancias [conjunto.get(0)][origen];
        return auxnode;
      }
      for (int i = 0; i < conjunto.size();  i++){
        ArrayList<Integer> aux = new ArrayList<Integer>(conjunto);
        aux.remove(i);
        int temp = conjunto.get(i);
        distparc.add(solve(temp, aux).valor+distancias[temp][origen]);
        distparcnodo.add(temp);
      }
      for (int i = 0; i < distparc.size(); i++ ){
        if (distparc.get(i) < auxnode.valor){
          auxnode.valor = distparc.get(i);
          auxnode.pareja = distparcnodo.get(i);
        }
      }
      caminoTotal.add(auxnode.pareja);
      return auxnode;
    }

  }



