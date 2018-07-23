package modelo.cliente;

import javax.persistence.*;

@Entity
@Table (name ="tb_endereco")
public class Endereco {
    
    @Column(name ="cep")
    private String cep;
    
    @Column(name ="numero")
    private int numero;
    
    @Id
    @Column(name ="tb_cliente_cpf")
    private String clienteCpf;

    public Endereco(String cep, int numero) {
        this.cep = cep;
        this.numero = numero;
    }

    public Endereco() {
    }

    
    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }
    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
