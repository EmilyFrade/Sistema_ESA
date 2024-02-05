package entidades;

public class Estoque {
	public void estoqueInicial() {
		Produto p = new Produto("Sofá 3 lugares", 480.00, 4, "Sofás");
		p.incluirProduto(p);

		p = new Produto("Sofá de canto", 800.00, 5, "Sofás");
		p.incluirProduto(p);

		p = new Produto("Sofá-cama 2 lugares", 424.00, 2, "Sofás");
		p.incluirProduto(p);

		p = new Produto("Sofá retrátil e reclinável", 719.60, 3, "Sofás");
		p.incluirProduto(p);

		p = new Produto("Sofá com chaise 4 lugares", 1076.80, 1, "Sofás");
		p.incluirProduto(p);

		p = new Produto("Armario Cozinha 7 Portas", 178.80, 5, "Armários");
		p.incluirProduto(p);

		p = new Produto("Armário Multiuso 2 Portas", 75.96, 2, "Armários");
		p.incluirProduto(p);

		p = new Produto("Armários para Escritório", 250.06, 3, "Armários");
		p.incluirProduto(p);

		p = new Produto("Armário De Canto Escritório", 151.53, 3, "Armários");
		p.incluirProduto(p);

		p = new Produto("Armário Estante 2 Portas", 229.64, 3, "Armários");
		p.incluirProduto(p);

		p = new Produto("Cama Articulada de Casal", 239.95, 5, "Camas");
		p.incluirProduto(p);

		p = new Produto("Cama Box Baú Casal", 226.00, 2, "Camas");
		p.incluirProduto(p);

		p = new Produto("Cama de Solteiro 2 Gavetas", 279.60, 3, "Camas");
		p.incluirProduto(p);

		p = new Produto("Cama Casal com 2 Sapateiras", 225.00, 3, "Camas");
		p.incluirProduto(p);

		p = new Produto("Cama Queen", 111.96, 3, "Camas");
		p.incluirProduto(p);
	}
}
