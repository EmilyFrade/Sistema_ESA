package entidades;

public class Produto {
	private Integer codigo;
	private String descricao;
	private Double precoDeCusto;
	private Double precoDeVenda;
	private Integer estoque;
	private Integer estoqueMin = 5;
	private Integer qtdVendida;
	private String Categoria;
	
	public Produto(Integer codigo, String descricao, Double precoDeCusto, 
			Double precoDeVenda, Integer estoque,
			Integer qtd, String categoria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.estoque = estoque;
		Categoria = categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoDeCusto() {
		return precoDeCusto;
	}

	public void setPrecoDeCusto(Double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public Integer getEstoqueMin() {
		return estoqueMin;
	}

	public Integer getQtdVendida() {
		return qtdVendida;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
}
