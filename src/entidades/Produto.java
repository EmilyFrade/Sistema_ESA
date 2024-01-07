package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
	Scanner sc = new Scanner(System.in);
	
	protected List<Produto> sofas = new ArrayList<>();
	protected List<Produto> armarios = new ArrayList<>();
	protected List<Produto> camas = new ArrayList<>();
	
	private Integer codigo;
	private String descricao;
	private Double precoDeCusto;
	private Double precoDeVenda;
	private Integer estoque;
	private Integer estoqueMin = 1;
	private Integer qtdVendida = 0;
	private String categoria;
	
	public Produto(String descricao, Double precoDeCusto, Double precoDeVenda, Integer estoque, String categoria) {
		this.descricao = descricao;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.estoque = estoque;
		this.categoria = categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void definirEstoqueMin() {
		System.out.println("O estoque mínimo atual é " + estoqueMin);
		System.out.println("Quanto gostaria de colocar como estoque mínimo? ");
		estoqueMin = sc.nextInt();
		System.out.println("Estoque mínimo atualizado: " + estoqueMin + " unidades.");
	}
	
	public void pesquisarProduto() {
		// chamar relatorio produtos
	}
	
	public void incluirProduto(Produto p) { 
		if (p.getCategoria() == "Sofás") {
			sofas.add(p);
			p.setCodigo(sofas.indexOf(p) + 1);
		} else if (p.getCategoria() == "Armários") {
			armarios.add(p);
			p.setCodigo(armarios.indexOf(p) + 1);
		} else if (p.getCategoria() == "Camas") {
			camas.add(p);
			p.setCodigo(camas.indexOf(p) + 1);
		} 
	}
}
