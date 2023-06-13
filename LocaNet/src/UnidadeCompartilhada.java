public class UnidadeCompartilhada extends Imovel{

    private String identificacao;

    public UnidadeCompartilhada(String numIPTU, String rua, String numero, String cep, String estado, String cidade,
            String tipo, String utilizacao) {
        super(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao);
        //TODO Auto-generated constructor stub
    }
    
    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
}
