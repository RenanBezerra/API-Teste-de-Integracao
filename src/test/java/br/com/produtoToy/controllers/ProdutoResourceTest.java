package br.com.produtoToy.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoResourceTest {
	
	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
//	@Test
//	public void testaRequisicaoIdSucesso() throws Exception{
//		String url = "/produtos/4";
//		this.mvc.perform(get(url))
//			.andExpect(status().isNotFound())
//			.andExpect(jsonPath("descricao",equalTo("Sandalia Havaiana")));
	
	@Test
	public void testaRequisicaoIdFalha() throws Exception{
		String url = "/produtos/3";
		this.mvc.perform(get(url))
			.andExpect(status().isNotFound());
			}
	
}
