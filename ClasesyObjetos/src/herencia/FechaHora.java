package herencia;

public class FechaHora extends FechaDetallada {
	
	private int hora;
	private int min;
	private int seg;
	
	
	public FechaHora (String sFecha , int hora , int min , int seg) {
		
		super(sFecha); //Me lleva al metodo string de FechaDetallada y este me manda a su padre Public.. que separa el string
		this.hora  = hora;
		this.min = min;
		this.seg = seg;
		
	}
	
	public String toString() {
		
		return super.toString() + " Hora ( " + hora + ":" + min + ":" + seg +" )" ;
		//Llamamos el metodo to toString del padre (FechaDetallada)
	}

}
