package ConBytes;
//Lee y escribe sin StreamReader Sin comentar con capa Buffered
// Comentado usando array copia y pega
import java.io.*;


public class StreamBytes {
	
	public static void main(String[] args) throws IOException {
		int contador =0;
		int[] datosentrada = new int[74176];
		try {
			FileInputStream archivoLectura = new FileInputStream("FotoFactura2.jpeg");
			
			//Creo la capa buffered para guardar
			BufferedInputStream bis = new BufferedInputStream(archivoLectura);
			boolean finalArchivo = false;
			byte [] misbytes = new byte[74176];
			bis.read(misbytes, 0, misbytes.length);
			///Capa buffered para enviar lo hago directo pasando FileOut por parametro
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Factura3.jpeg"));
			bos.write(misbytes, 0, misbytes.length);
			System.out.println(misbytes.length);

/*
			while(!finalArchivo) {
				int  byteEntrada = archivoLectura.read();
				if(byteEntrada !=-1) {
					datosentrada[contador] = byteEntrada;
				}
				else {
					finalArchivo = true;
				}
				System.out.println(datosentrada[contador]);
				contador++;
			}
		archivoLectura.close();
		
		*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(contador);
		///Ahora guardamos el archivo
		//creaFichero(datosentrada);

		
	}
	
	static void creaFichero(int datos[]) {
		try {
			FileOutputStream newFile = new FileOutputStream("copiaFactura.jpeg");
			
			for (int i = 0; i < datos.length; i++) {
				newFile.write(datos[i]);
			}
		newFile.close();
		
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
