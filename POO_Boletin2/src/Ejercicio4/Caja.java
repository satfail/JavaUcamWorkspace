package Ejercicio4;

public class Caja extends Number {

	double valor;
	
	
	@Override
	public int intValue() {
		return (int)valor;
	}

	@Override
	public long longValue() {
		return (long)valor;
	}

	@Override
	public float floatValue() {
		return (float)valor;
	}

	@Override
	public double doubleValue() {
		return valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	


}
