package br.com.produtoToy.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="COD_PRODUTO")
	private Integer id;
	
	@NotNull(message = "O campo descricao não pode ser vazio")
	@Size(min = 3,message = "O campo descrição precisa ter pelo menos 3 caracteres")
	@Column(name = "DSC_PRODUTO", length = 255, nullable = false, unique = true )
	private String descricao;

	
	
	
	public Produto() {
	
	}
	

	public Produto( String descricao) {
		this.descricao = descricao;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
