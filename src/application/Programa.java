package application;

import java.util.Scanner;

import entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Vendedor ve = new Vendedor("Ana", 12, 34, 0.0);
		
		ve.abrirCaixa();
		
		System.out.printf("Valor atual: R$%.2f \n\n", ve.adicionarDinheiro());
		
		System.out.printf("Valor atual: R$%.2f \n\n", ve.sangria());
		
		ve.fecharCaixa();
		
		sc.close();

	}

	//abrir caixa
	//fazer venda
	//adicionar dinheiro ao caixa
	//fazer sangria
	//fechar caixa
}
