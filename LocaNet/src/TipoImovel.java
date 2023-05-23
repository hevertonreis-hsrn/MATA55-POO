public enum TipoImovel {

    casa("casa"),
    apto("apto"),
    studio("studio");

    private String tipo;

    TipoImovel(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }
}
