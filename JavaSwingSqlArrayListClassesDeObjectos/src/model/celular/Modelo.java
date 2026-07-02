package model.celular;

public class Modelo {
	private int codigoModelo;
	private String modelo;
	private Marca marca;

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

	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return modelo;
	}

}
