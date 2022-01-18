import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecuenciaBytes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Parte 1: Crear el archivo
		String origen = "D:\\OneDrive - frp.utn.edu.ar\\JAVA_workspace\\LaboratorioIII_Persistencia\\src\\ArchivoPrueba.txt";
		String destino = "D:\\OneDrive - frp.utn.edu.ar\\JAVA_workspace\\LaboratorioIII_Persistencia\\src\\ArchivoPruebaCOPIA.txt";

		try {
			File archivo = new File(destino);

			if (!archivo.exists()) { // Si el archivo no existe es creado

				archivo.createNewFile();
				System.out
						.println("se creó el archivo: " + archivo.getName() + " en dir: " + archivo.getAbsolutePath());
			} else {
				System.out.println(
						"ya EXISTE el archivo: " + archivo.getName() + " en dir: " + archivo.getAbsolutePath());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Parte 2: Creo los flujos de conexión con los archivos

		File FInput = new File(origen); // Objeto File con origen.
		File FOutput = new File(destino); // Objeto File con origen.

		BufferedInputStream lecturaBuff;// Creo un objeto buffer flujo de lectura .
		BufferedOutputStream escrituraBuff;// Creo un objeto buffer flujo de escritura.

		try {
			// Inicializa el buffer de lectura:
			lecturaBuff = new BufferedInputStream(new FileInputStream(FInput));
			// Inicializa el buffer de escritura:
			escrituraBuff = new BufferedOutputStream(new FileOutputStream(FOutput));
			int bytes;// Variable que contiene lectura de origen
			while ((bytes = lecturaBuff.read()) != -1) { // Mientras no llegue a fin de archivo.
				escrituraBuff.write(bytes); // Escribo el byte leido en el destino.
			}
			// Cerramos las conexiones:
			lecturaBuff.close();// Cerramos el lector.
			escrituraBuff.close();// Cerramos el escritor.
		} catch (FileNotFoundException e) {
			e.printStackTrace();// Traza de excepcion
		} catch (IOException e) {
			e.printStackTrace();// Traza de excepcion
		}
	}
}
