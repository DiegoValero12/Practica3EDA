import java.util.*;
import java.io.*;

public class Coleccion {

	private ArrayList<ArrayList<Character>> mapa;
	private ArrayList<Localidad> localidades;
	
	public Coleccion() {
		mapa=new ArrayList<>();
		localidades=new ArrayList<>();
	}
	
	public void lectura(String n) {
		FileReader in=null;
		BufferedReader lec=null;
		int mu=0, mo=0, ho=0, re=0;
		boolean ae=false;
		String top=new String("");
		try {
			in=new FileReader(n); // indica que empiece a leer el fichero que se le pasa
			lec=new BufferedReader(in);	// lee por lineas el fichero
			String linea=lec.readLine(); // lee la primera linea
			while(!(linea.equals("<LOCALIDAD>"))) { // el bucle se ejecuta mientras que lo que lea sea distinto de localidad
				char[] cad=linea.toCharArray(); // convertimos el string en un array de caracteres
				ArrayList<Character> linea_mapa=new ArrayList<>(); // creamos el arraylist de cada una de las filas
				for(int i=0;i<cad.length;i++) {
					linea_mapa.add(cad[i]); // metemos en el arraylist los caracteres
				}
				mapa.add(linea_mapa); // agregamos al mapa general la linea que acabamos de leer
				linea=lec.readLine(); // leemos la siguiente linea
			}
			
			// ahora ya hemos leido y guardado el mapa
			while(linea!=null) {
				Localidad loc;				
				linea=lec.readLine();// leemos el nombre de la localidad
				loc=new Localidad(linea); // creamos el objeto localidad con el nombre				
				linea=lec.readLine(); // leemos las coordenadas de la localidad
				String[] coor_string=linea.split(" ");// guardamos las coordenadas en un string
				int fila=Integer.parseInt(coor_string[0]); // pasamos el string a int en ambas posiciones
				int columna=Integer.parseInt(coor_string[1]);								
				loc.setCoor(fila, columna, mapa); // ponemos la coordenada a la localidad				
				linea=lec.readLine(); // leer el <INFO				
				linea=lec.readLine(); //leo la primera informacion de infotur				
				while(linea!=null && !(linea.equals("<LOCALIDAD>"))) {					
					String[] separar_info=linea.split(" "); // separo por clase de dato y cantidad											
					switch(separar_info[0]) {
						case "museo": mu=Integer.parseInt(separar_info[1]); // si es museo asigno a mu y asi los de abajo
							break;
						case "monumento": mo=Integer.parseInt(separar_info[1]);
							break;
						case "hotel": ho=Integer.parseInt(separar_info[1]);
							break;
						case "restaurante": re=Integer.parseInt(separar_info[1]);
							break;
						case "aeropuerto": ae=true;
							break;
						default: for(int i=0;i<separar_info.length;i++) { // tengo que concatenar las cadenas
									if(i!=0)
										top=top+" "+separar_info[i];
									else
										top=top+separar_info[i];
								}
							break;
					}					
					linea=lec.readLine(); // leo la siguiente linea
				}				
				InfoTur info=new InfoTur(mu, mo, ho, re, ae); // creo el objeto infotur
				info.setTop(top); // pongo el top en el objeto
				loc.setInfo(info); // pongo el infotur en la localidad
				if(getCoorMapa(loc.getCoor())=='L') {
					localidades.add(loc); // anyado la localidad al arraylist de localidades
				}
				mu=0;
				mo=0;
				ho=0;
				re=0;
				ae=false;
				top="";													
			}
			
		}
		catch(Exception e){
			
		}
		finally {
			try {
				if(in!=null) {
					in.close();
				}
			}
			catch(IOException e) {
				
			}
		}
	}
	
	public ArrayList<ArrayList<Character>> getMapa(){
		return mapa;
	}
	
	public ArrayList<Localidad> getLocalidades(){
		return localidades;
	}
	
	public char getCoorMapa(Coordenadas coor) {
		char ret='X';
		
		if(coor!=null) {
			if(coor.getFila()>-1 && coor.getFila()<mapa.size() && coor.getColumna()>-1 && coor.getColumna()<mapa.get(0).size()) {
				ret=mapa.get(coor.getFila()).get(coor.getColumna());
			}
		}
		
		return ret;
	}
	
	public String toString() {
		String ret="";
		
		for(int i=0;i<mapa.size();i++) {
			for(int j=0;j<mapa.get(i).size();j++) {
				ret=ret+Character.toString(mapa.get(i).get(j));
			}
			ret=ret+"\n";
		}
		
		for(int i=0;i<localidades.size();i++) {
			ret=ret+localidades.get(i);
		}
		
		return ret;
	}
}
