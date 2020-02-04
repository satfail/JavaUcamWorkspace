package ClasesyObjetos;

public class Private_public_get_set {

	private int dia;
	private int mes;
	private int anio;
	
	public Private_public_get_set(int d, int m, int a) {
		dia = d;
		mes = m;
		anio = a;
	} ///En test fecha ahora se podria Private_public_get_set fecha = new Private_public_get_set(2,10,1970)
	
	public Private_public_get_set() {
	}
	public Private_public_get_set(String s) {
		int pos1 = s.indexOf('/');
		int pos2 = s.lastIndexOf('/');
		String sDia = s.substring(0,pos1);
		dia = Integer.parseInt(sDia);
		
		String sMes = s.substring(pos1+1,pos2);
		mes = Integer.parseInt(sMes);
		
		String sAnio = s.substring(pos2+1);
		anio = Integer.parseInt(sAnio);
	}
	public String toString() {
		return dia+"/"+mes+"/"+anio; /// Esta clase hereda de de object que tiene toString y equals que compara objetos
	}
	public boolean equals(Object o) {
		
		Private_public_get_set otra = (Private_public_get_set)o; ///El objeto que voy a comparar es de la misma clase, el de esta puede confundir
		return (dia==otra.dia) && (mes==otra.mes) && (anio==otra.anio); //True si es igual
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia; //this tb puede ser usado como referencia a la clase , la variable privada dia es igual a la que se pasa por ref.
	}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public int fechaToDias() {
		
		return anio*360+mes*30+dia;
	}
	
	private void diasToFecha(int i) {
		
		anio = (int) i/360;
		int resto = i % 360;
		mes = (int) resto/30;
		int restoMes = resto % 30;
		dia = restoMes;
		
		if (dia == 0) {
			
			dia = 30;
			mes--;
		}
		
		if (mes == 0) {
			mes = 12;
			anio--;
			
		}
		
	}
	
	public void addDias(int d) {
		
		int sum = fechaToDias()+d;
		diasToFecha(sum);
	}
	
	
}

