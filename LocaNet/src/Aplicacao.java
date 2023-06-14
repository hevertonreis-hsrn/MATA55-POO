import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Aplicacao {
    
    public static void menu(){
        System.out.println("\tBem Vindo ao LocaNet! Selecione uma opção abaixo.");
        System.out.println("0. Sair");
        System.out.println("1. Cadastrar Imóvel");
        System.out.println("2. Cadastrar Proprietário");
        System.out.println("3. Cadastrar Unidade Autônoma");
        System.out.println("4. Cadastrar Unidade Compartilhada");
        System.out.println("5. Pesquisar Valor de Referência do Aluguel");
        System.out.println("6. Pesquisar Valor de Referência do Aluguel com Sazonalidade");
        System.out.println("Opcao:");
    }

    //Variáveis Globais
    static int numIPTU;
    static String rua,numero,cep,cidade;
    static String estado = "BA";
    static String tipo = "casa";
    static String utilizacao = "moradia";

    public static void entradaImovel(Scanner entrada){

        entrada.nextLine();

        System.out.println("Informe o IPTU (Apenas números):");
        numIPTU = entrada.nextInt();
        entrada.nextLine();

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
    }

    public static void cadastrarImovel(Scanner entrada, CadastroImoveis cdImoveis) {

        System.out.println("Você entrou no método de Cadastro de Imóveis.");

        entradaImovel(entrada);

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
    
    public static void cadastrarUnidadeAutonoma(Scanner entrada, CadastroImoveis cdImoveis) {

        System.out.println("Você entrou no método de Cadastro de Unidades Autônomas.");

        entradaImovel(entrada);

        System.out.println("Informe a Área Útil (m^2) (Ex: 10,25):");
        double areaUtil = entrada.nextDouble();

        System.out.println("Informe a Área Construída (m^2) (Ex: 10,25):");
        double areaConstruida = entrada.nextDouble();

        UnidadeAutonoma ua = new UnidadeAutonoma(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao, areaUtil, areaConstruida);

        cdImoveis.adicionarImovel(ua);

    }

    public static void cadastrarUnidadeCompartilhada(Scanner entrada, CadastroImoveis cdImoveis) {
        
        System.out.println("Você entrou no método de Cadastro de Unidades Compartilhadas.");

        entradaImovel(entrada);

        entrada.nextLine();

        System.out.println("Informe a Identificação:");
        String identificacao = entrada.nextLine();

        UnidadeCompartilhada uc = new UnidadeCompartilhada(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao, identificacao);

        String itemLazer = null;

        do {
            System.out.println("\nInforme um item de lazer:");
            System.out.println("Caso não haja itens de lazer, tecle 'Enter'");
            itemLazer = entrada.nextLine();
            if(!itemLazer.equals("")){
                uc.adicionarItemLazer(itemLazer);
            }    
        } while (!itemLazer.equals(""));

        cdImoveis.adicionarImovel(uc);
    }
    
    private static void valorReferenciaAluguel(Scanner entrada, CadastroImoveis cdImoveis) {
        
        entrada.nextLine();

        System.out.println("Você entrou no método de Pesquisar Valor de Referência do Aluguel");

        System.out.println("Informe o IPTU do Imóvel (Apenas números):");
        numIPTU = entrada.nextInt();
        
        Imovel imovel = cdImoveis.buscarImovel(numIPTU);

        double valorRef = imovel.valorReferencia();

        if(imovel instanceof UnidadeCompartilhada){
            UnidadeCompartilhada uc = (UnidadeCompartilhada) imovel;
            if(uc.getQtdItensLazer() == 0){
                valorRef -= valorRef*0.1;
            }
        }

        System.out.println("O valor de referência para o aluguel é:");
        
        System.out.println("R$ "+ valorRef + "\n");
    }
    
    private static void valorReferenciaAluguelComSazonalidade(Scanner entrada, CadastroImoveis cdImoveis) {
        
        entrada.nextLine();

        System.out.println("Você entrou no método de Pesquisar Valor de Referência do Aluguel com Sazonalidade");

        System.out.println("Informe o IPTU do Imóvel (Apenas números):");
        numIPTU = entrada.nextInt();
        
        Imovel imovel = cdImoveis.buscarImovel(numIPTU);

        double valorRef = imovel.valorReferencia();

        ArrayList<String> periodos = new ArrayList<>();
        for (Periodos p : Periodos.values()) {
            periodos.add(p.getPeriodo());
        }

        boolean periodoValido = false;

        do {

            System.out.println("\nInforme o Período.\n");
            System.out.println("Opções:");                       

            for (int i = 0; i < periodos.size(); i++) {
                System.out.println("["+ i + "] " + periodos.get(i));
            }

            int opt = entrada.nextInt();

            if (opt < 0 || opt >= periodos.size()) {
                System.out.println("Período Inválido!\n");
            }else if(opt == 0){
                periodoValido = true;
            } else {
                Optional<Periodos> prd = Periodos.buscarIndicePorPeriodo(periodos.get(opt));
                int indice = prd.get().getIndice();
                valorRef += valorRef*indice;
                periodoValido = true;
            }
            
        } while (!periodoValido);

        System.out.println("O valor de referência para o aluguel é:");
        
        System.out.println("R$ "+ valorRef + "\n");
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

            case 3:
                cadastrarUnidadeAutonoma(entrada, cdImoveis);
                break;

            case 4:
                cadastrarUnidadeCompartilhada(entrada, cdImoveis);
                break;

            case 5:
                valorReferenciaAluguel(entrada, cdImoveis);
                break;

            case 6:
                valorReferenciaAluguelComSazonalidade(entrada, cdImoveis);
                break;
            }
        } while(opcao != 0);

        entrada.close();
    }
}