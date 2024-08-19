package ar.edu.untref.dyasc;

public class Ejecutable {
	
    public static void main(String[] args) {
    	
    	GeneradorFibonacci fibo = new GeneradorFibonacci();
    	
    	if(args.length != 1){
    		System.out.println("Se debe introducir un n�mero entero como argumento.");
    		return;
    	}
    	
        try {
        	int n = Integer.parseInt(args[0]);
        	
        	if (n <= 0){
        		System.out.println("El n�mero entero debe ser positivo.");
            }else{
            	fibo.imprimirFibonacci(n);
            }
        	
        }catch(NumberFormatException e){
        	System.out.println("Por favor, debe introducir un n�mero entero v�lido.");
        }
    }
}
