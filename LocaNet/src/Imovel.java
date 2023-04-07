public class Imovel {
    
    private String numIPTU;
    private String rua;
    private String numero;
    private String cep;
    private String estado;
    private String cidade;
    private String tipo; // casa, apto
    private String utilizacao;//campo, praia

    public Imovel(
        String numIPTU,
        String rua,
        String numero,
        String cep,
        String estado,
        String cidade,
        String tipo, 
        String utilizacao
    ){
        this.numIPTU = numIPTU;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade; 
        this.tipo = tipo;  
        this.utilizacao = utilizacao;
    }

    public Imovel(
        String numIPTU,
        String rua,
        String numero,
        String cep,
        String tipo, 
        String utilizacao
    ){
        this(
            numIPTU,
            rua,
            numero,
            cep,
            "Bahia",
            "Salvador",
            tipo,  
            utilizacao);
    }

    public String getNumIPTU() {
        return this.numIPTU;
    }

    public void setNumIPTU(String numIPTU) {
        this.numIPTU = numIPTU;
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

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUtilizacao() {
        return this.utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

}
