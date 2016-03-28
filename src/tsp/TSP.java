package tsp;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class TSP {

  private static final int INFINITO = 100000000;
  private Deque<Integer> camino = new LinkedList<>();
  private int distanciatotal = 0;
//Clase interna privada para generar el índice de la tabla en función de el nodo destino y el conjunto.
  private static class Indice {
      int actual;
      Set<Integer> conjunto;

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          Indice indice = (Indice) o;

          if (actual != indice.actual) return false;
          return !(conjunto != null ? !conjunto.equals(indice.conjunto) : indice.conjunto != null);
      }

      @Override
      public int hashCode() {
          int aux = actual;
          aux = 31 * aux + (conjunto != null ? conjunto.hashCode() : 0);
          return aux;
      }
      
      private static Indice creaIndice(int nodo, Set<Integer> conjunto) {
          Indice i = new Indice();
          i.actual = nodo;
          i.conjunto = conjunto;
          return i;
      }
  }

  private static class ComparadorConjuntos implements Comparator<Set<Integer>>{
      @Override
      public int compare(Set<Integer> o1, Set<Integer> o2) {
          if(o1.size() <= o2.size()) {
              return -1;
          } else {
              return 1;
          }
      }
  }

  public void caminoMinimo(int[][] distancia) {

      //Map para guardar los costes parciales
      Map<Indice, Integer> tablaMinCost = new HashMap<>();
      //Map para guardar los nodos previos para recuperar la ruta
      Map<Indice, Integer> previos = new HashMap<>();
      //Lista de los posibles subconjuntos
      List<Set<Integer>> conjuntos = generarConjuntos(distancia.length - 1);

      for(Set<Integer> set : conjuntos) {
          for(int actual = 1; actual < distancia.length; actual++) {
              if(set.contains(actual)) {
                  continue;
              }
              Indice indice = Indice.creaIndice(actual, set);
              int minimoCoste = INFINITO;
              int minnodoPrev = 0;
              Set<Integer> copiaSet = new HashSet<>(set);
              for(int nodoPrev : set) {
                  int cost = distancia[nodoPrev][actual] + getCoste(copiaSet, nodoPrev, tablaMinCost);
                  if(cost < minimoCoste) {
                      minimoCoste = cost;
                      minnodoPrev = nodoPrev;
                  }
              }
              if(set.size() == 0) {
                  minimoCoste = distancia[0][actual];
              }
              tablaMinCost.put(indice, minimoCoste);
              previos.put(indice, minnodoPrev);
          }
      }

      Set<Integer> set = new HashSet<>();
      for(int i=1; i < distancia.length; i++) {
          set.add(i);
      }
      int min = Integer.MAX_VALUE;
      int nodoPrev = -1;
      Set<Integer> copiaSet = new HashSet<>(set);
      for(int k : set) {
          int cost = distancia[k][0] + getCoste(copiaSet, k, tablaMinCost);
          if(cost < min) {
              min = cost;
              nodoPrev = k;
          }
      }

      previos.put(Indice.creaIndice(0, set), nodoPrev);
      guadarCamino(previos, distancia.length);
      distanciatotal = min;
  }
//Método que recupera el camino y lo guarda en una pila
  private void guadarCamino(Map<Indice, Integer> previos, int totalVertices) {
      Set<Integer> set = new HashSet<>();
      for(int i=0; i < totalVertices; i++) {
          set.add(i);
      }
      Integer inicio = 0;
      while(true) {
          camino.push(inicio);
          set.remove(inicio);
          inicio = previos.get(Indice.creaIndice(inicio, set));
          if(inicio == null) {
              break;
          }
      }
  }
  //Método que convierte el camino en un String para ser impreso
  public String getCamino(){
    String aux = "";
    while(camino.size()>1){
      aux += camino.pop() + "-->";
    }
    aux += camino.pop();
    return aux;
  }
  //Métodr que devuelve la distancia total calculada
  public int getDistancia(){
    return distanciatotal;
  }

  private int getCoste(Set<Integer> set, int nodoPrev, Map<Indice, Integer> tablaMinCost) {
      set.remove(nodoPrev);
      Indice indice = Indice.creaIndice(nodoPrev, set);
      int cost = tablaMinCost.get(indice);
      set.add(nodoPrev);
      return cost;
  }

  private List<Set<Integer>> generarConjuntos(int n) {
      int entrada[] = new int[n];
      for(int i = 0; i < entrada.length; i++) {
          entrada[i] = i+1;
      }
      List<Set<Integer>> conjuntos = new ArrayList<>();
      int resultado[] = new int[entrada.length];
      generarConjuntos(entrada, 0, 0, conjuntos, resultado);
      Collections.sort(conjuntos, new ComparadorConjuntos());
      return conjuntos;
  }

  private void generarConjuntos(int entrada[], int inicio, int pos, List<Set<Integer>> conjuntos, int resultado[]) {
      if(pos == entrada.length) {
          return;
      }
      Set<Integer> set = creaSet(resultado, pos);
      conjuntos.add(set);
      for(int i=inicio; i < entrada.length; i++) {
          resultado[pos] = entrada[i];
          generarConjuntos(entrada, i+1, pos+1, conjuntos, resultado);
      }
  }

  private static Set<Integer> creaSet(int entrada[], int pos) {
      if(pos == 0) {
          return new HashSet<>();
      }
      Set<Integer> set = new HashSet<>();
      for(int i = 0; i < pos; i++) {
          set.add(entrada[i]);
      }
      return set;
  }
}