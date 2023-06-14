public class UnidadeCompartilhada extends Imovel{

    private String identificacao;
    private Condominio condominio;

    public UnidadeCompartilhada(int numIPTU, String rua, String numero, String cep, String estado, String cidade,
            String tipo, String utilizacao, String identificacao) {
        super(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao);
        this.identificacao = identificacao;
        this.condominio = new Condominio(rua, numero, cep, estado, cidade);
    }
    
    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public void adicionarItemLazer(String itemLazer) {
        this.condominio.adicionarItemLazer(itemLazer);
    }

    public int getQtdItensLazer(){
        return condominio.qtdItensLazer();
    }

    @Override
    public double valorReferencia() {
        int qtdItensLazer = condominio.qtdItensLazer();
        if (qtdItensLazer > 0) {
            return super.getNumIPTU() * qtdItensLazer;
        }

        return super.getNumIPTU()*0.1;
    }
}
