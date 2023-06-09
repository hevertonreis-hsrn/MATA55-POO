import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Imovel implements IAluguel{
    
    private int numIPTU;
    private double valorIPTU;
    private Endereco endereco;
    private String tipo;
    private String utilizacao;
    private Agenda agenda;

    public Imovel(int numIPTU, double valorIPTU, String rua,String numero,String cep,String estado,String cidade,String tipo,String utilizacao){
        this.numIPTU = numIPTU;
        this.valorIPTU = valorIPTU;
        this.endereco = new Endereco(rua, numero, cidade, estado, cep);
        this.tipo = tipo;  
        this.utilizacao = utilizacao;
        this.agenda = new Agenda();
    }

    public Imovel(int numIPTU, double valorIPTU, String rua,String numero,String cep,String tipo,String utilizacao){
        this(numIPTU,valorIPTU,rua,numero,cep,Estados.BA.getUF(),"Salvador",tipo,utilizacao);
    }

    public int getNumIPTU() {
        return this.numIPTU;
    }

    public void setNumIPTU(int numIPTU) {
        this.numIPTU = numIPTU;
    }

    public double getValorIPTU(){
        return this.valorIPTU;
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

    @Override
    public String toString() {

        return "============ Dados do Imóvel ===========\n\n" +
                "IPTU: " + this.getNumIPTU() + "\n" +
                "Valor IPTU: " + this.getValorIPTU() + "\n" +
                "Tipo: " + this.getTipo() + "\n" +
                "Utilização: " + this.getUtilizacao() + "\n\n" +
                this.endereco.toString() + "\n";
    }
    
    public double valorReferencia(){
        return 0;
    };
    
    public boolean adicionarDataDisponivel(String data){
        
        LocalDate d = parseStringData(data);

        if(!this.agenda.compararDatasBloqueado(d)){

            if(!this.agenda.compararDatasAlugado(d)){

                if(!this.agenda.compararDatasDisponivel(d)){
                    this.agenda.setDatasDisponivel(d);
                    this.agenda.ordenarDatasDisponiveis();
                    return true;
                }
                System.out.println("Data já cadastrada!");
                return false;
            }
            System.out.println("O imóvel se encontra [alugado] na data inserida!");
            return false;
        }
        System.out.println("O imóvel se encontra [bloqueado] na data inserida!");
        return false;
    }    

    public boolean adicionarDataAlugado(String data){

        LocalDate d = parseStringData(data);

        if(!this.agenda.compararDatasBloqueado(d)){

            if(!this.agenda.compararDatasAlugado(d)){

                if(!this.agenda.compararDatasDisponivel(d)){
                    System.out.println("O imóvel não se encontra [disponível] na data inserida!");
                    return false;
                } else {
                    this.agenda.removerDataDisponivel(d);
                    this.agenda.setDatasAlugado(d);
                    return true;
                }
            }
            System.out.println("O imóvel se encontra [alugado] na data inserida!");
            return false;
        }
        System.out.println("O imóvel se encontra [bloqueado] na data inserida!");
        return false;

    }

    public boolean adicionarDataBloqueado(String data){

        LocalDate d = parseStringData(data);

        if(!this.agenda.compararDatasBloqueado(d)){

            if(!this.agenda.compararDatasAlugado(d)){

                if(!this.agenda.compararDatasDisponivel(d)){
                    this.agenda.setDatasBloqueado(d);
                    return true;
                } else {
                    this.agenda.removerDataDisponivel(d);
                    this.agenda.setDatasBloqueado(d);
                    return true;
                }
            }
            System.out.println("O imóvel se encontra [alugado] na data inserida!");
            return false;
        }
        System.out.println("Data já cadastrada!");
        return false;
        
    }

    private LocalDate parseStringData(String data) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate d = LocalDate.parse(data, formato);

        return d;
    }

    @Override
    public boolean disponibilidadeImovel(String dataInicial, String dataFinal) {

        LocalDate dI = parseStringData(dataInicial);
        LocalDate dF = parseStringData(dataFinal);

        long intervalo = ChronoUnit.DAYS.between(dI, dF);

        int contador = 0;

        if(this.agenda.compararDatasDisponivel(dI) && this.agenda.compararDatasDisponivel(dF)){

            List<LocalDate> datasDisponiveis = this.agenda.getDatasDisponivel();

            int i = datasDisponiveis.indexOf(dI);
            int parada = (int) (i + intervalo);

            for (; i < parada; i++) {
                ComparadorDeDatas comparador = new ComparadorDeDatas();
                int comparacao = comparador.compare(datasDisponiveis.get(i), dI.plusDays(contador));
                if (comparacao == 0) {
                    contador++;
                }
            }

            if(contador == intervalo){
                return true;
            }
        }
        return false;
    }

    @Override
    public double valorAluguel(String dataInicial, String dataFinal) {
        
        if (dataFinal == null) {
            return this.valorReferencia();
        }

        LocalDate dI = parseStringData(dataInicial);
        LocalDate dF = parseStringData(dataFinal);

        long qtdDias = ChronoUnit.DAYS.between(dI, dF);

        return this.valorReferencia()*qtdDias;
    }
}
