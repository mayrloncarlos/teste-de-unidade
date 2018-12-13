package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	
	private Avaliador leiloeiro;
	private Usuario maria;
	private Usuario joao;
	private Usuario jose;

	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.maria = new Usuario("Maria");
		this.jose = new Usuario("José");
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1: cenario		
		Leilao leilao = new CriadorDeLeilao().para("Playstation 4 novo")
				.lance(joao, 250.0)
				.lance(maria, 300.0)
				.lance(jose, 400.0)
				.constroi();
		
		// parte 2: acao
		leiloeiro.avalia(leilao);
		
		// parte 3: validacao
		double maiorEsperado = 400;
		double menorEsperado = 250;
		double mediaEsperada = 316.6666666666667;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, leiloeiro.getMediaDosLances(), 0.00001);

	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		// cenario	
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo")
				.lance(joao, 1000.0)
				.constroi();
		
		// acao
		leiloeiro.avalia(leilao);
		
		// validacao
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		// cenario
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();
		// acao
		leiloeiro.avalia(leilao);
		
		// validacao
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	}

}
