package turijanmonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Browser {
	FileReader FileRead;
	BufferedReader objReader;
	List<String> list;
	static RandomAccessFile raf;
	String ruta;
	
	public Browser(){
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
		int countlineas = 0;
		int num;
		String aux = "476I";
		try {
			String linea;
			while ( (linea = objReader.readLine()) != null ) {	
				
		/*		if(objReader.readLine().length() < 72) {
					System.out.println("sali");
					break;
				}*/
				
				if(linea.substring(9, 13).equals(aux)) {
					System.out.println("linea :"+countlineas+" bytebuffer " + contadorbuffer);
					lista(contadorbuffer-74);
					break;
				}
				countlineas++;
				contadorbuffer = contadorbuffer + 74;
			}
			}catch (IOException e) {
				e.printStackTrace();
			}
	//	System.out.println("****************"+contadorbuffer+"-"+aux+" "+countlineas );
	}
	
	public ArrayList lista(int contador) {
		int valor = 1;
		String linea2 ;
		try {
			System.out.println("-----"+contador);
//			raf.seek(160);
//			System.out.println(raf.readLine());
//			raf.seek(161);
//			System.out.println(raf.readLine());
//			raf.seek(137270);
//			System.out.println(raf.readLine());
			
			raf.seek(contador);
			while((valor < 15) && (raf.readLine() != null)) {				
				System.out.println(raf.readLine());
				valor++;
			}
			System.out.println("-----");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public void closeFiles() {
		try {
			FileRead.close();
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
