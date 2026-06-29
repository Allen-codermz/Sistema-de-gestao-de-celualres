package model.celular;

public class Log {
	private int codigoLog;
	private String usuario;
	private String perfil;
	private String accao;
	private String dataAccao;

	public Log(int codigoLog, String usuario,String perfil, String accao, String dataAccao) {
		
	
		this.codigoLog = codigoLog;
		this.usuario = usuario;
		this.perfil = perfil;
		this.accao = accao;
		this.dataAccao = dataAccao;
	}

	public int getCodigoLog() {
		return codigoLog;
	}

	public void setCodigoLog(int codigoLog) {
		this.codigoLog = codigoLog;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getAccao() {
		return accao;
	}

	public void setAccao(String accao) {
		this.accao = accao;
	}

	public String getDataAccao() {
		return dataAccao;
	}

	public void setDataAccao(String dataAccao) {
		this.dataAccao = dataAccao;
	}

}
