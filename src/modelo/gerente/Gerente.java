package modelo.gerente;

import br.com.framework.EntidadeGenerica;

public class Gerente extends EntidadeGenerica{

	private String nome;
	private String telefone;
	private String celular;
	private String email;
	
	public Gerente(String id, String nome, String telefone, String celular, String email) {
		super(id);
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
