import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
    
    private List<LocalDate> datasDisponivel;
    private List<LocalDate> datasAlugado;
    private List<LocalDate> datasBloqueado;

    public Agenda() {
        this.datasDisponivel = new ArrayList<>();
        this.datasAlugado = new ArrayList<>();
        this.datasBloqueado = new ArrayList<>();
    }

    public List<LocalDate> getDatasDisponivel(){
        return this.datasDisponivel;
    }

    public void setDatasDisponivel(LocalDate data) {
        this.datasDisponivel.add(data);
    }

    public void setDatasAlugado(LocalDate data) {
        this.datasAlugado.add(data);
    }

    public void setDatasBloqueado(LocalDate data) {
        this.datasBloqueado.add(data);
    }

    public boolean compararDatasBloqueado(LocalDate dataComparar){

        for (LocalDate data : datasBloqueado) {
            if (data.compareTo(dataComparar) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean compararDatasAlugado(LocalDate dataComparar){

        for (LocalDate data : datasAlugado) {
            if (data.compareTo(dataComparar) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean compararDatasDisponivel(LocalDate dataComparar){

        for (LocalDate data : datasDisponivel) {
            if (data.compareTo(dataComparar) == 0) {
                return true;
            }
        }
        return false;
    }

    public void removerDataDisponivel(LocalDate d) {

        this.datasDisponivel.remove(d);
    }

    public void removerDataAlugado(LocalDate d) {

        this.datasAlugado.remove(d);
    }

    public void removerDataBloqueado(LocalDate d) {

        this.datasBloqueado.remove(d);
    }

    public void ordenarDatasDisponiveis(){
        Collections.sort(this.datasDisponivel, new ComparadorDeDatas());
    }
}