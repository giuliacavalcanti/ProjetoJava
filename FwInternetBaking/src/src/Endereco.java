package src;

public class Endereco {
	private String rua;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	private Endereco(String rua, String bairro, String cep, String cidade, String estado, String pais) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	
}
