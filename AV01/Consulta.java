//Heverton Reis - M218115975
public class Consulta {
    
    String nomePaciente;
    String cpf;
    int idade;
    String dataHoraConsulta;
    boolean realizada;
    String diagnostico;
    String receita;

    //Questão 1 - item b)i)
    public Consulta(String nomePaciente, String cpf, int idade, String dataHoraConsulta, boolean realizada) {
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.idade = idade;
        this.dataHoraConsulta = dataHoraConsulta;
        this.realizada = realizada;
        this.diagnostico = null;
        this.receita = null;
    }

    //Questão 1 - item b)ii)
    public Consulta(String nomePaciente, String cpf, int idade, String dataHoraConsulta, String diagnostico, String receita) {
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.idade = idade;
        this.dataHoraConsulta = dataHoraConsulta;
        this.realizada = true;
        this.diagnostico = diagnostico;
        this.receita = receita;
    }

    //Questão 2 - item a)
    public String getDataHoraConsulta() {
        return this.dataHoraConsulta;
    }

    //Questão 3
    public boolean getRealizada() {
        return this.realizada;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome do Paciente: " + this.nomePaciente + "\n" +
                "CPF: " + this.cpf + "\n" +
                "Idade: " + this.idade + "\n" +
                "Data: " + this.dataHoraConsulta + "\n" +
                "Diagnóstico: " + this.diagnostico + "\n" + 
                "Receita: " + this.receita + "\n";
    }

}
