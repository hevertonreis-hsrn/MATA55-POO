public class Imovel {
    
    private String numIPTU;
    private Endereco endereco;
    private String tipo; // casa, apto
    private String utilizacao;//campo, praia

    public Imovel(String numIPTU,String rua,String numero,String cep,String estado,String cidade,String tipo,String utilizacao){
        this.numIPTU = numIPTU;
        this.endereco = new Endereco(rua, numero, cidade, estado, cep);
        this.tipo = tipo;  
        this.utilizacao = utilizacao;
    }

    public Imovel(String numIPTU,String rua,String numero,String cep,String tipo,String utilizacao){
        this(numIPTU,rua,numero,cep,Estados.BA.getUF(),"Salvador",tipo,utilizacao);
    }

    public String getNumIPTU() {
        return this.numIPTU;
    }

    public void setNumIPTU(String numIPTU) {
        this.numIPTU = numIPTU;
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

    public String getEndereco() {
        return endereco.toString();
    }

}
