package turijanmonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Browser {
	Messege ElMsg;
	FileReader FileRead;
	BufferedReader objReader;
	List<String> list;
	static RandomAccessFile raf;
	String ruta;
	
	public Browser(){
		ElMsg = new Messege();
		ruta = "C:\\Users\\turijana\\Downloads\\GAMA\\GAMA_190527_001_1612\\GAMA_190527_001_1612.dat_m";
		try {
			FileRead = new FileReader (ruta);
			objReader = new BufferedReader (FileRead);
			raf = new RandomAccessFile(ruta,"r");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void leerArchivo(int posInicial, int posFinal) {
		int contadorbuffer = 0;
		int Tamlinea = 74;
		int countlineas = 0;
		int num;
		String aux = "476I";
		try {
			String linea = null;
			while ( (linea = objReader.readLine()) != null ) {
				if(linea.contains(aux)) {
					System.out.println("linea :"+countlineas+" bytebuffer " + contadorbuffer +" x :"+linea.substring(9, 13).length());
					lista(contadorbuffer);
					System.out.println("aux :"+aux+" linea: "+linea +" subs :"+linea.substring(9,13));
				}
				countlineas++;
				contadorbuffer += Tamlinea;
			}
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public ArrayList lista(int contador) {
		int valor = 1;
		try {
			String readLine =" ";
			System.out.println("-----"+contador);
			raf.seek(contador);
			while((valor < 10) && (readLine != null)) {				
				System.out.println(readLine = raf.readLine());
				valor++;
			}
			System.out.println("-----");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeFiles() {
		try {
			FileRead.close();
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
