package entidades;

public class Relatorios {
	private Produto produto = new Produto();

	public void relatorioProdutos() {
		System.out.println("Listagem de produtos cadastrados: ");
		System.out.println("Código | Descrição | Estoque | P/custo | P/venda | Qtd Vendida | Categoria");
		System.out.println("--------------------------------------------------------------------------");

		for (Produto x : produto.getProdutos()) {
			System.out.println(x.getCodigo() + " | " + 
					x.getDescricao() + " | " + 
					x.getEstoque() + " | " + 
					String.format("R$%.2f", x.getPrecoDeCusto()) + " | " + 
					String.format("R$%.2f", x.getPrecoDeVenda()) + " | " + 
					x.getQtdVendida() + " | " + 
					x.getCategoria());
		}
		System.out.println();
	}
	
	public void relatorioProdutosVendas() {
		System.out.println("Listagem de produtos disponíveis: ");
		System.out.println("Código | Descrição | Estoque | Preço");
		System.out.println("------------------------------------");

		for (Produto x : produto.getProdutos()) {
			if (x.getEstoque() > 0)
				System.out.println(x.getCodigo() + " | " + x.getDescricao() + " | " + x.getEstoque() + " | "
						+ String.format("R$%.2f", x.getPrecoDeVenda()));
		}
		System.out.println();
	}

	public void relatorioProdutosEstoqueMin() {
		System.out.println("Listagem de produtos em estoque mínimo: ");
		System.out.println("Código | Descrição | Estoque | P/custo | P/venda | Qtd Vendida | Categoria");
		System.out.println("--------------------------------------------------------------------------");

		for (Produto x : produto.getProdutos()) {
			if (x.getEstoque() <= produto.getEstoqueMin())
				System.out.println(x.getCodigo() + " | " + 
						x.getDescricao() + " | " + 
						x.getEstoque() + " | " + 
						String.format("R$%.2f", x.getPrecoDeCusto()) + " | " + 
						String.format("R$%.2f", x.getPrecoDeVenda()) + " | " + 
						x.getQtdVendida() + " | " + 
						x.getCategoria());
		}
		System.out.println();
	}

}
