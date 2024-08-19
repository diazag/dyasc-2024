package ar.edu.untref.dyasc;

/**
 * @author Alan G. Diaz
 **/

public class GeneradorFibonacci {
	
	private int[] serieFibonacci;
	private int numeroUno;
	private int numeroDos;
	
	public GeneradorFibonacci() {
		numeroUno = 0;
		numeroDos = 1;
	}
	
	/*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** 
	 ** Metodo que devuelve un array con los n numeros pertenecientes a la serie       **
	 **  de Fibonnacci.                                                                **
	 ** @param n define la cantidad de numeros de la serie de Fibonacci a gennerar.    **
	 ** @return Array compuesto por los n numeros de la serie generados.               **
	 *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **/
    public int[] generarFibonacci(int n) {
        
    	if(n<0){
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
    
    /*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **
     ** Metodo que genera una serie de Fibonacci de n numeros y la imprime.**
     *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **/
    public void imprimirFibonacci(int n){
    	
    	generarFibonacci(n);
    	
    	System.out.print("fibo<" + n + ">: ");
    	for (int i = 0; i < serieFibonacci.length; i++) {
			System.out.print(serieFibonacci[i] + " ");
		}
    }
}
