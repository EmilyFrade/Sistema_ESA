package entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
	protected List<Cliente> clientes = new ArrayList<>();
	
	private Integer qtdCompras = 0;

	public Cliente(String nome, String numeroCelular, String cpf_cnpj) {
		super(nome, numeroCelular, cpf_cnpj);
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
