import java.util.ArrayList;
import java.util.List;

public class CadastroProprietario {
    
    private List<Proprietario> cadastro;

    public CadastroProprietario() {
        this.cadastro = new ArrayList<>();
    }

    public List<Proprietario> getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(List<Proprietario> cadastro) {
        this.cadastro = cadastro;
    }

    public void adicionarProprietario(Proprietario proprietario) {
        this.cadastro.add(proprietario);
    }

    public Proprietario buscarProprietario(String cpf) {
        
        for (Proprietario proprietario : cadastro) {
            
            if(proprietario.getCpf() == cpf){
                return proprietario;
            }
        }
        return null;
    }

}
