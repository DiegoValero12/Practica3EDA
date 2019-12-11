import java.util.*;

public class TNear {
	TreeMap<Localidad2, TreeSet<Localidad2>> ti=new TreeMap<>();
	int dn;
	
	public TNear(int i) {
		if(i<0) {
			i=0;
		}
		dn=i;
	}
	
	public boolean esVacio() {
		return ti.isEmpty();
	}
	
	public void insertaLocalidad2(Localidad2 l) {
		//ti.put(key, value);
		TreeSet<Localidad2> arbol=new TreeSet<>();
		for(Localidad2 obj:ti.keySet()) {
			if(GrafLoc.calculaDistancia(l, obj)<=dn) {
				arbol.add(obj);
			}
		}
		boolean repetido=false;
		for(Localidad2 rec:ti.keySet()) {
			if(l.equals(rec)){
				repetido=true;
			}
		}
		if(!repetido) {
			ti.put(l, arbol);
			for(Localidad2 it:ti.keySet()) {
				if(GrafLoc.calculaDistancia(it, l)<=dn && !l.equals(it)) {
					ti.get(it).add(l);
				}
			}
		}
	}
	
	public void insertaLocalidades(Coleccion c) {
		for(int i=0;i<c.getLocalidades().size();i++) {
			Localidad2 aux=new Localidad2(c.getLocalidades().get(i));
			this.insertaLocalidad2(aux);
		}
	}
	
	
	
	public boolean borraLocalidad(String s) {
		boolean ret=false;
		
		ArrayList<Localidad2> aBorrarClave=new ArrayList<>();
		for(Localidad2 it:ti.keySet()) {
			if(it.getNombre()==s) {
				aBorrarClave.add(it);
				ret=true;
			}
			else {
				ArrayList<Localidad2> aBorrarValor=new ArrayList<>();
				Iterator<Localidad2> recorre=ti.get(it).iterator();
				while(recorre.hasNext()) {
					Localidad2 aux=recorre.next();
					if(aux.getNombre()==s) {
						aBorrarValor.add(aux);
					}
				}
				for(int cont=0;cont<aBorrarValor.size();cont++) {
					ti.get(it).remove(aBorrarValor.get(cont));
				}
			}
		}
		for(int cont=0;cont<aBorrarClave.size();cont++) {
			ti.remove(aBorrarClave.get(cont));
		}
		
		return ret;
	}
	
	public TreeSet<Localidad2> getLocalidades(String s){
		TreeSet<Localidad2> ret=null;
		
		for(Localidad2 it:ti.keySet()) {
			if(it.getNombre()==s) {
				return ti.get(it);
			}
		}
		
		return ret;
	}
	
	public void setDn(int i) {
		if(i<0) {
			i=0;
		}
		dn=i;
		for(Localidad2 it:ti.keySet()) {
			ArrayList<Localidad2> aBorrar=new ArrayList<>();
			Iterator<Localidad2> iter=ti.get(it).iterator();
			while(iter.hasNext()) {
				Localidad2 aux=iter.next();
				if(GrafLoc.calculaDistancia(aux, it)>dn) {
					aBorrar.add(aux);
				}
			}
			for(int cont=0;cont<aBorrar.size();cont++) {
				ti.get(it).remove(aBorrar.get(cont));
			}
		}
	}
	
	public TreeSet<Localidad2> getTop(int i){
		TreeSet<Localidad2> ret=null;
		
		for(Localidad2 it:ti.keySet()) {
			if(it.getInfo().numTop()==i) {
				if(ret==null) {
					ret=new TreeSet<>();
				}
				ret.add(it);
			}
		}
		
		return ret;
	}
	
	public String toString() {
		String s="";
		
		for(Localidad2 it:ti.keySet()) {
			ArrayList<String> aux=new ArrayList<>();
			aux.add(it.getNombre());
			Iterator<Localidad2> iter=ti.get(it).iterator();
			while(iter.hasNext()) {
				Localidad2 loc=iter.next();
				aux.add(loc.getNombre());
			}
			for(int i=0;i<aux.size();i++) {
				if(i==0) {
					if(i==aux.size()-1) {
						s=s+aux.get(i)+" * \n";
					}
					else {
						s=s+aux.get(i)+" *";
					}
				}
				else {
					if(i==aux.size()-1) {
						s=s+" "+aux.get(i)+"\n";
					}
					else {
						s=s+" "+aux.get(i)+" -";
					}
				}
			}
		}
		
		return s;
	}
}
