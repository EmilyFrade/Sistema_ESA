package application;

import java.util.Scanner;
import java.awt.Color;
import entidades.Caixa;

public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String verde = "\u001B[32m";
        String limpa = "\u001B[0m";
        String vermelho = "\u001B[31m";
        String bgverde = "\u001B[42m";
        Caixa caixa = new Caixa();
        
        int sair = 1;
        int sairMenu = 1, caixaAberto = 0;

        while (sair == 1) {
            sairMenu = 1;
            System.out.println(" _____________________________________________________________________");
            System.out.println("|" + verde + "                       Bem vindo ao E$A - ERP                  " + limpa + "      |");
            System.out.println("|_____________________________________________________________________|");
            System.out.println();
            System.out.println(bgverde +"                          SELECIONAR USUÁRIO                           "+ limpa);
            System.out.println();
            System.out.println(verde + "[1]" + limpa + " Vendedor");
            System.out.println(verde + "[2]" + limpa + " Comprador");
            System.out.println(verde + "[3]" + limpa + " Gerente");
            System.out.println(vermelho + "[4]" + limpa + " Sair do programa");
            int usuario = sc.nextInt();

            switch (usuario) {

                case 1:
                    System.out.println("\n|                     Usuário" + verde + " vendedor " + limpa +"selecionado!                   |");

                    System.out.println("|_____________________________________________________________________|\n");
                    while (sairMenu == 1 || sairMenu == 2 ) {

                        System.out.println(verde +"[1]"+ limpa + " Abrir caixa \n" + verde + "[2]" + limpa
                        		+ " Nova venda \n" + verde +"[3]" + limpa + " Adicionar dinheiro\n" + verde + "[4]" + limpa +
                        		" Fazer sangria\n" + verde + "[5]" + limpa + " Fechar caixa\n" + verde + "[6]" + limpa +" Vizualizar caixa\n" + vermelho + "[7]" + limpa + " Sair");

                        int menuVendedor = sc.nextInt();

                        switch (menuVendedor) {

                            case 1:
                                System.out.println(bgverde +"                              ABRIR CAIXA                              \n"+ limpa);
                                caixa.abrirCaixa();
                                System.out.println("=======================================================================\n");
                                caixaAberto = 1;
                                sairMenu = 2;
                                break;

                            case 2:
                            	 System.out.println(bgverde +"                              NOVA VENDA                               \n"+ limpa);
                                // Nova Venda
                            	if (caixaAberto == 1) {
                                    do {
                                        //novaVenda;
                                        System.out.println("Deseja efetuar outra venda?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                    
                                } else {
                                    System.out.println("O caixa ainda não foi aberto");
                                    sairMenu = 2;
                                }
                            	System.out.println("=======================================================================\n");
                                break;

                            case 3:
                            	System.out.println(bgverde +"                              ADCIONAR DINHEIRO                               \n"+ limpa);
                                if (caixaAberto == 1) {
                                    do {
                                        caixa.adicionarDinheiro();
                                        System.out.println("Deseja adicionar mais dinheiro?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                } else {
                                	
                                    System.out.println("O caixa ainda não foi aberto");
                                    sairMenu = 2;
                                }
                                System.out.println("=======================================================================\n");
                                break;

                            case 4:
                            	System.out.println(bgverde +"                              SANGRIA                               \n"+ limpa);
                                if (caixaAberto == 1) {
                                    do {
                                        caixa.sangria();
                                        System.out.println("Deseja retirar mais dinheiro?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                } else {
                                	
                                    System.out.println("O caixa ainda não foi aberto");
                                    sairMenu = 2;
                                }
                                System.out.println("=======================================================================\n");
                                break;

                            case 5:
                            	System.out.println(bgverde +"                              ABRIR CAIXA                              \n"+ limpa);
                                if (caixaAberto == 1) {
                                   
                                       caixa.fecharCaixa();
                                        sairMenu = 2;
                                } else {
                                	
                                    System.out.println("O caixa já está fechado");
                                    sairMenu = 2;
                                }
                                System.out.println("=======================================================================\n");
                                break;
                            case 6:
                            	System.out.println(bgverde +"                          VIZUALIZAR CAIXA                        \n"+ limpa);
                            	caixa.vizualizarCaixa();
                            	
                            	sairMenu = 2;
                                    
                                    break;
                            case 7:
                                sairMenu = 3;
                                sair = 1;
                                break;
                        }
                    }
                    break; 
                    
                case 2:
                	System.out.println("\n|                     Usuário" + verde + " comprador " + limpa +"selecionado!                   |");

                    System.out.println("|______________________________________________________________________|\n");
                    while (sairMenu == 1 || sairMenu == 2 ) {

                        System.out.println(verde +"[1]"+ limpa + " Cadastrar Produto \n" + verde + "[2]" + limpa
                        		+ " Excluir produto \n" + verde +"[3]" + limpa + " Vizualizar produtos em baixo estoque \n" + verde + "[4]" + limpa +
                        		" Repor estoque\n" + verde + limpa + vermelho + "[5]" + limpa + " Sair");

                        int menuVendedor = sc.nextInt();

                        switch (menuVendedor) {

                            case 1:
                                System.out.println(bgverde +"                              CADASTRAR PRODUTO                              \n"+ limpa);
                                //produto.incluirProduto();
                                System.out.println("=======================================================================\n");
                                do {
                                   
                                    System.out.println("Deseja cadastrar outro produto?\n[1] Sim \n[2] Não");
                                    sairMenu = sc.nextInt();
                                } while (sairMenu == 1);
                                break;

                            case 2:
                            	 System.out.println(bgverde +"                                EXCLUIR PRODUTO                                \n"+ limpa);
                            	//adicionar funçao produto.excluirProduto();
                                    do {
                                        
                                        System.out.println("Deseja excluir outro produto?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                    System.out.println("=======================================================================\n");   
                                    break;

                            case 3:
                            	System.out.println(bgverde +"                              PRODUTOS COM BAIXO ESTOQUE                              \n"+ limpa);
                                        //adicionar relatorio.estoqueBaixo();
                            	 System.out.println("=======================================================================\n"); 
                                    sairMenu = 2;
                                    break;

                            case 4:
                            	System.out.println(bgverde +"                                REPOR ESTOQUE                                 \n"+ limpa);
                                    do {
                                       // adicionar aqui função que repoe o estoque
                                        System.out.println("Deseja repor outro produto?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                    System.out.println("=======================================================================\n"); 

                                break;

                            case 5:
                            	
                            	sairMenu = 3;
                                sair = 1;
                                break;
                  
                    }	
            }
                case 3:
                	
                	System.out.println("\n|                     Usuário" + verde + " gerente " + limpa +"selecionado!                   |");

                    System.out.println("|____________________________________________________________________|\n");
                    while (sairMenu == 1 || sairMenu == 2 ) {

                        System.out.println(verde +"[1]"+ limpa + " Definir margem de lucro \n" + verde + "[2]" + limpa
                        		+ " Vizualizar relatórios \n" + verde +"[3]" + limpa + " Sair \n");

                        int menuVendedor = sc.nextInt();

                        switch (menuVendedor) {

                            case 1:
                                System.out.println(bgverde +"                          DEFINIR MARGEM DE LUCRO                        \n"+ limpa);
                                //Incuir função que define margem de lucro();
                                sairMenu = 2;
                                break;

                            case 2:
                            	System.out.println(bgverde +"                          RELATÓRIOS                        \n"+ limpa);
                            	//adicionar funçao vizuaizar relatorios();
                            	
                            	sairMenu = 2;
                                    
                                    break;

                            case 3:
                                
                            	sairMenu = 3;
                                sair = 1;
                                break;
                                    

                        }	
                    }
            }
        
        }
        sc.close();
    }
}
