package entidades;

import java.util.Scanner;

public class Vendedor extends Pessoa {
	Scanner sc = new Scanner(System.in);
	
	private Caixa valor = new Caixa();
	
	public Vendedor(String nome, Integer numeroCelular, Integer codigo, Double valor) {
		super(nome, numeroCelular, codigo);
		this.valor.setValor(valor);
	}
	
	public Integer abrirCaixa() {
		System.out.print("Valor inicial do caixa: ");
		Double v = sc.nextDouble();
		this.valor.setValor(v);
		
		System.out.printf("O caixa foi aberto com R$%.2f \n\n", this.valor.getValor());

		return 1;
	}
	
	public Double adicionarDinheiro() {
		System.out.print("Qual o valor deseja adicionar? ");
		Double dinheiro = sc.nextDouble();
		valor.adicionarDinheiro(dinheiro);
		
		return valor.getValor();
	}
	
	public Double sangria() {
		System.out.print("Qual o valor da sangria? ");
		Double sangria = sc.nextDouble();
		valor.sangria(sangria);
		
		return valor.getValor();
	}
	
	public Integer fecharCaixa() {
		System.out.print("Deseja realmente fechar o caixa? ");
		char c = sc.next().charAt(0);
		
		if (c == 's' || c == 'S') {
			System.out.printf("O caixa foi fechado com R$%.2f \n\n", this.valor.getValor());
			return 0;
		}
		
		return 1;
	}
}
