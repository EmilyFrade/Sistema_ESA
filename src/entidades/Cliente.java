package entidades;

public class Cliente extends Pessoa{
	private Integer qtdCompras = 0;
	private String CPF;
	
	public Cliente(String nome, Integer numeroCelular, Integer codigo, String CPF) {
		super(nome, numeroCelular, codigo);
		this.CPF = CPF;
	}

	public Integer getQtdCompras() {
		return qtdCompras;
	}

	public String getCPF() {
		return CPF;
	}
}
