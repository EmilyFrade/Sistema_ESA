package entidades;

import java.util.Scanner;

public class Caixa {
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public Integer abrirCaixa() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Valor inicial do caixa: ");
		Double v = sc.nextDouble();
		valor = v;
		
		System.out.printf("O caixa foi aberto com R$%.2f \n\n", valor);
		
		sc.close();
		return 1;
	}
	
	public Double adicionarDinheiro() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual o valor deseja adicionar? ");
		Double dinheiro = sc.nextDouble();
		valor += dinheiro;
		System.out.printf("Valor atual do caixa: %.2f", valor);
		
		sc.close();
		return valor;
	}
	
	public Double sangria() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual o valor da sangria? ");
		Double sangria = sc.nextDouble();
		valor -= sangria;
		System.out.printf("Valor atual do caixa: %.2f ", valor);
		
		sc.close();
		return valor;
	}
	
	public Integer fecharCaixa() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Deseja realmente fechar o caixa? (s/n)");
		char c = sc.next().charAt(0);
		
		if (c == 's' || c == 'S') {
			System.out.printf("O caixa foi fechado com R$%.2f \n\n", valor);
			sc.close();
			
			return 0;
		}
		
		sc.close();
		return 1;
	}
	
	public void vizualizarCaixa() {
		System.out.printf("Valor atual do caixa: %.2f \n", valor);
	}
}

