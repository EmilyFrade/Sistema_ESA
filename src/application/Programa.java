package application;

import java.util.Scanner;

import entidades.Caixa;
import entidades.Compra;
import entidades.DadosClientes;
import entidades.Estoque;
import entidades.Produto;
import entidades.Relatorios;
import entidades.Venda;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String verde = "\u001B[32m";
		String limpa = "\u001B[0m";
		String vermelho = "\u001B[31m";
		String bgverde = "\u001B[42m";

		Caixa caixa = new Caixa();
		Venda venda = new Venda();
		DadosClientes d = new DadosClientes();
		Estoque e = new Estoque();
		Relatorios r = new Relatorios();
		Produto p = new Produto();
		Compra c = new Compra();

		d.clientesIniciais();
		e.estoqueInicial();

		int sair = 1;
		int sairMenu = 1, caixaAberto = 0, escolha = 0;

		System.out.print("|======================================================================|\n");
		System.out.println(
				"|" + verde + "                  Bem vindo ao E$A - Sistema de vendas                " + limpa + "|");
		System.out.println("|======================================================================|\n");

		while (sair == 1) {
			sairMenu = 1;
			System.out.println(
					bgverde + "                          SELECIONAR USUÁRIO                           " + limpa);
			System.out.println();
			System.out.println(verde + "[1]" + limpa + " Vendedor");
			System.out.println(verde + "[2]" + limpa + " Comprador");
			System.out.println(verde + "[3]" + limpa + " Gerente");
			System.out.println(vermelho + "[4]" + limpa + " Sair do programa");
			int usuario = sc.nextInt();

			switch (usuario) {
			case 1:
				System.out.println("\n|                     Usuário" + verde + " vendedor " + limpa
						+ "selecionado!                   |");
				System.out.println("|_____________________________________________________________________|\n");

				while (sairMenu == 1 || sairMenu == 2) {
					System.out.println(verde + "[1]" + limpa + " Abrir caixa \n" + verde + "[2]" + limpa
							+ " Nova venda \n" + verde + "[3]" + limpa + " Suprimento\n" + verde + "[4]" + limpa
							+ " Sangria\n" + verde + "[5]" + limpa + " Vizualizar caixa\n" + verde + "[6]" + limpa
							+ " Pesquisar produto\n" + verde + "[7]" + limpa + " Fechar caixa\n" + verde + "[8]" + limpa 
							+ " Vendas realizadas\n" + vermelho + "[9]" + limpa + " Sair");

					int menuVendedor = sc.nextInt();

					switch (menuVendedor) {
					case 1:
						System.out.println(bgverde
								+ "                              ABRIR CAIXA                              \n" + limpa);
						if (caixaAberto == 0) 
							caixaAberto = caixa.abrirCaixa(caixa);
					
						else 
							System.out.println("O caixa já foi aberto");
							System.out.println("=======================================================================\n");
							sairMenu = 2;
							break;
							
					case 2:
						System.out.println(bgverde
								+ "                              NOVA VENDA                               \n" + limpa);
						if (caixaAberto == 1) {
							do {
								venda.fazerVenda();
								caixa.adicionarDinheiro(venda.getValorTotal());
								System.out.println("Deseja efetuar outra venda?\n[1] Sim \n[2] Não");
								sairMenu = sc.nextInt();
								sc.nextLine();
								System.out.println();
							} while (sairMenu == 1);

						} else {
							System.out.println("O caixa ainda não foi aberto");
							sairMenu = 2;
						}
						System.out.println("=======================================================================\n");
						break;

					case 3:
						System.out.println(bgverde
								+ "                              SUPRIMENTO                               \n" + limpa);
						if (caixaAberto == 1) {
							do {
								System.out.printf("Valor atual do caixa: %.2f \n", caixa.getValor());
								System.out.print("Qual o valor deseja adicionar? ");
								System.out.printf("Valor atual do caixa: R$%.2f",
										caixa.adicionarDinheiro(sc.nextDouble()));
								System.out.println("\n\nDeseja adicionar mais dinheiro?\n[1] Sim \n[2] Não");
								sairMenu = sc.nextInt();
							} while (sairMenu == 1);
						} else {
							System.out.println("O caixa ainda não foi aberto");
							sairMenu = 2;
						}

						System.out.println("=======================================================================\n");
						break;

					case 4:
						System.out.println(bgverde
								+ "                               SANGRIA                                 \n" + limpa);
						if (caixaAberto == 1) {
							do {
								caixa.sangria();
								System.out.println("\n\nDeseja retirar mais dinheiro?\n[1] Sim \n[2] Não");
								sairMenu = sc.nextInt();
							} while (sairMenu == 1);
						} else {
							System.out.println("O caixa ainda não foi aberto");
							sairMenu = 2;
						}

						System.out.println("=======================================================================\n");
						break;

					case 5:

						System.out.println(bgverde
								+ "                           VIZUALIZAR CAIXA                            \n" + limpa);
						if (caixaAberto == 1) {
							caixa.vizualizarCaixa();
						} else {
							System.out.println("O caixa ainda não foi aberto");
							sairMenu = 2;
						}
						System.out.println("=======================================================================\n");
						sairMenu = 2;
						break;

					case 6:
						System.out.println(
								bgverde + "                                 PRODUTOS                                \n"
										+ limpa);
						r.relatorioProdutosVendas();
						break;

					case 7:
						System.out.println(bgverde
								+ "                              FECHAR CAIXA                              \n" + limpa);
						if (caixaAberto == 1) {
							caixa.fecharCaixa();
							caixaAberto = 0;
							sairMenu = 2;
						} else {
							System.out.println("O caixa já está fechado");
							sairMenu = 2;
						}

						System.out.println("=======================================================================\n");
						break;
						
					case 8:
						System.out.println(bgverde
								+ "                              RELATÓRIO DE VENDAS                              \n" + limpa);
						r.relatorioVendas();
						System.out.println("=======================================================================\n");
						break;
						
					case 9:
						sairMenu = 3;
						sair = 1;
						break;

					default:
						System.out.println("Entrada inválida \n");
					}
				}
				break;

			case 2:
				System.out.println("\n|                    Usuário" + verde + " comprador " + limpa
						+ "selecionado!                   |");
				System.out.println("|_____________________________________________________________________|\n");

				while (sairMenu == 1 || sairMenu == 2) {
					System.out.println(verde + "[1]" + limpa + " Cadastrar produto \n" + verde + "[2]" + limpa
							+ " Excluir produto \n" + verde + "[3]" + limpa + " Vizualizar produtos em baixo estoque \n"
							+ verde + "[4]" + limpa + " Repor estoque mínimo\n" + verde + "[5]" + limpa
							+ " Fazer compra\n" + verde + "[6]" + limpa + " Compras realizadas\n" + vermelho 
							+ "[7]" + limpa + " Sair");

					int menuVendedor = sc.nextInt();

					switch (menuVendedor) {
					case 1:
						System.out.println(bgverde
								+ "                           CADASTRAR PRODUTO                           \n" + limpa);

						do {
							p.cadastrarProduto();
							System.out.println(
									"=======================================================================\n");
							System.out.println("Deseja cadastrar outro produto?\n[1] Sim \n[2] Não");
							sairMenu = sc.nextInt();
						} while (sairMenu == 1);

						System.out.println("=======================================================================\n");
						break;

					case 2:
						System.out.println(bgverde
								+ "                             EXCLUIR PRODUTO                           \n" + limpa);

						do {
							r.relatorioProdutos();
							p.excluirProduto();
							System.out.println(
									"=======================================================================\n");
							System.out.println("Deseja excluir outro produto?\n[1] Sim \n[2] Não");
							sairMenu = sc.nextInt();
						} while (sairMenu == 1);

						System.out.println("=======================================================================\n");
						break;

					case 3:
						System.out.println(bgverde
								+ "                      PRODUTOS COM BAIXO ESTOQUE                       \n" + limpa);
						r.relatorioProdutosEstoqueMin();
						System.out.println("=======================================================================\n");
						break;

					case 4:
						System.out.println(bgverde
								+ "                             REPOR ESTOQUE                             \n" + limpa);
						p.reporEstoque();
						System.out.println("Os produtos com baixo estoque foram repostos.");
						System.out.println("=======================================================================\n");
						break;

					case 5:
						System.out.println(bgverde
								+ "                             FAZER COMPRA                             \n" + limpa);
						do {
							c.fazerCompra();
							System.out.println(
									"=======================================================================\n");
							System.out.println("Deseja fazer nova compra?\n[1] Sim \n[2] Não");
							sairMenu = sc.nextInt();
						} while (sairMenu == 1);

						System.out.println("=======================================================================\n");
						break;

					case 6:
						System.out.println(bgverde
								+ "                             RELATÓRIO DE COMPRAS                           \n" + limpa);
						r.relatorioCompras();
						System.out.println("=======================================================================\n");
						break;
						
					case 7:
						sairMenu = 3;
						sair = 1;
						break;

					default:
						System.out.println("Entrada inválida \n");
					}
				}
				break;

			case 3:
				System.out.println("\n|                     Usuário" + verde + " gerente " + limpa
						+ "selecionado!                   |");
				System.out.println("|____________________________________________________________________|\n");

				while (sairMenu == 1 || sairMenu == 2) {
					System.out.println(verde + "[1]" + limpa + " Definir margem de lucro \n" + verde + "[2]" + limpa
							+ " Definir estoque mínimo \n" + verde + "[3]" + limpa + " Vizualizar relatórios \n"
							+ vermelho + "[4]" + limpa + " Sair");

					int menuVendedor = sc.nextInt();

					switch (menuVendedor) {
					case 1:
						System.out.println(bgverde
								+ "                          DEFINIR MARGEM DE LUCRO                      \n" + limpa);
						p.definirPorcenLucro();
						sairMenu = 2;
						System.out.println("=======================================================================\n");
						break;

					case 2:
						System.out.println(bgverde
								+ "                          DEFINIR ESTOQUE MÍNIMO                       \n" + limpa);
						p.definirEstoqueMin();
						sairMenu = 2;
						System.out.println("=======================================================================\n");
						break;

					case 3:
						System.out.println(bgverde
								+ "                             RELATÓRIOS                                \n" + limpa);
						System.out.println(verde + "[1]" + limpa + " Produtos cadastrados \n" + verde + "[2]" + limpa
								+ " Produtos com baixo estoque \n" + verde + "[3]" + limpa + " Vendas realizadas \n"
								+ verde + "[4]" + limpa + " Compras realizadas \n" + verde + "[5]" + limpa 
								+ " Clientes \n" + vermelho + "[6]" + limpa + " Sair");
						
						escolha = sc.nextInt();
						switch (escolha) {
						case 1:
							r.relatorioProdutos();
							break;
							
						case 2:
							r.relatorioProdutosEstoqueMin();
							break;
							
						case 3:
							r.relatorioVendas();
							break;
						
						case 4:
							r.relatorioCompras();
							break;
							
						case 5:
							r.relatorioClientes();
							break;
							
						case 6:
							sairMenu = 3;
							sair = 1;
							break;

						default:
							System.out.println("Entrada inválida \n");
						}
						
						sairMenu = 2;
						System.out.println("=======================================================================\n");
						break;

					case 4:
						sairMenu = 3;
						sair = 1;
						break;

					default:
						System.out.println("Entrada inválida \n");
					}

				}
				break;

			case 4:
				System.out.print("|======================================================================|\n");
				System.out.println("|                  Obrigada por usar o" + verde + " E$A" + limpa
						+ "! Volte sempre               |");
				System.out.println("|======================================================================|\n");
				sair = 2;
				break;

			default:
				System.out.println("Entrada inválida");
			}

		}
		sc.close();
	}
}
