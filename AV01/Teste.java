//Heverton Reis - M218115975
public class Teste {
    
    public static void main(String[] args) {

        Consulta consulta0 = new Consulta(
            "Carmen Augusta",
            "012.345.557-90",
            27,
            "25/04/2023-11:00",
            "Virose",
            "Análgésico e Antitérmico"
            );
        
        Consulta consulta1 = new Consulta(
            "Ricardo Sales",
            "012.345.678-90",
            27,
            "26/04/2023-11:00",
            false);

        Consulta consulta2 = new Consulta(
            "Luanna Amanteigado",
            "557.345.678-90",
            27,
            "26/04/2023-11:00",
            false);

        Consulta consulta3 = new Consulta(
            "Victor Salazar",
            "557.345.138-90",
            27,
            "27/04/2023-11:00",
            false);

        Consulta consulta4 = new Consulta(
            "Emily Justina",
            "557.223.138-90",
            27,
            "28/04/2023-11:00",
            false);

            Consulta consulta5 = new Consulta(
                "Valdomiro José",
                "557.223.138-13",
                27,
                "28/04/2023-13:00",
                false);

        Medico medico1 = new Medico(
            012345,
            "Julia de Castro",
            101);

        medico1.adicionarConsulta(consulta1);
        medico1.adicionarConsulta(consulta2);
        medico1.adicionarConsulta(consulta3);
        medico1.adicionarConsulta(consulta4);
        medico1.adicionarConsulta(consulta0);
        medico1.adicionarConsulta(consulta5);

        medico1.removerConsulta(consulta1);
        medico1.removerConsulta("27/04/2023-11:00");
        medico1.removerConsulta(consulta1);

        medico1.listarConsultas(true);
        //medico1.listarConsultas(false);
        //medico1.listarConsultas();
    }
}
