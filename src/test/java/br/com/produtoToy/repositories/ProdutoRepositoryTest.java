package br.com.produtoToy.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.produtoToy.domains.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository repo;
	
	@Test
	public void testaProdutoHavaiana() {
		List<Produto> produtos = repo.findByDescricaoContaining("Hava");
		
		assertThat(produtos.size()).isEqualTo(1);
	}
	
	@Test
	public void testaProdutoSapato() {
		List<Produto> produtos = repo.findByDescricaoContaining("Sapato");
		
		assertThat(produtos.size()).isEqualTo(0);
	}
}
