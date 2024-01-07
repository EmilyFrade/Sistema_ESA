package entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
	List<Cliente> clientes = new ArrayList<>();
	
	private Integer qtdCompras = 0;

	public Cliente(String nome, Integer numeroCelular, String cpf_cnpj, Integer qtdCompras) {
		super(nome, numeroCelular, cpf_cnpj);
		this.qtdCompras = qtdCompras;
	}

	public Integer getQtdCompras() {
		return qtdCompras;
	}

	public void adicionarCompra() {
		qtdCompras++;
	}
	
	public void incluirCliente(Cliente cliente) { 
		clientes.add(cliente);
		cliente.setCodigo(users.indexOf(cliente) + 1);
	}
}
