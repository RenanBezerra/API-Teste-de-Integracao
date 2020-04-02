package br.com.produtoToy.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoResourceTest {

	@Autowired
	public WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

//	@Test
//	public void testa01RequisicaoIdSucesso() throws Exception{
//		String url = "/produtos/4";
//		this.mvc.perform(get(url))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("descricao",equalTo("Sandalia Havaiana")));

	@Test
	public void testa02RequisicaoIdFalha() throws Exception {
		String url = "/produtos/3";
		this.mvc.perform(get(url)).andExpect(status().isNotFound());
	}

//	@Test
//	public void testa03RequisicaoDescricaoSucesso() throws Exception{
//		String url = "/produtos/like/havaiana";
//		this.mvc.perform(get(url))
//			.andExpect(status().isOk())
//			.andExpect(content().string(containsString("Sandalia Havaiana")));
//			}
	@Test
	public void testa04RequisicaoDescricaoFalha() throws Exception {
		String url = "/produtos/like/havaina";
		this.mvc.perform(get(url)).andExpect(status().isNotFound());
	}

	@Test
	public void testa05RequisicaoDeleteSucesso() throws Exception {
		String url = "/produtos/1";
		this.mvc.perform(delete(url))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("1")));
	}

	@Test
	public void testa06RequisicaoDeleteFalha() throws Exception {
		String url = "/produtos/3";
		this.mvc.perform(delete(url))
			.andExpect(status().isNotFound());
	}
	 
	@Test
	public void testa07RequisicaoPostSucesso() throws Exception {
		String url = "/produtos";
		this.mvc.perform(post(url).content("{\"descricao\":\"Brinquedo\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(header().string("Location",is("http://localhost/produtos/3")))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testa08RequisicaoPostFalha() throws Exception {
		String url = "/produtos";
		this.mvc.perform(post(url)
				.content("{\"descri1cao\":\"Brinquedo\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

}
