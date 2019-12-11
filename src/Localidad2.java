
public class Localidad2 extends Localidad implements Comparable<Localidad2>{
	
	private int vertice;
	
	public Localidad2(Localidad l) {
		super(l.getNombre());
		this.setInfo(l.getInfo());
		this.setId(l.getId());
		this.setCoordenadas(l.getCoor().getFila(), l.getCoor().getColumna());
		vertice=-1;
	}
	
	public int getVertice() {
		return vertice;
	}
	
	public void setVertice(int v) {
		vertice=v;
	}
	
	public int compareTo(Localidad2 l) {
		if(l!=null){
			int comparacionNombre=this.getNombre().compareTo(l.getNombre());
		
			if(comparacionNombre<0) {
				return -1;
			}
			else {
				if(comparacionNombre>0) {
					return 1;
				}
				else {
					if(this.getId()<l.getId()) {
						return -1;
					}
					else {
						if(this.getId()>l.getId()) {
							return 1;
						}
						else {
							return 0;
						}
					}
				}
			}
		}
		else{
			return -2;
		}
		
	}
	
	public boolean equals(Object l) {
		boolean ret=false;
		if(l instanceof Localidad) {
			if(this.compareTo((Localidad2 )l)==0) {
				ret=true;
			}
		}
		return ret;
	}
}
