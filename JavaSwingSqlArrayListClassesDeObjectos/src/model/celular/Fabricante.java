package model.celular;

public class Fabricante{
	private int codigoFabricante;
	private String fabricante;
	private String paisDeOrigem;

	public Fabricante(int codigoFabricante, String fabricante, String paisDeOrigem) {

		this.codigoFabricante = codigoFabricante;
		this.fabricante = fabricante;
		this.paisDeOrigem = paisDeOrigem;
	}

	public Fabricante(String string) {
		// TODO Auto-generated constructor stub
	}

	public Fabricante(int codigoLog, String usuario, String accao, String dataAccao) {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoFabricante() {
		return codigoFabricante;
	}

	public void setCodigoFabricante(int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

}
