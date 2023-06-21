public interface IAluguel {
    
    public boolean disponibilidadeImovel(String dataInicial, String dataFinal);
    public double valorAluguel(String dataInicial, String dataFinal);
}
