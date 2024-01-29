package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {
	Scanner sc = new Scanner(System.in);

	private Integer qtd;
	private static List<Item> itens = new ArrayList<>();

	private Produto produto = new Produto();

	public Item() {}

	public Item(Produto produto, Integer qtd) {
		this.produto = produto;
		this.qtd = qtd;
	}

	public Integer getQtd() {
		return qtd;
	}

	public List<Item> getItens() {
		return itens;
	}

	public Produto getProduto() {
		return produto;
	}

	public void adicionarItem() {
		char c = 's';

		while (c == 's' || c == 'S') {
			System.out.print("Qual o código do produto que deseja adicionar ao carrinho? ");
			Integer codigo = sc.nextInt();

			for (Produto x : produto.getProdutos()) {
				if (x.getCodigo() == codigo) {
					produto = x;
					do {
						System.out.print("Quantas unidades do produto deseja adicionar? ");
						qtd = sc.nextInt();
					} while (!verificarDisponibilidade(qtd));

					Item item = new Item(x, qtd);
					itens.add(item);

					break;
				}
			}

			System.out.print("Deseja adicionar novo produto ao carrinho (s/n)? ");
			c = sc.next().charAt(0);
			System.out.println();
		}
	}

	public Double calcularSubtotal(Item item) {
		return item.getQtd() * item.getProduto().getPrecoDeVenda();
	}

	public Boolean verificarDisponibilidade(Integer qtd) {
		if (qtd > produto.getEstoque()) {
			System.out.println("Não é possível adicionar o item, pois o estoque é insuficiente.");
			System.out.println("Quantidade em estoque do produto: " + produto.getEstoque() + "\n");
			return false;
		}
		
		return true;
	}
}
