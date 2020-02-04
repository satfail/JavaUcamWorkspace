package Ejercicio2;

public class cuatroD extends tresD {
	
	private double k;

	public cuatroD() {
		super();
		this.k = 0;
	}

	public cuatroD(float x, float y, float z,float k) {
		super(x, y, z);
		this.k = k;
	}

	public double getK() {
		return k;
	}
	
	public String toString() {
		
		return super.toString() + " k = " + k;
	}
	

	public  double distanciaEuclidea() {
		
		return Math.sqrt(Math.pow(getX(), 2)+Math.pow(getY(), 2) +Math.pow(getZ(), 2) + +Math.pow(k, 2));
	}
}
