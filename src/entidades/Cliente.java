package entidades;

public class Cliente extends Pessoa{
	private Integer qtdCompras = 0;
	private String CPF;
	
	public Cliente(String nome, Integer numeroCelular, Integer codigo, Integer qtdCompras, String CPF) {
		super(nome, numeroCelular, codigo);
		this.qtdCompras = qtdCompras;
		this.CPF = CPF;
	}

	public Integer getQtdCompras() {
		return qtdCompras;
	}

	public String getCPF() {
		return CPF;
	}
}
