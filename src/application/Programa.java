package application;

import java.util.Scanner;

import entidades.Vendedor;

public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vendedor ve = new Vendedor("Ana", 12, 34, 0.0);
        int sair = 1;
        int sairMenu = 1, caixaAberto = 0;

        while (sair == 1) {
            sairMenu = 1;

            System.out.println("Selecione o usuário:");
            System.out.println("[1] Vendedor");
            System.out.println("[2] Comprador");
            System.out.println("[3] Gerente");
            System.out.println("[4] Sair do programa");
            int usuario = sc.nextInt();

            switch (usuario) {

                case 1:
                    System.out.println("Usuário vendedor selecionado!\n");

                    while (sairMenu == 1 || sairMenu == 2 ) {

                        System.out.println("Escolha a opção desejada:\n");
                        System.out.println("[1] Abrir caixa \n[2] Nova venda \n[3] Adicionar dinheiro\n[4] Fazer sangria\n[5] Fechar caixa\n[6] Sair");

                        int menuVendedor = sc.nextInt();

                        switch (menuVendedor) {

                            case 1:
                                ve.abrirCaixa();
                                caixaAberto = 1;
                                sairMenu = 2;
                                break;

                            case 2:
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
                                break;

                            case 3:
                                if (caixaAberto == 1) {
                                    do {
                                        ve.adicionarDinheiro();
                                        System.out.println("Deseja adicionar mais dinheiro?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                } else {
                                	
                                    System.out.println("O caixa ainda não foi aberto");
                                    sairMenu = 2;
                                }
                                break;

                            case 4:
                                if (caixaAberto == 1) {
                                    do {
                                        ve.sangria();
                                        System.out.println("Deseja retirar mais dinheiro?\n[1] Sim \n[2] Não");
                                        sairMenu = sc.nextInt();
                                    } while (sairMenu == 1);
                                } else {
                                	
                                    System.out.println("O caixa ainda não foi aberto");
                                    sairMenu = 2;
                                }
                                break;

                            case 5:
                                if (caixaAberto == 1) {
                                   
                                       ve.fecharCaixa();
                                        sairMenu = 2;
                                } else {
                                	
                                    System.out.println("O caixa já está fechado");
                                    sairMenu = 2;
                                }
                                break;

                            case 6:
                                sairMenu = 3;
                                sair = 1;
                                break;
                        }
                    }
                    break; 
            }
        }
        sc.close();
    }
}
