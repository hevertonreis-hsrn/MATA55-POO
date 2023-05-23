import java.util.ArrayList;
import java.util.List;

public class CadastroImoveis {
    
    private List<Imovel> cadastro;

    public CadastroImoveis() {
        this.cadastro = new ArrayList<>();
    }

    public List<Imovel> getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(List<Imovel> cadastro) {
        this.cadastro = cadastro;
    }

    public void adicionarImovel(Imovel imovel) {
        this.cadastro.add(imovel);
    }

}
