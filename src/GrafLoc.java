import java.util.*;

public class GrafLoc {
	private ArrayList<ArrayList<Integer>> gr;
	private ArrayList<Integer> marcados;
	
	public GrafLoc(int n) {
		gr=new ArrayList<ArrayList<Integer>>();
		marcados=new ArrayList<>();
		for(int i=0;i<n;i++) {
			ArrayList<Integer> lineaGraf=new ArrayList<>();
			for(int j=0;j<n;j++) {
				lineaGraf.add(Integer.MAX_VALUE);
			}
			gr.add(lineaGraf);
			//lineaGraf.clear();
		}
	}
	
	public boolean esVacio() {
		for(int i=0;i<gr.size();i++) {
			for(int j=0;j<gr.get(0).size();j++) {
				if(gr.get(i).get(j)!=Integer.MAX_VALUE) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean insertaArista(int o1, int o2, int p) {
		boolean ret=false;
		
		if(o1>=0 && o2>=0 && o1<gr.size() && o2<gr.get(0).size()) {
			if(gr.get(o1).get(o2)==p) {
				return false;
			}
			else {
				if(gr.get(o2).get(o1)==p) {
					return false;
				}
				else {
					gr.get(o1).set(o2, p);
					gr.get(o2).set(o1, p);
					ret=true;
				}
			}
		}
		
		/*
		for(int i=0;i<gr.size();i++) {
			for(int j=0;j<gr.get(0).size();j++) {
				if(((i==o1 && j==o2) || (i==o2 && j==o1)) && gr.get(i).get(j)!=p) {
					gr.get(i).set(j, p);
					ret=true;
				}
			}
		}
		*/
		return ret;
	}
	
	public int recuperaArista(int o1, int o2) {
		int ret=-1;
		
		if(o1>=0 && o2>=0 && o1<gr.size() && o2<gr.get(0).size()) {
			ret=gr.get(o1).get(o2);
		}
		
		return ret;
	}
	
	public boolean borraArista(int o1, int o2) {
		boolean ret=false;
		
		if(o1>=0 && o2>=0 && o1<gr.size() && o2<gr.get(0).size() && gr.get(o1).get(o2)!=Integer.MAX_VALUE && gr.get(o2).get(o1)!=Integer.MAX_VALUE) {
			gr.get(o1).set(o2, Integer.MAX_VALUE);
			gr.get(o2).set(o1, Integer.MAX_VALUE);
			ret=true;
		}
		
		return ret;
	}
	
	public boolean borraVertice(int o1) {
		boolean ret=false;
		
		for(int i=0;i<gr.size();i++) {
			for(int j=0;j<gr.get(0).size();j++) {
				if((i==o1 || j==o1) && gr.get(i).get(j)!=Integer.MAX_VALUE) {
					gr.get(i).set(j, Integer.MAX_VALUE);
					ret=true;
				}
			}
		}
		
		return ret;
	}
	
	public int getVertices() {
		return gr.size();
	}
	
	public TreeSet<Localidad2> insertaLocalidades(Coleccion c){
		TreeSet<Localidad2> ret=new TreeSet<>();
		

		
		if(!esVacio()) {
			for(int i=0;i<gr.size();i++) {
				for(int j=0;j<gr.size();j++) {
					gr.get(i).set(j, Integer.MAX_VALUE);
				}
			}
		}
		
		for(int i=0;i<c.getLocalidades().size();i++) {
			Localidad2 loc2=new Localidad2(c.getLocalidades().get(i));
			ret.add(loc2);
		}
		
		int cont=0;
		Iterator<Localidad2> it=ret.iterator();
		while(it.hasNext()) {
			Localidad2 aux=it.next();
			aux.setVertice(cont);
			cont++;
		}
		
		if(gr.size()!=cont) {
			gr.clear();
			for(int i=0;i<cont;i++) {
				ArrayList<Integer> lineaGraf=new ArrayList<>();
				for(int j=0;j<cont;j++) {
					lineaGraf.add(Integer.MAX_VALUE);
				}
				gr.add(lineaGraf);
			}
		}
		
		Iterator<Localidad2> it1=ret.iterator();
		while(it1.hasNext()) {
			Localidad2 aux1=it1.next();
			Iterator<Localidad2> it2=ret.iterator();
			while(it2.hasNext()) {
				Localidad2 aux2=it2.next();
				//gr.get(aux1.getVertice()).set(aux2.getVertice(), calculaDistancia(aux1, aux2));
				gr.get(aux1.getVertice()).set(aux2.getVertice(), calculaDistancia(aux1, aux2));
			}	
		}
		
		return ret;
	}
	
	public static int calculaDistancia(Localidad2 l1, Localidad2 l2) {
		return (Math.abs(l1.getCoor().getFila()-l2.getCoor().getFila())+Math.abs(l1.getCoor().getColumna()-l2.getCoor().getColumna()));
	}
	
	public int calculaAristas() {
		int ret=0;
		for(int i=0;i<gr.size();i++) {
			for(int j=0;j<gr.get(0).size();j++) {
				if(i!=j && gr.get(i).get(j)!=Integer.MAX_VALUE) {
					ret++;
				}
			}
		}
		return ret/2;
	}
	
	public String muestraMatriz() {
		String ret ="";
		
		for(int i=0; i<gr.size();i++) {
			for(int j=0; j<gr.size();j++) {
				if(j!=gr.get(i).size()-1) {
					ret=ret+gr.get(i).get(j)+" ";
				}
				else {
					ret=ret+gr.get(i).get(j)+"\n";
				}
			}

		}
		return ret;
	}
	
	public String toString() {
		String ret="vertices: "+gr.size()+"\n";
		
		ret=ret+"aristas: "+calculaAristas()+"\n";
		ret=ret+muestraMatriz();
		
		return ret;
	}
	
	public void recursiva(int i) {
		if(!marcados.contains(i)) {
			marcados.add(i);
		}
		boolean encontrado=false;
		for(int j=0;j<gr.size();j++) {
			if(gr.get(i).get(j)!=Integer.MAX_VALUE && gr.get(i).get(j)!=0 && !marcados.contains(j)) {	
				encontrado=true;
				recursiva(j);
				//j=0;
			}
		}
	}
	
	public void escribeDFS(int i) {
		if(i<gr.size() && i>=0) {
			recursiva(i);
			for(int j=0;j<gr.size();j++) {
				if(!marcados.contains(j)) {
					recursiva(j);
				}
			}
		}
		String s="";
		for(int j=0;j<marcados.size();j++) {
			if(j!=marcados.size()-1) {
				s=s+marcados.get(j)+", ";
			}
			else {
				s=s+marcados.get(j);
			}
		}
		if(s==""){
			System.out.print(s);
		}
		else{
			System.out.println(s);
		}
		
		marcados.clear();
	}
	
	
}
