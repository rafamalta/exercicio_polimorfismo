package entities;

public final class ProdutoImportado extends Produto {

	private Double taxaDaAlfandega;

	public ProdutoImportado() {
	}

	public ProdutoImportado(String nome, Double preco, Double taxaDaAlfandega) {
		super(nome, preco);
		this.taxaDaAlfandega = taxaDaAlfandega;
	}

	public Double getTaxaDaAlfandega() {
		return taxaDaAlfandega;
	}

	public void setTaxaDaAlfandega(Double taxaDaAlfandega) {
		this.taxaDaAlfandega = taxaDaAlfandega;
	}

	public Double precoTotal() {
		return getPreco() + taxaDaAlfandega;
	}

	@Override
	public String etiqueta() {
		return getNome() 
						+ " R$ " + String.format("%.2f", precoTotal())
						+" (taxa alfandegaria: R$ "
						+ String.format("%.2f", taxaDaAlfandega)
						+ ")";
	}
}
