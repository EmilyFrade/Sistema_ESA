package entidades;

import java.text.SimpleDateFormat;

public class Relatorios {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private Produto produto = new Produto();

	public void relatorioProdutos() {
		System.out.println("Listagem de produtos cadastrados: ");
		System.out.println("Código | Descrição | Estoque | P/custo | P/venda | Vendidos | Categoria");
		System.out.println("-----------------------------------------------------------------------");

		for (Produto x : produto.getProdutos()) {
			System.out.println(x.getCodigo() + " | " + x.getDescricao() + " | " + x.getEstoque() + " | "
					+ String.format("R$%.2f", x.getPrecoDeCusto()) + " | "
					+ String.format("R$%.2f", x.getPrecoDeVenda()) + " | " + x.getQtdVendida() + " | "
					+ x.getCategoria());
		}
		System.out.println();
	}

	public void relatorioProdutosVendas() {
		System.out.println("Listagem de produtos disponíveis: ");
		System.out.println("Código | Descrição | Estoque | Preço");
		System.out.println("------------------------------------");

		for (Produto x : produto.getProdutos()) {
			if (x.getEstoque() > 00)
				System.out.println(x.getCodigo() + " | " + x.getDescricao() + " | " + x.getEstoque() + " | "
						+ String.format("R$%.2f", x.getPrecoDeVenda()));
		}
		System.out.println();
	}

	public void relatorioProdutosEstoqueMin() {
		System.out.println("Listagem de produtos em estoque mínimo: ");
		System.out.println("Código | Descrição | Estoque | P/custo | P/venda | Vendidos | Categoria");
		System.out.println("-----------------------------------------------------------------------");

		for (Produto x : produto.getProdutos()) {
			if (x.getEstoque() <= produto.getEstoqueMin())
				System.out.println(x.getCodigo() + " | " + x.getDescricao() + " | " + x.getEstoque() + " | "
						+ String.format("R$%.2f", x.getPrecoDeCusto()) + " | "
						+ String.format("R$%.2f", x.getPrecoDeVenda()) + " | " + x.getQtdVendida() + " | "
						+ x.getCategoria());
		}
		System.out.println();
	}

	public void relatorioCompras() {
		System.out.println("Relatório de Compras Realizadas:");
		System.out.println("--------------------------------");

		/*
		 * for (Compra x : Compra.getCompras()) {
		 * System.out.println("Código da Compra: " + x.getCodigo());
		 * System.out.println("Data da Compra: " + sdf.format(x.getData()));
		 * System.out.println("Fornecedor: " + x.getFornecedor());
		 * System.out.println("Produto: " + x.getProduto().getDescricao());
		 * System.out.println("Unidades compradas: " + x.getUnidades());
		 * System.out.println("Valor Total da Compra: R$" + String.format("%.2f",
		 * x.getValorTotal()));
		 * System.out.println("----------------------------------\n"); }
		 */

	}

}
