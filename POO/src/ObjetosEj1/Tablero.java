package ObjetosEj1;
import java.util.Scanner;
public class Tablero {

	private int x, y;
	
	public Tablero(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public void moverArriba( int incremento) {
		
		y += incremento;
	}
	
	public void moverAbajo( int incremento) {
		
		y -= incremento;
	}
	
	public void moverDerecha( int incremento) {
		
		x += incremento;
	}
	
	public void moverIzquierda( int incremento) {
		
		x -= incremento;
	}
	
	public int getX() {
		
		return x;
	}
	
	public int geY() {
		return y;
	}
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Tablero t = new Tablero(0,0);
		int flag = 0;
		int incremento = 0;
		System.out.println("Empezamos en el origen x = 0 , y = 0");
		
		do {
			
			System.out.println("1 Mover hacia arriba");
			System.out.println("2 Mover hacia abajo");
			System.out.println("3 Mover hacia derecha");
			System.out.println("4 Mover hacia izquierda");
			System.out.println("5 salir");
			System.out.print("Introduzca la opcion : ");
			flag = entrada.nextInt();
			System.out.println("Nos encontramos en x = " + t.getX() + " y = " + t.geY() );
			
			if( flag != 5) {
				System.out.println("Cuantos espacios quieres mover");
				incremento = entrada.nextInt();	
			}
			
			switch (flag) {
			
			case 1: t.moverArriba(incremento);
					break;
			case 2: t.moverAbajo(incremento);
			break;
			case 3: t.moverDerecha(incremento);
			break;
			case 4: t.moverIzquierda(incremento);
			break;
			default:
				System.out.println("Opcion incorrecta");
			}
			
			}while(flag != 5);
	}
}
