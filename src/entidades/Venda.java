package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;

public class Venda {
	Scanner sc = new Scanner(System.in);

	private Date data;
	private Integer codigo;
	private String condPag;
	private Double desconto = 0.1;
	private Double valorTotal;
	private static int ultimoCodigo = 0;

	private static List<Venda> vendas = new ArrayList<>();

	private Cliente cliente = new Cliente();
	public static Item item = new Item();
	private Relatorios r = new Relatorios();

	public Venda() {

	}

	public Venda(Date data, Cliente client) {
		this.codigo = ++ultimoCodigo;
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
		valorTotal = 0.0;

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

		r.relatorioProdutosVendas();
		item.adicionarItem();

		recibo();

		System.out.println();
		System.out.println("Qual a forma de pagamento?");
		System.out.println("[1] À vista \n[2] À prazo");
		Integer pag = sc.nextInt();

		if (pag == 1) {
			venda.condPag = "À vista";
			condPag = venda.getCondPag();
		} else if (pag == 2) {
			venda.condPag = "À prazo";
			condPag = venda.getCondPag();
		} else
			System.out.println("Número inválido.");

		venda.valorTotal = calcularTotal();
		valorTotal = venda.valorTotal;
		System.out.println();
		System.out.printf("Valor total da compra: R$%.2f \n", venda.valorTotal);

		System.out.println();
		System.out.print("Deseja finalizar a compra (s/n)? ");
		char finalizar = sc.next().charAt(0);
		sc.nextLine();

		if (finalizar == 's' || finalizar == 'S') {
			System.out.println("Compra realizada com sucesso \n");
			temp.adicionarCompra();

			for (Item y : item.getItens()) {
				for (int i = 0; i < y.getQtd(); i++)
					y.getProduto().diminuirEstoque();
			}

			vendas.add(venda);
			codigo = vendas.indexOf(venda);
		} else if (finalizar == 'n' || finalizar == 'N') {
			System.out.println("Compra cancelada \n");
			valorTotal = 0.0;
		}

		item.getItens().clear();
	}

	public Double calcularTotal() {
		for (Item x : item.getItens()) {
			valorTotal += x.calcularSubtotal(x);
		}

		if (condPag.equals("À vista"))
			valorTotal *= 0.9;

		return valorTotal;
	}

	public void recibo() {
		System.out.println("Itens adicionados ao carrinho: ");
		System.out.println("Descrição | Preço unitário | SubTotal");
		System.out.println("-------------------------------------");

		for (Item x : Venda.item.getItens()) {
			System.out.println(
					x.getProduto().getDescricao() + " | " + String.format("R$%.2f", x.getProduto().getPrecoDeVenda())
							+ " | " + String.format("R$%.2f", x.calcularSubtotal(x)));
		}
	}

	public static void relatorioVendasFinalizadas() {
		System.out.println("Relatório de Vendas Finalizadas:");
		System.out.println("------------------------------");
		double valorTotalDoDia = 0.0;

		Calendar dataAtual = Calendar.getInstance();

		for (Venda venda : vendas) {

			Calendar dataVenda = Calendar.getInstance();
			dataVenda.setTime(venda.getData());

			if (dataAtual.get(Calendar.DAY_OF_YEAR) == dataVenda.get(Calendar.DAY_OF_YEAR)
					&& dataAtual.get(Calendar.YEAR) == dataVenda.get(Calendar.YEAR)) {

				System.out.println("Código da Venda: " + venda.getCodigo());
				System.out.println("Data da Venda: " + venda.getData());
				System.out.println("Cliente: " + venda.getCliente().getNome());
				System.out.println("Forma de Pagamento: " + venda.getCondPag());
				System.out.println("Itens da Venda:");

				for (Item x : item.getItens()) {
					System.out.println(x.getProduto().getDescricao() + " | "
							+ String.format("R$%.2f", x.getProduto().getPrecoDeVenda()) + " | "
							+ String.format("R$%.2f", x.calcularSubtotal(x)));

					System.out.println("Valor Total da Venda: R$" + String.format("%.2f", venda.getValorTotal()));
					System.out.println("----------------------------------");

					valorTotalDoDia += venda.getValorTotal();

					System.out.println(
							"Valor Total de Todas as Vendas do Dia: R$" + String.format("%.2f", valorTotalDoDia));
				}
			}
		}
	}
}
