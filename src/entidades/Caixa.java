package entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Caixa {
	
	Scanner sc = new Scanner(System.in);

	private Double valor;

	public Double getValor() {
		return valor;
	}

	public Integer abrirCaixa(Caixa caixa) {
		try {
			System.out.print("Valor inicial do caixa: ");
			valor = sc.nextDouble();
			System.out.printf("O caixa foi aberto com R$%.2f \n", valor);
			return 1;
		}
		catch(InputMismatchException e) {
			System.out.print("ERRO! Digite apenas números para inserir o valor \n");
			sc.nextLine();
			return 0;
		}
	}
	

	public Double adicionarDinheiro(Double dinheiro) {
		valor += dinheiro;
		return valor;
	}

	public Double sangria() {
		System.out.printf("Valor atual do caixa: %.2f\n", valor);
		System.out.printf("Qual o valor da sangria? ");
		Double sangria = sc.nextDouble();
		
		if(sangria <= valor)
			valor -= sangria;
		else
			System.out.println("O valor que deseja retirar é maior que o disponível");
		System.out.printf("Valor atual do caixa: %.2f ", valor);

		return valor;
	}

	public Integer fecharCaixa() {
		System.out.print("Deseja realmente fechar o caixa (s/n)? ");
		char c = sc.next().charAt(0);

		if (c == 's' || c == 'S') {
			System.out.printf("O caixa foi fechado com R$%.2f \n", valor);

			return 0;
		}

		return 1;
	}

	public void vizualizarCaixa() {
		System.out.printf("Valor atual do caixa: %.2f \n", valor);
	}
	
	
}
