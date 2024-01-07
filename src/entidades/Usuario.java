package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	List<Usuario> users = new ArrayList<>();
	
	private String nome;
	private Integer numeroCelular;
	private String cpf_cnpj;
	private Integer codigo;
	
	public Usuario(String nome, Integer numeroCelular, String cpf_cnpj) {
		this.nome = nome;
		this.numeroCelular = numeroCelular;
		this.cpf_cnpj = cpf_cnpj;
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

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public void incluirUsuario(Usuario user) { 
		users.add(user);
		user.setCodigo(users.indexOf(user) + 1);
	}
}
