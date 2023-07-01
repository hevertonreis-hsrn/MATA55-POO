import java.util.ArrayList;
import java.util.List;

public class Condominio{

    private List<String> itensLazer;
    private Endereco endereco;

    public Condominio(String rua, String numero, String cep, String estado, String cidade) {
        this.endereco = new Endereco(rua, numero, cidade, estado, cep);
        this.itensLazer = new ArrayList<>();
    }
    
    public void adicionarItemLazer(String itemLazer) {
        this.itensLazer.add(itemLazer);
    }

    public int qtdItensLazer(){
        return itensLazer.size();
    }

    @Override
    public String toString() {

        return "============ Dados do Condomínio ===========\n\n" +
                this.endereco.toString() + "\n";
    }

}
