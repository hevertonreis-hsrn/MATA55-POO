public class UnidadeAutonoma extends Imovel {

    private double areaUtil;
    private double areaConstruida;

    public UnidadeAutonoma(int numIPTU, String rua, String numero, String cep, String estado, String cidade,
            String tipo, String utilizacao, double areaUtil, double areaConstruida) {
        super(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao);
        this.areaUtil = areaUtil;
        this.areaConstruida = areaConstruida;
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

    @Override
    public double valorReferencia() {        
        return areaConstruida*15;
    }
}
