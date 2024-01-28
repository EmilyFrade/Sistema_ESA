package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Compra {
	Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private Date data;
	private Integer codigo;
	private Produto produto;
	private Integer unidades;
	private String fornecedor;
	private Double valorTotal;

	private static List<Compra> compras = new ArrayList<>();

	private Relatorios r = new Relatorios();
	private Produto p = new Produto();

	public Compra() {}

	public Compra(Date data, Produto p, Integer un, String fornecedor, Double total) {
		this.data = data;
		this.produto = p;
		this.unidades = un;
		this.fornecedor = fornecedor;
		this.valorTotal = total;
	}

	public Date getData() {
		return data;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public static List<Compra> getCompras() {
		return compras;
	}

	public void fazerCompra() {
		r.relatorioProdutos();

		System.out.print("Qual o código do produto que deseja repor: ");
		Integer codigo = sc.nextInt();
		
		for (Produto x : p.getProdutos()) {
			if (x.getCodigo().equals(codigo)) {
				produto = x;
				break;
			} 
		}

		System.out.print("Quantas unidades deseja repor: ");
		unidades = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Nome do fornecedor: ");
		String fornecedor = sc.nextLine();
		
		Double total = produto.getPrecoDeCusto() * unidades;
		
		Compra compra = new Compra(new Date(), produto, unidades, fornecedor, total);

		System.out.println();
		System.out.printf("Valor total da compra: R$%.2f \n", compra.valorTotal);

		System.out.println();
		System.out.print("Deseja finalizar a compra (s/n)? ");
		char finalizar = sc.next().charAt(0);
		sc.nextLine();

		if (finalizar == 's' || finalizar == 'S') {
			System.out.println("Compra realizada com sucesso");

			for (int i = 0; i < unidades; i++)
				produto.aumentarEstoque();

			compras.add(compra);
			compra.codigo = compras.indexOf(compra);
		} 
		else if (finalizar == 'n' || finalizar == 'N') {
			System.out.println("Compra cancelada");
			valorTotal = 0.0;
		}
	}
}
