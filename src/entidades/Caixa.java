package entidades;


import java.util.InputMismatchException;
import java.util.Scanner;

import application.Programa;

public class Caixa {
	
	Scanner sc = new Scanner(System.in);

	private Double valor;

	public Double getValor() {
		return valor;
	}

	
	@SuppressWarnings("finally")
	public Integer abrirCaixa(Caixa caixa) {
		int c = 0;
		
		try {
			sc.nextLine();
			System.out.print("Valor inicial do caixa: ");
			Double v = sc.nextDouble();
			valor = v;	
		}
		catch(InputMismatchException e) {
			System.out.print("ERRO! Digite apenas numeros para inserir o valor \n");
			c = 1;
			
		}
		
		finally{
			if(c == 0) {
				System.out.printf("O caixa foi aberto com R$%.2f \n\n", valor);
				return 1;
			}else {
				return 0;
			}
			
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
