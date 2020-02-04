package Interface;

public class  MusicoEstudiante implements Musico , Estudiante {
	
	
	@Override
	public void hablar() {
		System.out.println("Estoy hablando");
	}
	@Override
	public void tocarMusica() {
		
		System.out.println("Tocando la guitarra");
	}
	
	@Override
	public void estudiar() {
		
		System.out.println("Estoy estudiando Java");
	}
	
	public static void main(String[] args) {
		
		
		MusicoEstudiante me  = new MusicoEstudiante();
	
		me.estudiar();
		me.tocarMusica();
		me.hablar();
	}

}
