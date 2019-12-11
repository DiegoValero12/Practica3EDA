import java.util.*;

public class pruebasVarias {

	public static void main(String[] args) {
		String s="11111111"; // 0 0 0 1 0 0    1 1 1 1 0 0    0 0 0 1 0 0
		

		char[] c=s.toCharArray();
		char uno=c[0];
		boolean encontrado=false;
		for(int i=c.length-1;i>=0;i--) {
			
			if(!encontrado) {
				
				if(c[i]=='1') {
					
					encontrado=true;
				}
			}
			else {

				if(c[i]=='1') {
					c[i]='0';
				}
				else {
					c[i]='1';
				}
			}
		}
		
		//c[0]='0';
		String nueva="";
		for(int i=0;i<c.length;i++) {
			nueva=nueva+c[i];
		}
		System.out.println("Cadena 1: "+nueva);
		int ret=Integer.parseInt(nueva, 2);
		if(uno=='1') {
			ret=ret*(-1);
		}
		String s2="11111110";

		char[] c2=s2.toCharArray();
		char uno2=c2[0];
		boolean encontrado2=false;
		for(int i=c2.length-1;i>=0;i--) {
			
			if(!encontrado2) {
				
				if(c2[i]=='1') {
					
					encontrado2=true;
				}
			}
			else {

				if(c2[i]=='1') {
					c2[i]='0';
				}
				else {
					c2[i]='1';
				}
			}
		}
		//c2[0]='0';
		String nueva2="";
		for(int i=0;i<c2.length;i++) {
			nueva2=nueva2+c2[i];
		}
		System.out.println("Cadena 2: "+nueva2);
		int ret2=Integer.parseInt(nueva2, 2);
		if(uno2=='1') {
			ret2=ret2*(-1);
		}
		System.out.println("Primer numero: "+ret);
		System.out.println("Segundo numero: "+ret2);
		
		int suma=ret+ret2;
		System.out.println("Resultado de la suma: "+suma);
        if(suma>=-128 && suma<=127){
            String resultado=Integer.toBinaryString(Math.abs(suma));
            ArrayList<Character> vect=new ArrayList<>();
            char[] cadena=resultado.toCharArray();
            for(int i=0;i<cadena.length;i++){
                vect.add(cadena[i]);
            }
            while(vect.size()<8){
                vect.add(0, '0');
            }
            String ser="";
            if(suma>=0) {	
            	for(int i=0;i<vect.size();i++){
            		ser=ser+vect.get(i);
            	}
            }
            else {
            	//vect.set(0, '1');
            	boolean fin=false;
            	for(int i=vect.size()-1;i>=0;i--) {
	    			
	    			if(!fin) {
	    				
	    				if(vect.get(i)=='1') {
	    					fin=true;
	    				}
	    			}
	    			else {
	    				if(vect.get(i)=='1') {
	    					vect.set(i, '0');
	    				}
	    				else {
	    					vect.set(i, '1');
	    				}
	    			}
            	}
            	for(int i=0;i<vect.size();i++){
                    ser=ser+vect.get(i);
                }
            }
      
            
            System.out.println("Cadena de antes: "+ser);
            
            
            System.out.println("Final: "+ser);
        }


		
	}

}
