//Importante el ejemplo de StringTokenizer

package holamundo;

import java.util.StringTokenizer;

public class Manejodestrings {

	public static void main(String[] args) {
		String s = "Esto Es Una Cadena de Caracteres";  ///Posiciones
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(10));
		System.out.println(s.charAt(s.length()-1));
		System.out.println("----------------------");
		char c;
		for(int i = 0 ; i < s.length() ; i++) {
			
			c= s.charAt(i);
			System.out.println(i + " -> " + c);     
		} /// Posicion y caracter 1 a 1 de la cadena
		System.out.println("----------------------");
		String sMayus= s.toUpperCase(); //Todo a May o Min
		String sMin= s.toLowerCase();
		
		System.out.println("Original : "+ s);
		System.out.println("Mayúsculas : "+sMayus);
		System.out.println("Minúsculas : "+sMin);
		
		System.out.println("----------------------");
		int pos1 = s.indexOf('C');
		int pos2 = s.lastIndexOf('C');		// Donde esta la palabra
		int pos3 = s.indexOf('x');
		int pos4 = s.indexOf("Una"); //Tb pilla substrings
		
		System.out.println(pos1);
		System.out.println(pos2);
		System.out.println(pos3);
		System.out.println(pos4);
		System.out.println("----------------------");
		String s1 = s.substring(0 , 7);  // Subcadenas
		String s2 = s.substring(8 , 11);
		String s3 = s.substring(8); ///Pilla a partir del caracter 8
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3); 
		System.out.println("----------------------");
		boolean b1 = s.startsWith("Esto Es"); ///Empieza o acaba por ahi?
		boolean b2 = s.startsWith("Esto es");
		boolean b3 = s.endsWith("de Caracteres");
		boolean b4 = s.endsWith("de caracteres");
		System.out.println(b1 + "|||"+ b2 +"|||"+b3+"|||"+b4 );
		System.out.println("----------------------");
		///Uniendo cadenas sin + , asi es mas eficiente computacionalmente
		String x = new StringBuffer().append("Hola ").append("estoy uniendo").append(" cadenas").append(" de manera eficiente").toString();
		System.out.println(x);
		System.out.println("----------------------");
		///Conversion de tipos no hay representacion
		
		int i = 33 ;
		
		String sInt= Integer.toString(i); // de int a String
		int i2 = Integer.parseInt(sInt);  // viceversa
		
		double d = 6.626070040;
		String sDouble = Double.toString(d);
		double d2 = Double.parseDouble(sDouble);
		System.out.println("----------------------");
		
		String y = "Juan|Marcos|Carlos|Matias";
		StringTokenizer st = new StringTokenizer(y,"|"); ///
		String tok;
		
		while (st.hasMoreTokens()) {
			tok = st.nextToken();
			System.out.println(tok);
			
		}
		System.out.println("----------------------");
		//separarlos con split y llevarlos a un array
		
		String[] arraystring = y.split("[|]");
		for (int k = 0 ; k < arraystring.length ; k++) {
			
			System.out.println(arraystring[k]);
		}
		System.out.println("----------------------");
		//Comparando cadenas
		
		String str1 = "Miguel Angel";
		String str2 = "Miguel Angel";
		
		System.out.println("Cadena 1: " + str1 + "    Cadena 2 : "+ str2 );
		if (str1.equals(str2))  /// NO SE USA ==
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
			
		
		
		
		
	}
	
		
}
