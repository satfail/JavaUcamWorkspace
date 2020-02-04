package Ejercicio2;
import java.lang.Math;

public class dosD {
	
	private float x;
	private float y;
	
	public dosD(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public dosD() {
		this.x = 0;
		this.y = 0;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public double distanciaEuclidea() { //sqrt( (x2-x1)^2 + (y2 -y1)^2) 	  x1 = y1 = 0 ; respecto al origen
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	public String toString() {
		
		return "x = " + x + " y = " + y;
	}

}
