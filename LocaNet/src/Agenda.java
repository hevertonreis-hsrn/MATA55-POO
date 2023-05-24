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
        this.datasBloqueado = new ArrayList<>();
    }

    public void setDatasDisponivel(Calendar data) {
        this.datasDisponivel.add(data);
    }

    public void setDatasAlugado(Calendar data) {
        this.datasAlugado.add(data);
    }

    public void setDatasBloqueado(Calendar data) {
        this.datasBloqueado.add(data);
    }

}