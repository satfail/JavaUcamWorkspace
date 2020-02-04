package Ejercicio2;

public class tresD extends dosD {
	
	private float z;

	public tresD() {
		super();
		 z = 0;
	}

	public tresD(float x, float y, float z) {
		super(x, y);
		this.z = z;
	}

	public float getZ() {
		return z;
	}
	
	public String toString() {
		
		return super.toString() + " z = " + z;
	}
	
	public  double distanciaEuclidea() {
		
		return Math.sqrt(Math.pow(getX(), 2)+Math.pow(getY(), 2) +Math.pow(z, 2));
	}
	
	
	

}
