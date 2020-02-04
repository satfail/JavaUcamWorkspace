package ClienteServidor;

import java.net.InetAddress;

public class MensajeDatagrama {
	
	private String mensaje;
	private InetAddress direccionEmisor;
	private int puertoEmisor;
	
	public void fijaValor(String mensaje, InetAddress dir, int puerto) {
		
		this.mensaje = mensaje;
		this.direccionEmisor = dir;
		this.puertoEmisor = puerto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public InetAddress getDireccionEmisor() {
		return direccionEmisor;
	}

	public void setDireccionEmisor(InetAddress direccionEmisor) {
		this.direccionEmisor = direccionEmisor;
	}

	public int getPuertoEmisor() {
		return puertoEmisor;
	}

	public void setPuertoEmisor(int puertoEmisor) {
		this.puertoEmisor = puertoEmisor;
	}
	
	

}
