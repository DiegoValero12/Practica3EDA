import java.util.*;

public class Localidad {
	
	private String nombre;
	private Coordenadas coor;
	private InfoTur info;
	private int id;
	
	public Localidad(String n) {
		nombre=n;
		coor=new Coordenadas();
		info=new InfoTur();
		id=-1;
	}
	
	public int setCoor(int f, int c, ArrayList<ArrayList<Character>> mapa) {
		int ret=-1;
		
		if(coor.getFila()==-1 && coor.getColumna()==-1 && f>-1 && f<mapa.size() && c>-1 && c<mapa.get(0).size()) {
			if(mapa.get(f).get(c).equals('T')) { 
				coor=new Coordenadas(f,c);
				mapa.get(f).set(c, 'L');
				id=mapa.get(0).size()*f+c;
				ret=id;
			}
		}
		
		return ret;
	}

	public InfoTur getInfo() {
		return info;
	}

	public void setInfo(InfoTur info) {
		this.info = info;
	}

	public String getNombre() {
		return nombre;
	}

	public Coordenadas getCoor() {
		return coor;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		id=i;
	}
	
	public void setCoordenadas(int f, int c) {
		coor=new Coordenadas(f,c);
	}
	
	public String toString() {
		String ret="";
		
		ret=id+"-"+nombre+"-"+coor+"\n"+info;
		
		return ret;
	}
}
