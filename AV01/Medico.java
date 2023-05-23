//Heverton Reis - M218115975
import java.util.ArrayList;
import java.util.List;

public class Medico {
    
    int crm;
    String nome;
    int numSala;
    List<Consulta> consultas;
    
    //Questão 1 - item a)i)
    public Medico(int crm, String nome, int numSala) {
        this.crm = crm;
        this.nome = nome;
        this.numSala = numSala;
        this.consultas = new ArrayList<Consulta>();
    }

    //Questão 1 - item a)ii)
    public Medico(int crm, String nome) {
        this(crm, nome, 0);
    }

    //Questão 2 - item a)
    public boolean adicionarConsulta(Consulta novaConsulta){

        boolean choqueHorario = false;

        for (Consulta consulta : this.consultas) {
            if(consulta.getDataHoraConsulta().equals(novaConsulta.getDataHoraConsulta())){
                choqueHorario = true;
            }
        }

        if(!choqueHorario){
            this.consultas.add(novaConsulta);
            return true;
        }

        return false;
    }

    //Questão 2 - item b)i)
    public boolean removerConsulta(Consulta consultaARemover){

        for (Consulta consulta : this.consultas) {
            if(consulta.equals(consultaARemover)){
                this.consultas.remove(consultaARemover);
                return true;
            }
        }

        return false;
    }

    //Questão 2 - item b)ii)
    public boolean removerConsulta(String dataHoraConsulta){

        int index = 0;

        for (Consulta consulta : this.consultas) {
            if(consulta.getDataHoraConsulta().equals(dataHoraConsulta)){
                this.consultas.remove(index);
                return true;
            }
            index++;
        }

        return false;
    }

    //Questão 3 - itens a e b
    public void listarConsultas(boolean realizada){

        if (realizada) {
            for (Consulta consulta : this.consultas) {
                if (consulta.getRealizada() == true) {
                    System.out.println(consulta.toString());
                }
            }
        } else {
            for (Consulta consulta : this.consultas) {
                if (consulta.getRealizada() == false) {
                    System.out.println(consulta.toString());
                }
            }
        }
    }

    //Questão 3 - itens c
    public void listarConsultas(){

        for (Consulta consulta : this.consultas) {
            System.out.println(consulta.toString());
        }
    }


}
