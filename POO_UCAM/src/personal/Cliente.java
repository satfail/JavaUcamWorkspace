package personal;

public class Cliente extends Persona{
	
	private int puntos = 4;

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String getDetalle() {
		// TODO Auto-generated method stub
		String cadena = " Puntos: " + puntos; 
		return cadena;
	}
	
	

}
