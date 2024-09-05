package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Alan G. Diaz
 **/

public class GeneradorFibonacci {

	/*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** 
	 ** Metodo que devuelve un array con los n numeros pertenecientes a la serie       **
	 **  de Fibonnacci.                                                                **
	 ** @param n define la cantidad de numeros de la serie de Fibonacci a gennerar.    **
	 ** @return Array compuesto por los n numeros de la serie generados.               **
	 *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **/
	public int[] generarFibonacci(int n) {

		int[] serieFibonacci;
		int numeroUno = 0;
		int numeroDos = 1;

		if(n<=0){
			serieFibonacci = new int[0];
		}else{
			serieFibonacci = new int[n];

			for(int i=0; i<n; i++){
				serieFibonacci[i] = numeroUno;

				int proximoNumero = numeroUno+numeroDos;
				numeroUno = numeroDos;
				numeroDos = proximoNumero;
			}
		}

		return serieFibonacci;
	}
	
	public void imprimirFibonacci(int n, String orientacion, String direccion, String modo, String archivo) throws IOException{
		if(modo.equalsIgnoreCase("l")){
			imprimirSerieFibonacci(n, orientacion, direccion, archivo);
		}else{
			imprimirSumaFibonacci(n, orientacion, archivo);
		}
			
	}

	/*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **
	 ** Metodo que genera una serie de Fibonacci de n numeros y la imprime.**
	 *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** 
	 * @throws IOException **/
	public void imprimirSerieFibonacci(int n, String orientacion, String direccion, String archivo) throws IOException{

		int[] serieFibonacci = generarFibonacci(n);

		if(direccion.equalsIgnoreCase("i")){
			serieFibonacci = invertirSerie(serieFibonacci);
		}
		
		StringBuilder output = new StringBuilder();
		output.append("fibo<" + n + ">: ");
		if(orientacion.equals("v")) {
			output.append(System.lineSeparator());
		}
        for(int num : serieFibonacci){
            if(orientacion.equals("v")) {
                output.append(num);
                output.append(System.lineSeparator());
            } else {
                output.append(num);
                output.append(" ");
            }
        }
        
        if(archivo != null){
            try{
            	FileWriter writer = new FileWriter(archivo);
                writer.write(output.toString());
                writer.flush();
                System.out.println("fibo<" + n + "> guardado en " + archivo);
            }catch(Exception e){
            	System.out.println("Error al crear el archivo.");
            }
        } else {
            System.out.println(output.toString());
        }

	}
	
	/*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** *
	 ** Metodo que genera una serie de Fibonacci de n numeros e imprime la suma. *
	 *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** *
	 * @throws IOException **/
	public void imprimirSumaFibonacci(int n, String orientacion, String archivo) throws IOException{

		int[] serieFibonacci = generarFibonacci(n);
		
		int suma = sumarSerie(serieFibonacci);
		
		StringBuilder output = new StringBuilder();
		output.append("fibo<" + n + ">s: ");
		
		if(orientacion.equals("v")) {
			output.append(System.lineSeparator());
		}
		
		output.append(suma);

        if(archivo != null){
            try{
            	FileWriter writer = new FileWriter(archivo);
                writer.write(output.toString());
                writer.flush();
                System.out.println("fibo<" + n + ">s guardado en " + archivo);
            }catch(Exception e){
            	System.out.println("Error al crear el archivo.");
            }
        } else {
            System.out.println(output.toString());
        }

	}

	/*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **
	 ** Metodo que invierte el array (serie) que recibe por parámetro.     **
	 *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **/
	public int[] invertirSerie(int[] serie){
		
		int[] serieInvertida = serie;
		
		for (int i = 0; i < serieInvertida.length/2; i++) {
			int tmp = serieInvertida[i];
			serieInvertida[i] = serieInvertida[serieInvertida.length - 1 - i];
			serieInvertida[serieInvertida.length - 1 - i] = tmp;
		}
		return serieInvertida;
	}
	
	public int sumarSerie(int[] serie){
		int suma = 0;
		
		for (int num : serie) {
			suma += num;
		}
		
		return suma;
		
	}
	
}
