package entidades;
import entidades.Produto;
public class Relatorios {
	private Produto produto = new Produto();
	
	public void relatorioProdutosVendas() {
		System.out.println("Listagem de produtos disponíveis: ");
		System.out.println("Código | Descrição | Estoque | Preço");
		System.out.println("------------------------------------");
		
		for (Produto x : produto.getProdutos()) {
			if (x.getEstoque() > 0)
				System.out.println(x.getCodigo() + " | " +  
								x.getDescricao() + " | " + 
								x.getEstoque() + " | " + 
								String.format("R$%.2f", x.getPrecoDeVenda()));
		}
		System.out.println();
	}

	public void relatorioProdutosEstoqueMin() {
		System.out.println("Listagem de produtos disponíveis: ");
		System.out.println("Código | Descrição | Estoque | Preço");
		System.out.println("------------------------------------");
		
		for (Produto x : produto.getProdutos()) {
			if (x.getEstoque() == produto.estoqueMin)
				System.out.println(x.getCodigo() + " | " +  
								x.getDescricao() + " | " + 
								x.getEstoque() + " | " + 
								String.format("R$%.2f", x.getPrecoDeVenda()));
		}
		System.out.println();
	}
}