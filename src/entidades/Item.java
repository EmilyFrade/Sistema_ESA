package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {
	Scanner sc = new Scanner(System.in);
	
	private Produto produto;
	private Integer qtd;
	
	protected List<Item> itens = new ArrayList<>();
	protected List<Produto> produtos;
	
	public Item(Produto produto, Integer qtd) {
		this.produto = produto;
		this.qtd = qtd;
	}

	public Produto getProduto() {
		return produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
	public void adicionarItem() {
		char c = 's';
		
		while (c == 's' || c == 'S' ) {
			//relatorio produtos disponiveis
			
			System.out.println("Qual o código do produto que deseja adicionar ao carrinho? ");
			Integer codigo = sc.nextInt();
			
			for (Produto x : produtos) {
				if (x.getCodigo() == codigo) {
					do {
						System.out.println("Quantas unidades do produto deseja adicionar? ");
						qtd = sc.nextInt();
					} while (!verificarDisponibilidade(qtd));
					
					Item item = new Item(x, qtd);
					itens.add(item);
					
					break;
				}
			}
			
			System.out.println("Deseja adicionar novo produto ao carrinho? (s/n)");
			c = sc.next().charAt(0);	
		}	
	}
	
	public Double calcularSubtotal(Item item) {
		return item.getQtd() * item.getProduto().getPrecoDeVenda();
	}
	
	public Boolean verificarDisponibilidade(Integer qtd) {
		if (qtd > produto.getEstoque()) {
			System.out.println("Não é possível adicionar o item, pois o estoque é insuficiente.");
			System.out.println("Quantidade em estoque do produto: " + this.produto.getEstoque());
			return false;
		}
		
		return true;
	}
}
