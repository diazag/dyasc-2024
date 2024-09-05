package ar.edu.untref.dyasc;

import java.io.IOException;

/**
 * @author Alan G. Diaz
 **/

public class Ejecutable {
	
    public static void main(String[] args) throws IOException {
    	
    	GeneradorFibonacci fibo = new GeneradorFibonacci();
    	
    	String orientacion = "h";
        String direccion = "d"; 
        String modo = "l";
        String archivo = null;
        int n = 0;
        
    	try {
    		for(String arg : args){
    			if(arg.startsWith("-o=")){
    				String opciones = arg.substring(3);
    				if(opciones.length() != 2 ||
    					(!opciones.contains("h") && !opciones.contains("H") && !opciones.contains("v") && !opciones.contains("V")) ||
    					(!opciones.contains("d") && !opciones.contains("D") && !opciones.contains("i") && !opciones.contains("I"))) {
    					System.out.println("Opci�n no v�lida");
    					return;
    				}
    				orientacion = opciones.substring(0, 1);
    				direccion = opciones.substring(1, 2);
    			}else if(arg.startsWith("-f=")){
    					archivo = arg.substring(3);
    			}else if(arg.startsWith("-m=")){
    				modo = arg.substring(3);
    				if(!modo.equalsIgnoreCase("l") && !modo.equalsIgnoreCase("s")){
    					System.out.println("Opci�n de modo invalida");
    					return;
    				}
    			}else{
    				n = Integer.parseInt(arg);
    			}
    		}
    		
    		if (n <= 0){
        		System.out.println("El n�mero entero debe ser mayor que cero.");
            }else{
            	fibo.imprimirFibonacci(n, orientacion, direccion, modo, archivo);
            }
        	
        }catch(NumberFormatException e){
        	System.out.println("Por favor, debe introducir un n�mero entero v�lido.");
        }
    }
}
