package com.farmacia.BemEstar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	@NotBlank
	@Size(min = 3, max = 15)
	private String nomeCategoria;

	@NotBlank
	@Size(min = 15, max = 500)
	private String descricaoCategoria;
	
	@OneToMany(mappedBy = "categoriaFarmacia", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoriaFarmacia")
	private List<Produto> produtoFarmacia = new ArrayList<>();

	public List<Produto> getProdutoFarmacia() {
		return produtoFarmacia;
	}

	public void setProdutoFarmacia(List<Produto> produtoFarmacia) {
		this.produtoFarmacia = produtoFarmacia;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}
