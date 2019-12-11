/*
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class main {

	public static void main(String[] args) {
		
		/*
		int n=4;
		ArrayList<ArrayList<Integer>> gr = new ArrayList<ArrayList<Integer>>();	;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<n;i++) {
			a.add(0);	
		}
		for(int i=0; i<n;i++) {
			gr.add(a);
		}
		System.out.println(gr.get(0));
		System.out.println(gr);
		
		
		Localidad loc = new Localidad("Barcelona");
		Localidad loc2 = new Localidad("Madrid");
		
		Localidad2 l = new Localidad2(loc);
		Localidad2 l2 = new Localidad2(loc2);
		
		System.out.println("Compare 1: "+l.compareTo(l2));
		System.out.println("Vertice de Barcelona: "+l.getVertice());
		System.out.println("Vertice de Madrid: "+l2.getVertice());
		
		Coleccion c = new Coleccion();
		c.lectura(args[0]);
		
		GrafLoc g = new GrafLoc(4);
		System.out.println(g);
		
		System.out.println("\nINSERTO LOCALIDADES");
		TreeSet<Localidad2> t = g.insertaLocalidades(c);
		System.out.println("ARBOL: \n"+t+"\n");
		System.out.println("GRAFO: "+g);
		
		Iterator<Localidad2> it = t.iterator();
		while(it.hasNext()) {
			
			Localidad2 aux = it.next();
			System.out.println(aux + " "+ "Vertice: "+aux.getVertice());
		}
		
	}
}
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class main {

	public static void main(String[] args) {
		
		/*
		int n=4;
		ArrayList<ArrayList<Integer>> gr = new ArrayList<ArrayList<Integer>>();	;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<n;i++) {
			a.add(0);	
		}
		for(int i=0; i<n;i++) {
			gr.add(a);
		}
		System.out.println(gr.get(0));
		System.out.println(gr);
		*/
		
		Localidad loc = new Localidad("Barcelona");
		Localidad loc2 = new Localidad("Madrid");
		
		Localidad2 l = new Localidad2(loc);
		Localidad2 l2 = new Localidad2(loc2);
		
		System.out.println("Compare 1: "+l.compareTo(l2));
		System.out.println("Vertice de Barcelona: "+l.getVertice());
		System.out.println("Vertice de Madrid: "+l2.getVertice());
		
		Coleccion c = new Coleccion();
		c.lectura(args[0]);
		
		GrafLoc g = new GrafLoc(4);
		System.out.println(g);
		
		
		System.out.println("\nINSERTO LOCALIDADES");
		TreeSet<Localidad2> t = g.insertaLocalidades(c);
		System.out.println("ARBOL: \n"+t+"\n");
		System.out.println("GRAFO: "+g);
		g.escribeDFS(0);
		/*
		Iterator<Localidad2> it = t.iterator();
		while(it.hasNext()) {
			
			Localidad2 aux = it.next();
			System.out.println(aux + " "+ "Vertice: "+aux.getVertice());
		}
		
		*/
		System.out.println("-----------------------");
		GrafLoc gra = new GrafLoc(8);
		System.out.println(gra);
		System.out.println("Inserto arista: "+gra.insertaArista(0, 1, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(0, 2, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(0, 3, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(1, 2, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(1, 4, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(1, 5, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(2, 5, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(3, 6, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(3, 7, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(4, 5, 3));
		System.out.println("Inserto arista: "+gra.insertaArista(6, 7, 3));
		System.out.println(gra);
		gra.escribeDFS(0);
		
		
		
		
	}
}