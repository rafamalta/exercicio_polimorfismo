package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ProdutoUsado extends Produto {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataDeFabricacao;

	public ProdutoUsado() {
	}

	public ProdutoUsado(String nome, Double preco, Date dataDeFabricacao) {
		super(nome, preco);
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}

	@Override
	public String etiqueta() {
		return getNome() 								
						+ " (usado) R$ "
						+ String.format("%.2f", getPreco())
						+ " (Data de fabricacao: "
						+ sdf.format(dataDeFabricacao) 
						+ ")";
	}
}
