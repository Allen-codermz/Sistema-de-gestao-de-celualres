package model.celular;

public class Pais {
	private int codigoPais;
	private String pais;
	private Continente continente;

	public Pais(int codigoPais, String pais) {
		this.codigoPais = codigoPais;
		this.pais = pais;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return pais;
	}

}
