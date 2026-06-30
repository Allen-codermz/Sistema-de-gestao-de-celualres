package model.celular;

public class Cor {
	private int codigoCor;
	private String cor;
	private String descricao;

	public Cor(int codigoCor, String cor) {

		this.codigoCor = codigoCor;
		this.cor = cor;
		this.descricao = "A carregar";
	}

	public Cor(int codigoCor, String cor, String descricao) {
		this.codigoCor = codigoCor;
		this.cor = cor;
		this.descricao = descricao;
	}

	public int getCodigoCor() {
		return codigoCor;
	}

	public void setCodigoCor(int codigoCor) {
		this.codigoCor = codigoCor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
