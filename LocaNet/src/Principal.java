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
            "Cidade: " + aptoCampo.getCidade() + "\n"
        );
    }
}