package model.celular;

public class Continente {
	private int codigoContinente;
    private String continente;

    public Continente(int codigoContinente, String continente) {
        this.codigoContinente = codigoContinente;
        this.continente = continente;
    }

    public int getCodigoContinente() {
        return codigoContinente;
    }

    public void setCodigoContinente(int codigoContinente) {
        this.codigoContinente = codigoContinente;
    }

    public String continente() {
        return continente;
    }

    public void continente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return continente;
    }

}
