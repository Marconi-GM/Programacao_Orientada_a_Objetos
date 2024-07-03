public class Raca {

    private final String descricao;
    private String nomeDaRaca;
    private final int minimoPraFugir;

    public Raca(String descricao_raca, String nome_raca, int minimo) // Método construtor
    {
        this.descricao = descricao_raca;
        this.nomeDaRaca = nome_raca;
        this.minimoPraFugir = minimo;
    }


    public String getDescricao()
    {
        return this.descricao;
    }

    public String getNomeDaRaca()
    {
        return this.nomeDaRaca;
    }

    public void setNomeDaRaca(String nome_raca)
    {
        this.nomeDaRaca = nome_raca;
    }


    public int getMinimoPraFugir()
    {
        return this.minimoPraFugir;
    }


    public String toString()
    {
        return String.format("%s\n" +
                             "Descricao da Raca: %s\n" +
                             "Minimo para Fugir: %d\n", this.getNomeDaRaca(), this.getDescricao(), this.getMinimoPraFugir());
    }
}
