package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alan G. Diaz
 **/

public class GeneradorFibonacciTest {
	
	GeneradorFibonacci fibo =  new GeneradorFibonacci();
	
    @Test
    public void testGenerarFibonacciZero() {
    	int[] resultado = fibo.generarFibonacci(0);
    	int[] esperado = {};
        Assert.assertArrayEquals(esperado, resultado);
    }
    
    @Test
    public void testGenerarFibonacciUno() {
    	int[] resultado = fibo.generarFibonacci(1);
    	int[] esperado = {0};
        Assert.assertArrayEquals(esperado, resultado);
    }
    
    @Test
    public void testGenerarFibonacciCinco() {
    	int[] resultado = fibo.generarFibonacci(5);
    	int[] esperado = {0,1,1,2,3};
        Assert.assertArrayEquals(esperado, resultado);
    }
    
    @Test
    public void testGenerarFibonacciOcho() {
    	int[] resultado = fibo.generarFibonacci(8);
    	int[] esperado = {0,1,1,2,3,5,8,13};
        Assert.assertArrayEquals(esperado, resultado);
    }
    
    @Test
    public void testGenerarFibonacciNegative() {
    	int[] resultado = fibo.generarFibonacci(-3);
    	int[] esperado = {};
        Assert.assertArrayEquals(esperado, resultado);
    }
    
    @Test
    public void testInvertirSerie() {
    	int[] resultado = fibo.generarFibonacci(5);
    	int[] resultadoInvertido = fibo.invertirSerie(resultado);
    	int[] esperado = {3,2,1,1,0};
        Assert.assertArrayEquals(esperado, resultadoInvertido);
    }
    
}
