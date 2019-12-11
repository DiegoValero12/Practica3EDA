
public class pruebaTNear {

	public static void main(String[] args) {
		Coleccion c=new Coleccion();
		c.lectura(args[0]);
	
		TNear t=new TNear(1000);
		
		t.insertaLocalidades(c);
		System.out.println(t);
		t.setDn(0);
		System.out.println(t);

	}

}
