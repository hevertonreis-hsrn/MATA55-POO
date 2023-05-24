import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Imovel {
    
    private String numIPTU;
    private Endereco endereco;
    private String tipo; // casa, apto
    private String utilizacao;//campo, praia
    private Agenda agenda;

    public Imovel(String numIPTU,String rua,String numero,String cep,String estado,String cidade,String tipo,String utilizacao){
        this.numIPTU = numIPTU;
        this.endereco = new Endereco(rua, numero, cidade, estado, cep);
        this.tipo = tipo;  
        this.utilizacao = utilizacao;
        this.agenda = new Agenda();
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

    @Override
    public String toString() {

        return "============ Dados do Imóvel ===========\n\n" +
                "IPTU: " + this.getNumIPTU() + "\n" +
                "Tipo: " + this.getTipo() + "\n" +
                "Utilização: " + this.getUtilizacao() + "\n\n" +
                this.endereco.toString() + "\n";
    }    
    
    public boolean adicionarDataDisponivel(String data){
        
        LocalDate d = parseStringData(data);

        if(!this.agenda.compararDatasBloqueado(d)){

            if(!this.agenda.compararDatasAlugado(d)){

                if(!this.agenda.compararDatasDisponivel(d)){
                    this.agenda.setDatasDisponivel(d);
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
}
