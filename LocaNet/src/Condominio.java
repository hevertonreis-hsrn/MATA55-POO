public class Condominio extends UnidadeCompartilhada{

    private String itensLazer;

    public Condominio(String numIPTU, String rua, String numero, String cep, String estado, String cidade, String tipo,
            String utilizacao) {
        super(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao);
        //TODO Auto-generated constructor stub
    }
    
    public String getItensLazer() {
        return this.itensLazer;
    }

    public void setItensLazer(String itensLazer) {
        this.itensLazer = itensLazer;
    }
}
