package ejercicio4;
import java.util.Scanner;
public class CuentaBancaria {
	private float saldo;

	public CuentaBancaria(float saldo) {
		System.out.println("Cuenta Creada");
		this.saldo = saldo;
	}
	
	public float saldo() {
		return saldo;
	}
	public static double totalSaldo(CuentaBancaria[] cuentas) {
		float sumaSaldos = 0;
		for(CuentaBancaria c : cuentas) {
			sumaSaldos += c.saldo;
		}
		return sumaSaldos;
	}
	public boolean enNumerosRojos(CuentaBancaria cuenta) {
		boolean estado = false;
		
		if(cuenta.saldo < 0) {
			estado = true;
		}
		
		return estado;
		
	}
	
	public void movimiento (double valor) {
		this.saldo += valor;
	}
	
	public static void incCuentas() { //???? No se que puede ser
		
	}
	
	public static void main(String[] args) {
		
		int contador = 0;
		float saldo = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce cuantas cuetas bancarias tienes : ");
		contador = entrada.nextInt();
		CuentaBancaria cuentas[] = new CuentaBancaria[contador];
		
		
		for (int i = 0 ; i < contador; i++) {
			System.out.println("Introduce el saldo de tu "+( i+1) + " cuenta bancaria" );
			saldo = entrada.nextFloat();
			cuentas[i] = new CuentaBancaria(saldo);
		}
		System.out.print("De que cuenta desea operar : " );
		contador = entrada.nextInt() -1;
		System.out.print("Cuanto desea ingresar,( + Ingreso, - Sacar Dinero) : ");
		saldo = entrada.nextInt();
		cuentas[contador].movimiento(saldo);
		
		imprimeInfo(cuentas);
		
	}
	public static void imprimeInfo(CuentaBancaria cuentas[]) {
		
		for(CuentaBancaria c : cuentas) {
			System.out.println("Saldo : " + c.saldo + " Esta en numeros rojos? " + c.enNumerosRojos(c));
		}
		System.out.println("El total de las cuentas es : " + cuentas[0].totalSaldo(cuentas) );
	}
}
