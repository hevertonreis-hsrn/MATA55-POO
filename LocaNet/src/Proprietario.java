public class Proprietario {
    
    private String nome;
    private String cpf;
    private String identidade;
    private Endereco endereco;

    public Proprietario(String nome,String cpf,String identidade,String rua,String numero,String cep,String estado,String cidade){
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.endereco = new Endereco(rua,numero,cidade,estado,cep);
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

    public String getEndereco() {
        return endereco.toString();
    }

    public void atualizaEndereco(String rua,String numero,String cep,String estado,String cidade){
        endereco.atualizaEndereco(rua, numero, cep, estado, cidade);
    }

    public void atualizaEndereco(String rua,String numero,String cep){
        endereco.atualizaEndereco(rua, numero, cep);
    }

}
