public class Proprietario {
    
    private String nome;
    private String cpf;
    private String identidade;
    private String rua;
    private String numero;
    private String cep;
    private String estado;
    private String cidade;

    public Proprietario(
        String nome,
        String cpf,
        String identidade,
        String rua,
        String numero,
        String cep,
        String estado,
        String cidade
    ){
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return this.identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getRua() {
        return this.rua;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getCep() {
        return this.cep;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void atualizaEndereco(
        String rua, 
        String numero,
        String cep, 
        String estado,
        String cidade
    ){
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
    }

    public void atualizaEndereco(
        String rua, 
        String numero,
        String cep
    ){
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

}
