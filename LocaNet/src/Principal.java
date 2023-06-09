public class Principal {
    
    public static void main(String[] args) {

        Imovel imovel1, imovel2, imovel3;
        Proprietario prop1;

        String estado = "";
        String uf = "BA";
        Boolean estadoValido = false;

        for (Estados estados : Estados.values()) {
            if(uf == estados.getUF()){
                estadoValido = true;
                estado = estados.getUF();
            }
        }
        
        if(estadoValido == true){
            imovel1 = new Imovel(
            123456,
            123.45,
            "Rua Augusta Brasil",
            "123A",
            "01234-567" , 
            estado, 
            "Alagoinhas", 
            "apto", 
            "campo");

            imovel2 = new Imovel(
            456880,
            123.45,
            "Rua Felipa Caxias",
            "0001C",
            "55231-773" , 
            estado, 
            "Barreiras", 
            "casa", 
            "campo");

            prop1 = new Proprietario(
            "Urias Manoel de Souza", 
            "012.345.678-90", 
            "0123456789 SSP-BA", 
            "Rua Augusta Brasil",
            "123A",
            "01234-567" , 
            estado, 
            "Alagoinhas");

            prop1.adicionarImovel(imovel1);
            prop1.adicionarImovel(imovel2);

            System.out.println("Listando imóveis do tipo 'apto'\n");
            prop1.listarImovelPorTipo("apto");

            imovel3 = new Imovel(
            123499,
            123.45,
            "Rua 13 de Maio",
            "0001",
            "01234-775" , 
            "apto", 
            "praia");

            prop1.adicionarImovel(imovel3);

            prop1.atualizaEndereco(
                "Rua 13 de Maio",
                "0001",
                "01234-775",
                Estados.BA.getUF(),
                "Salvador");

            System.out.println("Listando imóveis do tipo 'apto'\n"); 
            prop1.listarImovelPorTipo("apto");

            System.out.println("Listando imóveis do tipo 'casa'\n"); 
            prop1.listarImovelPorTipo("casa");

            String data1 = "23/05/2023";
            String data2 = "24/05/2023";
            String data3 = "25/05/2023";
            String data4 = "25/05/2023";

            imovel1.adicionarDataBloqueado(data1);

            imovel1.adicionarDataAlugado(data2);
            imovel1.adicionarDataDisponivel(data2);
            imovel1.adicionarDataAlugado(data2);
            imovel1.adicionarDataDisponivel(data3);

            imovel1.adicionarDataBloqueado(data4);

            System.out.println("Linha teste\n");

        } else {
            System.out.println("A UF informada é inválida!!!");
        }

    }
}