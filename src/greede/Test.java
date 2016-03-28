package greede;

public class Test {

  public static void main(String[] args) {
    Greede problema = new Greede();
    int [][] aux = {{0, 1, 15, 6},{2, 0, 7, 3},{9, 6, 0, 12},{10, 4, 8, 0}};
    problema.caminominimo(aux);
    System.out.println(problema.getDistancia());
    System.out.println(problema.getCamino());

  }

}
