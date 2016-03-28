package grafo;

public class Test {

	public static void main(String[] args) {
		Grafo migrafo = new Grafo("tsp1.txt");
		System.out.println(migrafo.getDistancias());
	}

}
