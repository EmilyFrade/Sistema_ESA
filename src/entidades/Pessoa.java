package entidades;

public class Pessoa {
	private String nome;
	private Integer numeroCelular;
	private Integer codigo;
	
	public Pessoa(String nome, Integer numeroCelular, Integer codigo) {
		this.nome = nome;
		this.numeroCelular = numeroCelular;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Integer getCodigo() {
		return codigo;
	}
}
