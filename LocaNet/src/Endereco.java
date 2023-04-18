public class Endereco {
    
    private String rua;
    private String numero;    
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String numero, String cidade, String estado, String cep) {
        
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;

    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void atualizaEndereco(String rua,String numero,String cep,String estado,String cidade){
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
    }

    public void atualizaEndereco(String rua,String numero,String cep){
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    @Override
    public String toString() {

        return "============ Endereço ===========\n\n" +
                "Logradouro: " + this.rua + "\n" +
                "Número: " + this.numero + "\n" +
                "CEP: " + this.cep + "\n" +
                "Estado: " + this.estado + "\n" +
                "Cidade: " + this.cidade + "\n\n";
    }
}
