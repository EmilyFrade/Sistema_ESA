package entidades;

public class Caixa {
	private Double valor;
	
	public Caixa() {}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public void adicionarDinheiro(Double valor) {
		this.valor += valor;
	}
	
	public void sangria(Double valor) {
		this.valor -= valor;
	}
}
