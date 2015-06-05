package br.ufc.vv.tests;

import org.junit.Test;

import br.ufc.vv.model.Pessoa;
import br.ufc.vv.model.contract.IPessoa;
import junit.framework.TestCase;

public class PessoaTest extends TestCase{
	
	@Test
	public void testarGetsESetsDaPessoa(){
		IPessoa pessoa = new Pessoa();

		pessoa.setNome("Randerson");
		assertEquals("Randerson", pessoa.getNome());
		
		pessoa.setIdade(18);
		assertEquals(18, pessoa.getIdade().intValue());
		
		pessoa.setId(1);
		assertEquals(1, pessoa.getId().intValue());

		pessoa.setSalario(200.1);
		assertEquals(200.1, pessoa.getSalario());
		
		pessoa.setRg(234123);
		assertEquals(234123, pessoa.getRg().intValue());
		
		pessoa.setTipo("ator");
		assertEquals("ator", pessoa.getTipo());
	}
}
