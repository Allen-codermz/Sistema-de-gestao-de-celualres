package model.celular;

public class Marca {
	private int codigoMarca;
	private String marca;
	private Fabricante fabricante;

	public Marca(int codigoMarca, String marca) {
		this.codigoMarca = codigoMarca;
		this.marca = marca;
	}

	public Marca(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return  marca;
	}

}
