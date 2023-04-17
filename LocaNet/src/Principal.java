public class Principal {
    
    public static void main(String[] args) {

        Imovel aptoCampo;
        Proprietario propAptoCampo;
        Imovel aptoCidade;

        String estado = "";
        String uf = "JC";
        Boolean estadoValido = false;

        for (Estados estados : Estados.values()) {
            if(uf == estados.getUF()){
                estadoValido = true;
                estado = estados.getUF();
            }
        }
        
        if(estadoValido == true){
            aptoCampo = new Imovel(
            "000000123456",
            "Rua Augusta Brasil",
            "123A",
            "01234-567" , 
            estado, 
            "Alagoinhas", 
            "apto", 
            "campo");

            propAptoCampo = new Proprietario(
            "Urias Manoel de Souza", 
            "012.345.678-90", 
            "0123456789 SSP-BA", 
            "Rua Augusta Brasil",
            "123A",
            "01234-567" , 
            estado, 
            "Alagoinhas");

            aptoCidade = new Imovel(
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
                aptoCampo.getEndereco()            
            );

            System.out.println(
                "O senhor(a) " + propAptoCampo.getNome() + 
                " deseja alugar o imóvel de IPTU: " + aptoCidade.getNumIPTU() + "\n"
                );

            System.out.println(
                "O imóvel de IPTU: " + aptoCidade.getNumIPTU() +
                " fica localizado no seguinte endereço:\n\n" +
                aptoCidade.getEndereco()
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
                Estados.BA.getUF(),
                "Salvador");

            System.out.println(
                propAptoCampo.getEndereco()
            );
        } else {
            System.out.println("A UF informada é inválida!!!");
        }

    }
}