package br.ufc.vv.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.ufc.vv.connection.ConnectionFactory;
import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;

public class ConnectionTest {

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
 