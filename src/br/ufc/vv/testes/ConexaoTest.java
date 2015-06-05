package br.ufc.vv.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufc.vv.connection.ConnectionFactory;
import br.ufc.vv.model.Pessoa;
import br.ufc.vv.model.connection.FabricaConexao;
import br.ufc.vv.model.connection.excecoes.ErroNaConexao;
import junit.framework.TestCase;

public class ConexaoTest extends TestCase{

	@Test
	public void testarConexao() throws ErroNaConexao{
		
		ConnectionFactory fabrica = new ConnectionFactory();
		
		assertNotNull(fabrica.getConnection());
	}
	
}
