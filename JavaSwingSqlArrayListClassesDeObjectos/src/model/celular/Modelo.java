package model.celular;

public class Modelo {
	private int codigoModelo;
	private String modelo;

	public Modelo(int codigoModelo, String modelo) {

		this.codigoModelo = codigoModelo;
		this.modelo = modelo;
	}

	public int getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(int codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
