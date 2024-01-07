package servicos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.Item;

public class Venda {
	private Date data;
	private Integer codigo;
	private String condPag;
	private Double desconto = 0.0;
	private Double valorTotal = 0.0;
	
	private Cliente client;
	private List<Item> list = new ArrayList<>();
	
	public Venda(Date data, Integer codigo, Cliente client) {
		this.data = data;
		this.codigo = codigo;
		this.client = client;
	}

	public Date getData() {
		return data;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCondPag() {
		return condPag;
	}

	public void setCondPag(String condPag) {
		this.condPag = condPag;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public List<Item> getList() {
		return list;
	}

	public void adicionarItem(Item item) {
		list.add(item);
	}
	
	public void fazerVenda() {
		
	}
	
	public Double calcularTotal() {
		for (Item x : list) {
			this.valorTotal += x.calcularSubtotal();
		}
		
		return this.valorTotal;
	}
	
	public void recibo() {
		System.out.println("Itens adicionados ao carrinho: ");
		System.out.println("Código - Descrição -------------- VUnit ------ SubTotal ---------");
		for (Item x : list) 
			System.out.println(x.getProduto().getCodigo() + " " + x.getProduto().getDescricao() 
					+ " " + x.getProduto().getPrecoDeVenda() + " " + x.calcularSubtotal());
	}
}
