package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Venda {
	private Date data;
	private Integer codigo;
	private String condPag;
	private Double desconto = 0.1;
	private Double valorTotal = 0.0;
	
	private Cliente cliente = new Cliente();
	private Item item = new Item();
	private List<Venda> vendas = new ArrayList<>();
	
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
		return cliente;
	}

	public void setClient(Cliente client) {
		this.cliente = client;
	}
	
	public void fazerVenda() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual o CPF/CNPJ do cliente (sem pontos): ");
		String c = sc.nextLine();
		
		Cliente temp = null;
		
		for (Cliente x : cliente.getClientes()) {
			System.out.println("Achou");
			if (x.getCpf_cnpj().equals(c)) {
				temp = x;
				break;
			}
		}
		
		if (temp == null) {
			System.out.print("Qual o nome do cliente: ");
			String nome = sc.nextLine();
			System.out.print("Qual o número de celular do cliente: ");
			String numero = sc.nextLine();
			
			temp = new Cliente(nome, numero, c);
	        cliente.incluirCliente(temp);
		}
			
		Venda venda = new Venda(new Date(), temp);
		
		/*System.out.println(venda.getClient().getNome() 
				+ " " + venda.getClient().getCpf_cnpj()
				+ " " + venda.getClient().getNumeroCelular()
				+ " " + venda.getData());
		*/
		
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
			
			for (Item y : item.itens) {
				for (int i = 0; i < y.getQtd(); i++)
					y.getProduto().diminuirEstoque();
			}
			
			vendas.add(venda);
			codigo = vendas.indexOf(venda);
		}
		
		sc.close();
	}
	
	public Double calcularTotal() {
		for (Item x : item.itens) {
			valorTotal += x.calcularSubtotal(x);
		}
		
		return valorTotal;
	}
	
	public void recibo() {
		System.out.println("Itens adicionados ao carrinho: ");
		System.out.println("Código - Descrição -------------- VUnit ------ SubTotal ---------");
		for (Item x : item.itens) 
			System.out.println(x.getProduto().getCodigo() + " " + x.getProduto().getDescricao() 
					+ " " + x.getProduto().getPrecoDeVenda() + " " + x.calcularSubtotal(x));
		
		//valor total -10% desconto a vista
	}
	
	public Double desconto() {
		return valorTotal;
	}
}

