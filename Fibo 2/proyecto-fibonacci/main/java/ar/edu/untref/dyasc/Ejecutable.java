package ar.edu.untref.dyasc;

/**
 * @author Alan G. Diaz
 **/

public class Ejecutable {
	
    public static void main(String[] args) {
    	
    	GeneradorFibonacci fibo = new GeneradorFibonacci();
    	
    	String orientacion = "h";
        String direccion = "d"; 
        int n = 0;
        
    	try {
    		for(String arg : args){
    			if(arg.startsWith("-o=")){
    				String opciones = arg.substring(3);
    				if(opciones.length() != 2 ||
    					(!opciones.contains("h") && !opciones.contains("H") && !opciones.contains("v") && !opciones.contains("V")) ||
    					(!opciones.contains("d") && !opciones.contains("D") && !opciones.contains("i") && !opciones.contains("I"))) {
    					System.out.println("Opción no válida");
    					return;
    				}
    				orientacion = opciones.substring(0, 1);
    				direccion = opciones.substring(1, 2);
    			}else{
    				n = Integer.parseInt(arg);
    			}
    		}
    		
    		if (n <= 0){
        		System.out.println("El número entero debe ser mayor que cero.");
            }else{
            	fibo.imprimirFibonacci(n, orientacion, direccion);
            }
        	
        }catch(NumberFormatException e){
        	System.out.println("Por favor, debe introducir un número entero válido.");
        }
    }
}
