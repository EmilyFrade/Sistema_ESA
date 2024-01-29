package entidades;

import java.text.SimpleDateFormat;

public class Relatorios {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private Produto produto = new Produto();
	private Cliente cliente = new Cliente();

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
			if (x.getEstoque() <= x.getEstoqueMin())
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

		for (Compra x : Compra.getCompras()) {
			 System.out.println("Código da Compra: " + x.getCodigo());
			 System.out.println("Data da Compra: " + sdf.format(x.getData()));
			 System.out.println("Fornecedor: " + x.getFornecedor());
			 System.out.println("Produto: " + x.getProduto().getDescricao());
			 System.out.println("Unidades compradas: " + x.getUnidades());
			 System.out.println("Valor Total da Compra: R$" + String.format("%.2f", x.getValorTotal()));
			 System.out.println("----------------------------------\n"); 
		}
	}
	
	public void relatorioVendas() {
		System.out.println("Relatório de Vendas Finalizadas:");
		System.out.println("--------------------------------");
		double valorTotalDoDia = 0.0;

		for (Venda venda : Venda.getVendas()) {
			System.out.println("Código da Venda: " + venda.getCodigo());
			System.out.println("Data da Venda: " +  sdf.format(venda.getData()));
			System.out.println("Cliente: " + venda.getCliente().getNome());
			System.out.println("Forma de Pagamento: " + venda.getCondPag());
			System.out.println("\nItens da Venda:");

			for (Item x : venda.getItens()) {
				System.out.println(x.getProduto().getDescricao() + " | "
				+ String.format("%.0fun", x.calcularSubtotal(x) / x.getProduto().getPrecoDeVenda()) + " | "
				+ String.format("R$%.2f", x.calcularSubtotal(x)));
			}
			
			System.out.println("\nValor Total da Venda: R$" + String.format("%.2f", venda.getValorTotal()));
			System.out.println("----------------------------------");

			valorTotalDoDia += venda.getValorTotal();
		} 
		System.out.println("Valor Total de Todas as Vendas do Dia: R$" + String.format("%.2f", valorTotalDoDia));
	}
	
	public void relatorioClientes() {
		System.out.println("Listagem de clientes cadastrados: ");
		System.out.println("Código | Nome | Celular | CPF/CNPJ | Compras");
		System.out.println("--------------------------------------------");

		for (Cliente x : cliente.getClientes()) {
			System.out.println(x.getCodigo() + " | " + x.getNome() + " | " + x.getNumeroCelular() + " | " 
					+ x.getCpf_cnpj() + " | " + x.getQtdCompras());
		}
		System.out.println();
	}
}
