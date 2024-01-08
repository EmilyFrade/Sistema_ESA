package entidades;

public class DadosClientes {
	public DadosClientes() {}
	
	public void clientesIniciais() {
		Cliente cliente = new Cliente("Emily", "31992859255", "12345678910");
		cliente.incluirCliente(cliente);
		
		cliente = new Cliente("Ana Flávia", "31993353493", "98765432109");
		cliente.incluirCliente(cliente);
		
		cliente = new Cliente("Thiago", "3195008110", "52967483152");
		cliente.incluirCliente(cliente);
	}
}
