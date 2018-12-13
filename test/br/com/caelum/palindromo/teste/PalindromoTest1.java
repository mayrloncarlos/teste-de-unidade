package br.com.caelum.palindromo.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.palindromo.entidade.Palindromo;

public class PalindromoTest1 {

	@Test
	public void deveValidarOPalindromoEFiltrarCaracteres() {
		// cenario
		Palindromo palindromo = new Palindromo();
		
		// acao
		boolean resultadoEsperado = palindromo.ehPalindromo("Socorram-me subi no onibus em Marrocos");
		
		// validacao
		Assert.assertTrue(resultadoEsperado);

	}

}
