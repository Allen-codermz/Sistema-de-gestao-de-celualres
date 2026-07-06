package model.celular;

public class CadastroUser {

	private int codigoUsuario;
	private String nome;
	private String apelido;
	private String username;
	private String perfil;
	private String senha;
	private String senhaInicial;
	
	public CadastroUser() {
		
	}

	public CadastroUser(int codigoUsuario, String nome, String apelido, String username,String perfil, String senha) {
	
		this.codigoUsuario = codigoUsuario;
		this.nome = nome;
		this.apelido = apelido;
		this.username = username;
		this.perfil = perfil;
		this.senha = senha;
	}

	

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaInicial() {
		return senhaInicial;
	}

	public void setSenhaInicial(String senhaInicial) {
		this.senhaInicial = senhaInicial;
	}

}