import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    
    public static void menu(){
        System.out.println("\tBem Vindo ao LocaNet! Selecione uma opção abaixo.");
        System.out.println("0. Sair");
        System.out.println("1. Cadastrar Imóvel");
        System.out.println("2. Cadastrar Proprietário");
        System.out.println("Opcao:");
    }

    public static void cadastrarImovel(Scanner entrada, CadastroImoveis cdImoveis) {

        entrada.nextLine();

        System.out.println("Você entrou no método de Cadastro de Imóveis.");

        String numIPTU,rua,numero,cep,cidade;
        String estado = "BA";
        String tipo = "casa";
        String utilizacao = "moradia";

        System.out.println("Informe o IPTU:");
        numIPTU = entrada.nextLine();

        System.out.println("Informe a Rua:");
        rua = entrada.nextLine();

        System.out.println("Informe o Número:");
        numero = entrada.nextLine();

        System.out.println("Informe o CEP:");
        cep = entrada.nextLine();

        boolean estadoValido = false;

        do {
            
            System.out.println("Informe o Estado:");
            String uf = entrada.nextLine();

            for (Estados estados : Estados.values()) {
                if(uf.equals(estados.getUF())){
                    estadoValido = true;
                    estado = estados.getUF();
                    break;
                }
            }

            if (!estadoValido) {
                System.out.println("Estado Inválido!\n");
            }
        } while (!estadoValido);     

        System.out.println("Informe a Cidade:");
        cidade = entrada.nextLine();

        ArrayList<String> tiposImovel = new ArrayList<>();
        for (TipoImovel tipos : TipoImovel.values()) {
            tiposImovel.add(tipos.getTipo());
        }

        boolean tipoValido = false;

        do {

            System.out.println("Informe o Tipo do Imóvel:\n");
            System.out.println("Opções:");                       

            for (int i = 0; i < tiposImovel.size(); i++) {
                System.out.println("["+ i + "] " + tiposImovel.get(i));
            }

            int opt = entrada.nextInt();

            if (opt < 0 || opt >= tiposImovel.size()) {
                System.out.println("Tipo Inválido!\n");
            } else {
                tipo = tiposImovel.get(opt);
                tipoValido = true;
            }
            
        } while (!tipoValido);

        ArrayList<String> utilizacaoImovel = new ArrayList<>();
        for (UtilizacaoImovel utilizacoes : UtilizacaoImovel.values()) {
            utilizacaoImovel.add(utilizacoes.getUtilizacao());
        }

        boolean utilValido = false;

        do {

            System.out.println("Informe a Utilização:\n");
            System.out.println("Opções:");                       

            for (int i = 0; i < utilizacaoImovel.size(); i++) {
                System.out.println("["+ i + "] " + utilizacaoImovel.get(i));
            }

            int opt = entrada.nextInt();

            if (opt < 0 || opt >= utilizacaoImovel.size()) {
                System.out.println("Tipo Inválido!\n");
            } else {
                utilizacao = utilizacaoImovel.get(opt);
                utilValido = true;
            }
            
        } while (!utilValido);

        Imovel m = new Imovel(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao);

        cdImoveis.adicionarImovel(m);

    }

    public static void cadastrarProprietario(Scanner entrada, CadastroProprietario cdProprietario){

        entrada.nextLine();
        boolean estadoValido = false;

        System.out.println("Você entrou no método de Cadastro de Proprietário.");

        String nome,cpf,identidade,rua,numero,cep,cidade;
        String estado = "BA";

        System.out.println("Informe o Nome:");
        nome = entrada.nextLine();

        System.out.println("Informe o CPF:");
        cpf = entrada.nextLine();

        System.out.println("Informe a Identidade:");
        identidade = entrada.nextLine();

        System.out.println("Informe a Rua:");
        rua = entrada.nextLine();

        System.out.println("Informe o Número:");
        numero = entrada.nextLine();

        System.out.println("Informe o CEP:");
        cep = entrada.nextLine();

        do {
            
            System.out.println("Informe o Estado:");
            String uf = entrada.nextLine();

            for (Estados estados : Estados.values()) {
                if(uf.equals(estados.getUF())){
                    estadoValido = true;
                    estado = estados.getUF();
                    break;
                }
            }

            if (!estadoValido) {
                System.out.println("Estado Inválido!\n");
            }
        } while (!estadoValido); 

        System.out.println("Informe a Cidade:");
        cidade = entrada.nextLine();

        Proprietario p = new Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);

        cdProprietario.adicionarProprietario(p);

    }
    
    public static void main(String[] args) {

        CadastroImoveis cdImoveis = new CadastroImoveis();
        CadastroProprietario cdProprietario = new CadastroProprietario();

        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                cadastrarImovel(entrada,cdImoveis);
                break;
                
            case 2:
                cadastrarProprietario(entrada,cdProprietario);
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);

        entrada.close();
    }
}