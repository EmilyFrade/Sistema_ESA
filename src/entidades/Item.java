package entidades;

public class Item {
	private Produto produto;
	private Integer qtd;
	
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
	
	public Double calcularSubtotal() {
		return qtd * produto.getPrecoDeVenda();
	}
	
	public Integer verificarDisponibilidade() {
		if (this.qtd > this.produto.getEstoque()) {
			System.out.println("Não é possível adicionar o item, pois o estoque é insuficiente.");
			System.out.println("Quantidade em estoque do produto: " + this.produto.getEstoque());
			return 1;
		}
		
		return 0;
	}
}
