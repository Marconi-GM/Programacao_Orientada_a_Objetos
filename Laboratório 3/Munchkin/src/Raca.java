public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ANAO("Anao");

    String raca;

    private Raca(String raca){
        this.raca = raca;
    }

    public String getRaca(){
        return this.raca;
    }
}
