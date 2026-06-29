package model.celular;

public class Celular implements Comparable<Celular>{
	private int codigo;
	private Marca marca;
	private double preco;
	private Fabricante fabricante;
	private int anoDeFabrico;
	

	public Celular(int codigo, double preco, int anoDeFabrico) {

		this.codigo = codigo;
		this.preco = preco;
		this.anoDeFabrico = anoDeFabrico;
	}

	public Celular(String referencia, double preco, int anoDeFabrico) {
		
		this.preco = preco;
		this.anoDeFabrico = anoDeFabrico;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public int getAnoDeFabrico() {
		return anoDeFabrico;
	}

	public void setAnoDeFabrico(int anoDeFabrico) {
		this.anoDeFabrico = anoDeFabrico;
	}

	public int calcularTempo() {
		int anoActual = java.time.Year.now().getValue();
		return anoActual - anoDeFabrico;
	}

	public String toString() {
		return codigo + "-" + marca.getMarca() +  "-" + preco + "-" + fabricante.getFabricante() + "-" + anoDeFabrico + "-"
				+ "-" + calcularTempo();
	}

	public int compareTo(Celular celular) {
		if (this.codigo > celular.codigo)
			return 1;
		if (this.codigo < celular.codigo)
			return -1;
		return 0;
	}
}
