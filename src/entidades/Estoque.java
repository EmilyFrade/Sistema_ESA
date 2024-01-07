package entidades;

public class Estoque {
	public void estoqueInicial() {
		Produto p = new Produto("Sofá 3 lugares", 750.00, 1200.00, 4, "Sofás");
		p.incluirProduto(p);
		
		p = new Produto("Sofá de canto", 1300.00, 2000.00, 5, "Sofás");
		p.incluirProduto(p);
		
		p = new Produto("Sofá-cama 2 lugares", 550.00, 1060.00, 2, "Sofás");
		p.incluirProduto(p);
		
		p = new Produto("Sofá retrátil e reclinável", 810.00, 1799.00, 3, "Sofás");
		p.incluirProduto(p);
		
		p = new Produto("Sofá com chaise 4 lugares", 1500.00, 2692.00, 1, "Sofás");
		p.incluirProduto(p);
		
		p = new Produto("Armário para cozinha 3 portas", 55.00, 190.00, 5, "Armários");
		p.incluirProduto(p);
		
		p = new Produto("Mesa de cabeceira", 120.00, 250.00, 2, "Armários");
		p.incluirProduto(p);
	}
}
