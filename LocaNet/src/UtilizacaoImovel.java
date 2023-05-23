public enum UtilizacaoImovel {

    campo("campo"),
    praia("praia"),
    comercial("comercial");

    private String utilizacao;

    UtilizacaoImovel(String utilizacao){
        this.utilizacao = utilizacao;
    }

    public String getUtilizacao() {
        return this.utilizacao;
    }
}
