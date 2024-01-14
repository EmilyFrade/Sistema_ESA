package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
	Scanner sc = new Scanner(System.in);
	
	private Integer codigo;
	private String descricao;
	private Double precoDeCusto;
	private Double precoDeVenda;
	private Double porcentagemLucro = 1.6;
	private Integer estoque = 0;
	private Integer estoqueMin = 1;
	private Integer qtdVendida = 0;
	private String categoria;
	
	private static List<Produto> produtos = new ArrayList<>();
	
	public Produto() {}
	
	public Produto(String descricao, Double precoDeCusto, Integer estoque, String categoria) {
		this.descricao = descricao;
		this.precoDeCusto = precoDeCusto;
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

	public Double getPorcentagemLucro() {
		return porcentagemLucro;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void definirEstoqueMin() {
		System.out.println("O estoque mínimo atual é " + estoqueMin);
		System.out.println("Quanto gostaria de colocar como estoque mínimo? ");
		estoqueMin = sc.nextInt();
		System.out.println("Estoque mínimo atualizado: " + estoqueMin + " unidades.");
	}
	
	public void definirPorcenLucro() {
		System.out.println("A porcentagem de lucro atual é " + porcentagemLucro * 100);
		System.out.println("Quanto gostaria de colocar como porcentagem de lucro? ");
		porcentagemLucro = sc.nextDouble() / 100;
		System.out.println("Porcentagem de lucro atualizada: " + porcentagemLucro * 100);
	}
	
	public void diminuirEstoque() {
		estoque--;
	}
	
	public void aumentarEstoque() {
		estoque++;
	}
	
	public void reporEstoque() {
	
		if(estoque < estoqueMin) {
			while(estoque < estoqueMin ) {
				aumentarEstoque();
			}
		}
	}
	public void incluirProduto(Produto p) { 
		produtos.add(p);
		p.setCodigo(produtos.indexOf(p) + 1);
		p.precoDeVenda = calculaPrecoVenda();
	}
	
	public Double calculaPrecoVenda() {
		return precoDeCusto * porcentagemLucro;
	}
}
