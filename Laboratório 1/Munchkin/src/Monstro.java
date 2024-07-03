public class Monstro {

    private String nome;

    private int poder;
    private int qtdeDeTesouros;
    private int niveisPerdidos;

    public Monstro() // Método construtor
    {
        this.nome = "None";
        this.poder = 0;
        this.qtdeDeTesouros = 0;
        this.niveisPerdidos = 0;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome_monstro)
    {
        this.nome = nome_monstro;
    }


    public int getPoder()
    {
        return this.poder;
    }

    public void setPoder(int poder_monstro)
    {
        this.poder = poder_monstro;
    }


    public int getQuantidade_Tesouros()
    {
        return this.qtdeDeTesouros;
    }

    public void setQuantidade_Tesouros(int qtde_tesouros)
    {
        this.qtdeDeTesouros = qtde_tesouros;
    }


    public int getNiveisPerdidos()
    {
        return this.niveisPerdidos;
    }

    public void setNiveisPerdidos(int niveis_perdidos)
    {
        this.niveisPerdidos = niveis_perdidos;
    }


    public String toString()
    {
        return String.format("\t=== INFORMAÇÕES SOBRE O MONSTRO ===\t\n\n" + 
                            "Nome: %s\n" + 
                            "Poder: %s\n" +
                            "Quantidade de Tesouros dropados: %s\n" +
                            "Niveis perdidos ao morrer para %s: %d\n\n", this.getNome(), this.getPoder(),
                            this.getQuantidade_Tesouros(), this.getNome(), this.getNiveisPerdidos());        
    }

}
