public class UnidadeAutonoma extends Imovel {

    private double areaUtil;
    private double areaConstruida;

    public UnidadeAutonoma(String numIPTU, String rua, String numero, String cep, String estado, String cidade,
            String tipo, String utilizacao) {
        super(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao);
        //TODO Auto-generated constructor stub
    }
    
    public double getAreaUtil() {
        return this.areaUtil;
    }

    public void setAreaUtil(double areaUtil) {
        this.areaUtil = areaUtil;
    }

    public double getAreaConstruida() {
        return this.areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }
}
