package ar.edu.untref.dyasc;

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

	/*** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **
	 ** Metodo que genera una serie de Fibonacci de n numeros y la imprime.**
	 *** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **/
	public void imprimirFibonacci(int n, String orientacion, String direccion){

		int[] serieFibonacci = generarFibonacci(n);

		if(direccion.equalsIgnoreCase("i")){
			serieFibonacci = invertirSerie(serieFibonacci);
		}

		System.out.print("fibo<" + n + ">: ");
		if(orientacion.equalsIgnoreCase("v")){
			System.out.println();
			for(int num : serieFibonacci){
				System.out.println(num);
			}
		}else{
			for(int num : serieFibonacci){
				System.out.print(num + " ");
			}
			System.out.println();
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
	
}
