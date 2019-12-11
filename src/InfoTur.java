import java.util.*;

public class InfoTur {
	
	private int museo;
	private int monumento;
	private int hotel;
	private int restaurante;
	private boolean aeropuerto;
	private String top;
	
	public InfoTur() {
		museo=0;
		monumento=0;
		hotel=0;
		restaurante=0;
		aeropuerto=false;
		top="";
	}
	
	public InfoTur(int m, int n, int h, int r, boolean ae) {
		if(m<0) {
			m=0;
		}
		if(n<0) {
			n=0;
		}
		if(h<0) {
			h=0;
		}
		if(r<0) {
			r=0;
		}
		museo=m;
		monumento=n;
		hotel=h;
		restaurante=r;
		aeropuerto=ae;
		top="";
	}
	
	public int numTop() {
		int ret=0;
		char[] nuevoTop=top.toCharArray();
		if(nuevoTop[0]=='*') {
			if(nuevoTop[1]=='*') {
				if(nuevoTop[2]=='*') {
					ret=3;
				}
				else {
					ret=2;
				}
			}
			else {
				ret=1;
			}
		}
		
		return ret;
	}
	
	public ArrayList<Integer> getInfoTur(){
		ArrayList<Integer> ret=new ArrayList<>();
		
		ret.add(museo);
		ret.add(monumento);
		ret.add(hotel);
		ret.add(restaurante);
		if(aeropuerto) {
			ret.add(1);
		}
		else {
			ret.add(0);
		}
		
		return ret;
	}
	
	public String getMasFrecuente() {
		String ret=new String();
		int[] v1=new int[5];
		int[] v2=new int[5];
		
		v1[0]=museo;
		v1[1]=monumento;
		v1[2]=hotel;
		v1[3]=restaurante;
		if(aeropuerto) {
			v1[4]=1;
		}
		else {
			v1[4]=0;
		}
		
		v2[0]=v1[4];
		v2[1]=v1[2];
		v2[2]=v1[1];
		v2[3]=v1[0];
		v2[4]=v1[3];
		
		int pos=0;
		for(int i=0;i<v2.length;i++) {
			if(v2[pos]<v2[i]) {
				pos=i;
			}
		}
		
		switch(pos){
			case 0: ret="aeropuerto";
				break;
			case 1: ret="hotel";
				break;
			case 2: ret="monumento";
				break;
			case 3: ret="museo";
				break;
			case 4: ret="restaurante";
				break;
		}
		
		return ret;
	}
	
	public void setTop(String n) {
		if(n!=null && !(n.equals(""))) {
			top=n;
		}
	}
	
	public String getTop() {
		return top;
	}
	
	public String toString() {
		String ret;
		int num=0;
		if(aeropuerto) {
			num=1;
		}
		
		ret=museo+" "+monumento+" "+hotel+" "+restaurante+" "+num+" "+top+"\n";
		
		return ret;
	}
}
