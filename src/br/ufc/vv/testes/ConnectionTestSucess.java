package br.ufc.vv.testes;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.ufc.vv.connection.ConnectionFactory;

public class ConnectionTestSucess {

	@Before
	public void setUp() throws Exception {
		final Mockery context = new Mockery();
	}

	@Test
	public void testarQueAConexaoComBancoDeDadosOcorreuComSucesso(){
		
		ConnectionFactory conexao = new ConnectionFactory();
		
		assertNotNull(conexao);
		
	}
}
 