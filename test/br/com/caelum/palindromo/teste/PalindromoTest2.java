package br.com.caelum.palindromo.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.palindromo.entidade.Palindromo;

public class PalindromoTest2 {

	@Test
	public void deveValidarOPalindromo() {

		// cenario
		Palindromo palindromo = new Palindromo();

		// acao
		boolean resultadoEsperado = palindromo.ehPalindromo("Anotaram a data da maratona");

		// validacao
		Assert.assertTrue(resultadoEsperado);

	}

}
