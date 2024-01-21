package entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private Integer qtdCompras = 0;
	private static List<Cliente> clientes = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String nome, String numeroCelular, String cpf_cnpj) {
		super(nome, numeroCelular, cpf_cnpj);
	}

	public Integer getQtdCompras() {
		return qtdCompras;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void adicionarCompra() {
		qtdCompras++;
	}

	public void incluirCliente(Cliente cliente) {
		clientes.add(cliente);
		cliente.setCodigo(clientes.indexOf(cliente) + 1);
	}
}
