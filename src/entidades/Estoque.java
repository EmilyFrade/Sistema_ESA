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
		
		
		p = new Produto("Armario Cozinha 7 Portas e 2 Gavetas Juliete", 178.80, 5, "Armários");
		p.incluirProduto(p);
		
		p = new Produto("Armário Multiuso 2 Portas Ibiza 4099 Móveis Doripel Amarula", 75.96, 2, "Armários");
		p.incluirProduto(p);
		
		p = new Produto("Kit 3 Armários para Escritório com Balcão, Armário e Estante Espresso Móveis", 250.06, 3, "Armários");
		p.incluirProduto(p);
		
		p = new Produto("Armário De Canto Para Escritório Me4132 Tecno Mobili\n", 151.53, 3, "Armários");
		p.incluirProduto(p);
		
		p = new Produto("Armário Estante 2 Portas Vidro Multimóveis Cr25069 Nogal\n", 229.64, 3, "Armários");
		p.incluirProduto(p);
		
		
		p = new Produto("Cama Articulada de Casal 4 Prateleiras 2 Nichos\n", 239.95, 5, "camas");
		p.incluirProduto(p);
		
		p = new Produto("Cama Box Baú Casal em Corino bege com Pistão a gás\n", 226.00, 2, "camas");
		p.incluirProduto(p);
		
		p = new Produto("Cama de Solteiro Conquista Móveis Bia com 2 Prateleiras e 2 Gavetas\n", 279.60, 3, "camas");
		p.incluirProduto(p);
		
		p = new Produto("Cama Casal com 2 Sapateiras e 2 Nichosn\n", 225.00, 3, "camas");
		p.incluirProduto(p);
		
		p = new Produto("Cama Queen em MDP\n", 111.96, 3, "camas");
		p.incluirProduto(p);
	}
}
