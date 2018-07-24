package modelo.gerente;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.framework.EntidadeGenerica;
import modelo.cliente.Cliente;

@Entity
@Table (name = "tb_gerente")
public class Gerente extends EntidadeGenerica{

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)	
	@Column (name = "id")
	private int id;
	@Column (name = "nome")
	private String nome;
	@Column (name = "fone")
	private String telefone;
	@Column (name = "celular")
	private String celular;
	@Column (name = "email")
	private String email;
	
	@ManyToMany (mappedBy = "gerentes", targetEntity = Cliente.class)
	private Collection<Cliente> clientes;
	
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
