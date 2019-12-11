
public class Coordenadas {
	
	private int fila;
	private int columna;
	
	public Coordenadas() {
		fila=-1;
		columna=-1;
	}
	
	public Coordenadas(int f, int c) {
		if(f<0 || c<0) {
			f=-1;
			c=-1;
		}
		fila=f;
		columna=c;
	}
	
	public boolean equals(Object c) {
		boolean ret=false;
		if(c instanceof Coordenadas) {
			if(fila==((Coordenadas) c).getFila() && columna==((Coordenadas) c).getColumna());
		}
		return ret;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	public String toString() {
		String ret="";
		
		ret="("+fila+","+columna+")";
		
		return ret;
	}
}
