import java.util.Arrays;
import java.util.Optional;

public enum Periodos {
    
    COMUM("Comum",0),
    REVEILLON("Reveillon", 20),
    CARNAVAL("Carnaval", 15),
    FERIADOALTA("Feriado Alta Estação", 10),
    FERIADOBAIXA("Feriado Baixa Estação", 5);

    private String periodo;
    private int indice;

    Periodos(String periodo, int indice) {
        this.periodo = periodo;
        this.indice = indice;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public int getIndice() {
        return this.indice;
    }

    public static Optional<Periodos> buscarIndicePorPeriodo(String periodo) {
        return Arrays.stream(Periodos.values())
            .filter(p -> p.periodo.equals(periodo))
            .findFirst();
    }
}
