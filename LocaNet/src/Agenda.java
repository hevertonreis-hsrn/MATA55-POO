import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Agenda {
    
    private List<Calendar> datasDisponivel;
    private List<Calendar> datasAlugado;
    private List<Calendar> datasBloqueado;

    public Agenda() {
        this.datasDisponivel = new ArrayList<>();
        this.datasAlugado = new ArrayList<>();
        this.datasDisponivel = new ArrayList<>();
    }
}