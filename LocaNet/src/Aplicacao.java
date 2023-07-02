import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Aplicacao {
    
    public static void menu(){
        System.out.println("\tBem Vindo ao LocaNet! Selecione uma opção abaixo.");
        System.out.println("0. Sair");
        System.out.println("1. Cadastrar Imóvel");
        System.out.println("2. Cadastrar Proprietário");
        System.out.println("3. Associar Imóvel à Proprietário");
        System.out.println("4. Pesquisar Valor de Referência do Aluguel");
        System.out.println("5. Pesquisar Valor de Referência do Aluguel com Sazonalidade");
        System.out.println("6. Adicionar Data Disponível para Aluguel");
        System.out.println("7. Verificar Disponibilidade para Aluguel");
        System.out.println("8. Verificar Valor do Aluguel");
        System.out.println("Opcao:");
    }

    //Variáveis Globais
    static int numIPTU;
    static double valorIPTU;
    static String rua,numero,cep,cidade;
    static String estado = "BA";
    static String tipo = "casa";
    static String utilizacao = "moradia";

    public static void entradaImovel(Scanner entrada, CadastroImoveis cdImoveis) throws ImovelExistenteException{

        entrada.nextLine();

        System.out.println("Informe o IPTU (Apenas números):");
        numIPTU = entrada.nextInt();

        Imovel imovel = cdImoveis.buscarImovel(numIPTU);

        if (imovel == null) {

            System.out.println("Informe o valor do IPTU (Ex: 123,45):");
            valorIPTU = entrada.nextDouble();

            entrada.nextLine();

            entradaEndereco(entrada);

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
        } else {
            throw new ImovelExistenteException("Já existe um Imóvel cadastrado com este IPTU!\n");
        }
    }

    private static void entradaEndereco(Scanner entrada) {

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

            uf = uf.toUpperCase();

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
    }

    public static void cadastrarImovel(Scanner entrada, CadastroImoveis cdImoveis) {

        System.out.println("Você entrou no método de Cadastro de Imóveis.");
        System.out.println("Que tipo de imóvel deseja cadastrar?");
        System.out.println("[0] Unidade Autônoma");
        System.out.println("[1] Unidade Compartilhada");

        int opcao = entrada.nextInt();

        if (opcao == 0) {
            cadastrarUnidadeAutonoma(entrada, cdImoveis);            
        } else if(opcao == 1){
            cadastrarUnidadeCompartilhada(entrada, cdImoveis);
        } else {
            System.out.println("Opção Inválida!");
        }

    }

    public static void associarImovelProprietario(Scanner entrada, CadastroImoveis cdImoveis, CadastroProprietario cdProprietario){

        entrada.nextLine();

        System.out.println("Você entrou no método de Associar Imóvel à Proprietário.");

        System.out.println("Informe o CPF do Proprietário (Ex: 012.345.678-90):");
        String cpf = entrada.nextLine();
        
        Proprietario proprietario = cdProprietario.buscarProprietario(cpf);

        if (proprietario == null) {
            System.out.println("Proprietário Não Encontrado.");
        } else {
            System.out.println("Informe o IPTU do Imóvel (Apenas números):");
            numIPTU = entrada.nextInt();
        
            Imovel imovel = cdImoveis.buscarImovel(numIPTU);

            if (imovel == null) {
                System.out.println("Imóvel não encontrado.");
                System.out.println("Cadastre o Imóvel e adicione aos registros do Proprietário posteriormente.\n");
            }else{
                proprietario.adicionarImovel(imovel);                
                System.out.println("Imóvel Associado!");
            }
        }
    }

    public static void cadastrarProprietario(Scanner entrada, CadastroProprietario cdProprietario, CadastroImoveis cdImoveis) throws ProprietarioExistenteException{

        entrada.nextLine();

        System.out.println("Você entrou no método de Cadastro de Proprietário.");

        String nome,cpf,identidade;

        System.out.println("Informe o Nome:");
        nome = entrada.nextLine();

        System.out.println("Informe o CPF:");
        cpf = entrada.nextLine();

        Proprietario proprietario = cdProprietario.buscarProprietario(cpf);

        if (proprietario == null) {
            System.out.println("Informe a Identidade:");
            identidade = entrada.nextLine();

            entradaEndereco(entrada);

            Proprietario p = new Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);

            System.out.println("Deseja adicionar um Imóvel?");
            System.out.println("[0] NÃO");
            System.out.println("[1] SIM");

            int opcao = entrada.nextInt();

            if (opcao == 0) {
                System.out.println("Tudo bem, é possível adicionar depois através do menu.");            
            } else if(opcao == 1){
                System.out.println("Primeiro vamos verificar se o Imóvel já existe em nossos registros.");
                System.out.println("Informe o IPTU do Imóvel (Apenas números):");
                numIPTU = entrada.nextInt();
            
                Imovel imovel = cdImoveis.buscarImovel(numIPTU);

                if (imovel == null) {
                    System.out.println("Imóvel não encontrado.");
                    System.out.println("Cadastre o Imóvel e adicione aos registros do Proprietário posteriormente.");
                }else{
                    p.adicionarImovel(imovel);
                    System.out.println("Imóvel Adicionado!");
                }
            }

            cdProprietario.adicionarProprietario(p);
            System.out.println("Proprietário Cadastrado!\n");
        } else {
            throw new ProprietarioExistenteException("Já existe um Proprietário cadastrado com este CPF!\n");
        }

    }
    
    public static void cadastrarUnidadeAutonoma(Scanner entrada, CadastroImoveis cdImoveis) {

        System.out.println("Você entrou no método de Cadastro de Unidades Autônomas.");

        try {
            entradaImovel(entrada, cdImoveis);
            System.out.println("Informe a Área Útil (m^2) (Ex: 10,25):");
            double areaUtil = entrada.nextDouble();

            System.out.println("Informe a Área Construída (m^2) (Ex: 10,25):");
            double areaConstruida = entrada.nextDouble();

            UnidadeAutonoma ua = new UnidadeAutonoma(numIPTU, valorIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao, areaUtil, areaConstruida);

            cdImoveis.adicionarImovel(ua);
        } catch (ImovelExistenteException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void cadastrarUnidadeCompartilhada(Scanner entrada, CadastroImoveis cdImoveis) {
        
        System.out.println("Você entrou no método de Cadastro de Unidades Compartilhadas.");

        try {
            entradaImovel(entrada, cdImoveis);

            entrada.nextLine();

            System.out.println("Informe a Identificação:");
            String identificacao = entrada.nextLine();

            UnidadeCompartilhada uc = new UnidadeCompartilhada(numIPTU, valorIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao, identificacao);

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
        } catch (ImovelExistenteException e) {
            System.out.println(e.getMessage());
        }

        
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

        valorRef = retornaIndiceSazonalidade(entrada, valorRef);

        System.out.println("O valor de referência para o aluguel é:");
        
        System.out.println("R$ "+ valorRef + "\n");
    }

    private static double retornaIndiceSazonalidade(Scanner entrada, double valorRef) {
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
        return valorRef;
    }
    
    private static void adicionarDataDisponivel(Scanner entrada, CadastroImoveis cdImoveis) {
        
        entrada.nextLine();

        System.out.println("Você entrou no método de Adicionar Data Disponível para Aluguel");

        System.out.println("Informe o IPTU do Imóvel (Apenas números):");
        numIPTU = entrada.nextInt();
        
        Imovel imovel = cdImoveis.buscarImovel(numIPTU);

        System.out.println("Deseja adicionar 1 (uma) ou mais Datas? Selecione uma opção:");
        System.out.println("[0] uma Data");
        System.out.println("[1] um intervalo de Datas");

        entrada.nextLine();

        int opcao = entrada.nextInt();
        boolean cadastrado;

        if (opcao == 0) {
            System.out.println("Informe um valor para a Data");
            System.out.println("Ex: 15/04/1998");

            entrada.nextLine();
        
            String data = entrada.nextLine();

            cadastrado = imovel.adicionarDataDisponivel(data);

            if (cadastrado) {
                System.out.println("Data cadastrada!");
            }
        } else if(opcao == 1){
            System.out.println("Informe um valor para a Data Inicial");
            System.out.println("Ex: 15/04/1998");

            entrada.nextLine();
        
            String data = entrada.nextLine();

            LocalDate dataInicial = parseStringData(data);

            System.out.println("Informe um valor para a Data Final");
            System.out.println("Ex: 15/04/1998");

            data = entrada.nextLine();

            LocalDate dataFinal = parseStringData(data);

            long intervalo = ChronoUnit.DAYS.between(dataInicial, dataFinal);

            for (int i = 0; i <= intervalo; i++) {
                data = dataInicial.plusDays(i).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                imovel.adicionarDataDisponivel(data);
            }
        } else {
            System.out.println("Opção inválida!");
        }

    }

    private static void verificarDisponibilidade(Scanner entrada, CadastroImoveis cdImoveis) {
        entrada.nextLine();

        System.out.println("Você entrou no método de Verificar Disponibilidade para Aluguel");

        System.out.println("Informe o IPTU do Imóvel (Apenas números):");
        numIPTU = entrada.nextInt();
        
        Imovel imovel = cdImoveis.buscarImovel(numIPTU);

        System.out.println("Informe um valor para a Data Inicial");
        System.out.println("Ex: 15/04/1998");

        entrada.nextLine();
        
        String dataInicial = entrada.nextLine();

        System.out.println("Informe um valor para a Data Final");
        System.out.println("Ex: 15/04/1998");
        
        String dataFinal = entrada.nextLine();

        boolean disponivel = imovel.disponibilidadeImovel(dataInicial, dataFinal);

        if (disponivel) {
            System.out.println("O imóvel se encontra disponível no intervalo.\n");
        }else{
            System.out.println("O imóvel não se encontra disponível no intervalo.\n");
        }
    }

    private static void consultarValorAluguel(Scanner entrada, CadastroImoveis cdImoveis) {
        entrada.nextLine();

        System.out.println("Você entrou no método de Consultar Valor do Aluguel");

        System.out.println("Informe o IPTU do Imóvel (Apenas números):");
        numIPTU = entrada.nextInt();
        
        Imovel imovel = cdImoveis.buscarImovel(numIPTU);

        System.out.println("Deseja consultar por 1 (uma) ou mais Datas? Selecione uma opção:");
        System.out.println("[0] uma Data");
        System.out.println("[1] um intervalo de Datas");

        entrada.nextLine();

        int opcao = entrada.nextInt();

        if (opcao == 0) {
            System.out.println("Informe um valor para a Data");
            System.out.println("Ex: 15/04/1998");

            entrada.nextLine();
        
            String data = entrada.nextLine();

            System.out.println("Deseja adicionar indice de sazonalidade?");
            System.out.println("[0] NÃO");
            System.out.println("[1] SIM");

            int opt = entrada.nextInt();
            double valor = 0;

            if (opt == 0) {
                valor = imovel.valorAluguel(data, null);
            }else if(opt == 1){
                valor = retornaIndiceSazonalidade(entrada, imovel.valorAluguel(data, null));
            }

            System.out.println("Valor do aluguel: R$ " + valor);
            
        } else if(opcao == 1){
            System.out.println("Informe um valor para a Data Inicial");
            System.out.println("Ex: 15/04/1998");

            entrada.nextLine();
        
            String dataInicial = entrada.nextLine();

            System.out.println("Informe um valor para a Data Final");
            System.out.println("Ex: 15/04/1998");

            String dataFinal = entrada.nextLine();

            System.out.println("Deseja adicionar indice de sazonalidade?");
            System.out.println("[0] NÃO");
            System.out.println("[1] SIM");

            int opt = entrada.nextInt();
            double valor = 0;

            if (opt == 0) {
                valor = imovel.valorAluguel(dataInicial, dataFinal);
            }else if(opt == 1){
                valor = retornaIndiceSazonalidade(entrada, imovel.valorAluguel(dataInicial, dataFinal));
            }

            System.out.println("Valor do aluguel: R$ " + valor);
        } else {
            System.out.println("Opção Inválida!");
        }
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
                    try {
                        cadastrarProprietario(entrada,cdProprietario,cdImoveis);
                    } catch (ProprietarioExistenteException e) {
                        System.out.println(e.getMessage());
                    }
                break;

            case 3:
                associarImovelProprietario(entrada, cdImoveis, cdProprietario);
                break;

            case 4:
                valorReferenciaAluguel(entrada, cdImoveis);
                break;

            case 5:
                valorReferenciaAluguelComSazonalidade(entrada, cdImoveis);
                break;

            case 6:
                adicionarDataDisponivel(entrada, cdImoveis);
                break;

            case 7:
                verificarDisponibilidade(entrada, cdImoveis);
                break;

            case 8:
                consultarValorAluguel(entrada, cdImoveis);
                break;
            }
        } while(opcao != 0);

        entrada.close();
    }

    private static LocalDate parseStringData(String data) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate d = LocalDate.parse(data, formato);

        return d;
    }
}