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
	
	private static List<Venda> vendas = new ArrayList<>();
	
	private Cliente cliente = new Cliente();
	private Item item = new Item();
	private DadosClientes d = new DadosClientes();
	
	public Venda() {}
	
	public Venda(Date data, Cliente client) {
		this.data = data;
		this.cliente = client;
	}

	public Date getData() {
		return data;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
	public List<Venda> getVendas() {
		return vendas;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void fazerVenda() {
		d.clientesIniciais();
		
		System.out.print("Qual o CPF/CNPJ do cliente (sem pontos): ");
		String cpf = sc.nextLine();
		
		Cliente temp = null;
		
		for (Cliente x : cliente.getClientes()) {
			if (x.getCpf_cnpj().equals(cpf)) {
				temp = x;
				System.out.println("Nome do cliente: " + x.getNome());
				System.out.println("Número de celular: " + x.getNumeroCelular());
				System.out.println();
				break;
			}
		}
		
		if (temp == null) {
			System.out.print("Qual o nome do cliente: ");
			String nome = sc.nextLine();
			System.out.print("Qual o número de celular do cliente: ");
			String numero = sc.nextLine();
			System.out.println();
			
			temp = new Cliente(nome, numero, cpf);
	        cliente.incluirCliente(temp);
		}
			
		Venda venda = new Venda(new Date(), temp);
		
		item.adicionarItem();
		
		recibo();
		
		System.out.println();
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
			
			for (Item y : item.getItens()) {
				for (int i = 0; i < y.getQtd(); i++)
					y.getProduto().diminuirEstoque();
			}
			
			vendas.add(venda);
			codigo = vendas.indexOf(venda);
		}
	}
	
	public Double calcularTotal() {
		for (Item x : item.getItens()) {
			valorTotal += x.calcularSubtotal(x);
		}
		
		return valorTotal;
	}
	
	public void recibo() {
		System.out.println("Itens adicionados ao carrinho: ");
		System.out.println("Descrição | Preço unitário | SubTotal");
		System.out.println("-------------------------------------");
		for (Item x : item.getItens()) 
			System.out.println(x.getProduto().getDescricao() + " | " 
		+ String.format("R$%.2f", x.getProduto().getPrecoDeVenda()) + " | " 
		+ String.format("R$%.2f", x.calcularSubtotal(x)));
		
		//valor total -10% desconto a vista
	}
	
	public Double desconto() {
		if (condPag.equals("À vista"))
			valorTotal *= 0.9;

		return valorTotal;
	}
}

