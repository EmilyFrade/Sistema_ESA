package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Venda {
	Scanner sc = new Scanner(System.in);
	
	private Date data;
	private Integer codigo;
	private String condPag;
	private Double desconto = 0.1;
	private Double valorTotal = 0.0;
	
	private Item item;
	private Cliente client;
	private List<Venda> vendas = new ArrayList<>();
	protected List<Item> itens;
	protected List<Cliente> clientes;
	
	public Venda(Date data, Cliente client) {
		this.data = data;
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
	
	public void fazerVenda() {
		System.out.println("Qual o CPF/CNPJ do cliente (sem pontos): ");
		String c = sc.nextLine();
		
		Cliente cliente;
		
		for (Cliente x : clientes) {
			if (x.getCpf_cnpj() == c) {
				cliente = x;
			} else {
				System.out.println("Qual o nome do cliente: ");
				String nome = sc.nextLine();
				System.out.println("Qual o número de celular do cliente: ");
				String numero = sc.nextLine();
				
				cliente = new Cliente(nome, numero, c);
			}
			
			Venda venda = new Venda(new Date(), cliente);
			
			item.adicionarItem();
			
			recibo();
			
			System.out.println("Qual a forma de pagamento?");
			System.out.println("[1] À vista \n[2] À prazo");
			Integer pag = sc.nextInt();

			if (pag == 1)
				condPag = "À vista";
			else if (pag == 2)
				condPag = "À prazo";
			else
				System.out.println("Número inválido.");
			
			System.out.println("Valor total da compra: R$" + valorTotal);
			
			System.out.println("Deseja finalizar a compra? (s/n)");
			char finalizar = sc.next().charAt(0);
			
			if (finalizar == 's' || finalizar == 'S') {
				System.out.println("Compra realizada com sucesso");
				cliente.adicionarCompra();
				
				for (Item y : itens) {
					for (int i = 0; i < y.getQtd(); i++)
						y.getProduto().diminuirEstoque();
				}
				
				vendas.add(venda);
				codigo = vendas.indexOf(venda);
			}
		}
	}
	
	public Double calcularTotal() {
		for (Item x : itens) {
			valorTotal += x.calcularSubtotal(x);
		}
		
		return valorTotal;
	}
	
	public void recibo() {
		System.out.println("Itens adicionados ao carrinho: ");
		System.out.println("Código - Descrição -------------- VUnit ------ SubTotal ---------");
		for (Item x : itens) 
			System.out.println(x.getProduto().getCodigo() + " " + x.getProduto().getDescricao() 
					+ " " + x.getProduto().getPrecoDeVenda() + " " + x.calcularSubtotal(x));
		
		//valor total -10% desconto a vista
	}
	
	public Double desconto() {
		return valorTotal;
	}
}
