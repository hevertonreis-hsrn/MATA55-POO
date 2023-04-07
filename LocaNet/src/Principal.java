public class Principal {
    
    public static void main(String[] args) {
        
        Imovel aptoCampo = new Imovel(
            "000000123456",
            "Rua Augusta Brasil",
            "123A",
            "01234-567" , 
            "Bahia", 
            "Alagoinhas", 
            "apto", 
            "campo");

        Proprietario propAptoCampo = new Proprietario(
            "Urias Manoel de Souza", 
            "012.345.678-90", 
            "0123456789 SSP-BA", 
            "Rua Augusta Brasil",
            "123A",
            "01234-567" , 
            "Bahia", 
            "Alagoinhas");

        Imovel aptoCidade = new Imovel(
            "000000123499",
            "Rua 13 de Maio",
            "0001",
            "01234-775" , 
            "apto", 
            "praia");

        System.out.println(
            "O senhor(a) " + propAptoCampo.getNome() +
            " é proprietário(a) do imóvel de IPTU: " + aptoCampo.getNumIPTU() + "\n"
            );

        System.out.println(
            "O imóvel de IPTU: " + aptoCampo.getNumIPTU() +
            " fica localizado no seguinte endereço:\n\n" +
            "Logradouro: " + aptoCampo.getRua() + "\n" +
            "Número: " + aptoCampo.getNumero() + "\n" +
            "CEP: " + aptoCampo.getCep() + "\n" +
            "Estado: " + aptoCampo.getEstado() + "\n" +
            "Cidade: " + aptoCampo.getCidade() + "\n\n"
        );

        System.out.println(
            "O senhor(a) " + propAptoCampo.getNome() +
            " deseja alugar o imóvel de IPTU: " + aptoCidade.getNumIPTU() + "\n"
            );

        System.out.println(
            "O imóvel de IPTU: " + aptoCidade.getNumIPTU() +
            " fica localizado no seguinte endereço:\n\n" +
            "Logradouro: " + aptoCidade.getRua() + "\n" +
            "Número: " + aptoCidade.getNumero() + "\n" +
            "CEP: " + aptoCidade.getCep() + "\n" +
            "Estado: " + aptoCidade.getEstado() + "\n" +
            "Cidade: " + aptoCidade.getCidade() + "\n\n"
        );

        System.out.println(
            "O senhor(a) " + propAptoCampo.getNome() +
            " alugou o imóvel de IPTU: " + aptoCidade.getNumIPTU() + "\n" +
            "Seu novo Endereço é: \n"
        );

        propAptoCampo.atualizaEndereco(
            "Rua 13 de Maio",
            "0001",
            "01234-775",
            "Bahia",
            "Salvador");

        System.out.println(
            "Logradouro: " + propAptoCampo.getRua() + "\n" +
            "Número: " + propAptoCampo.getNumero() + "\n" +
            "CEP: " + propAptoCampo.getCep() + "\n" +
            "Estado: " + propAptoCampo.getEstado() + "\n" +
            "Cidade: " + propAptoCampo.getCidade() + "\n\n"
        );
    }
}