public class Item {

    private String nome;
    private String tipo;

    private int valor;
    private int bonusPoder;

    public Item() // Método construtor
    {
        this.nome = "None";
        this.tipo = "None";
        this.valor = 00;
        this.bonusPoder = 00;
    }

    
    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome_item)
    {
        this.nome = nome_item;
    }


    public String getTipo()
    {
        return this.tipo;
    }

    public void setTipo(String tipo_item)
    {
        this.tipo = tipo_item;
    }


    public int getValor()
    {
        return this.valor;
    }

    public void setValor(int valor_item)
    {
        this.valor = valor_item;
    }


    public int getBonusPoder()
    {
        return this.bonusPoder;
    }

    public void setBonusPoder(int bonus_poder)
    {
        this.bonusPoder = bonus_poder;
    }


    public String toString()
    {
        return String.format("\t=== INFORMAÇÕES SOBRE O ITEM ===\t\n\n" + 
                            "Nome: %s\n" + 
                            "Tipo: %s\n" +
                            "Valor: %s\n" +
                            "Bonus de Poder: %d\n\n", this.getNome(), this.getTipo(),
                            this.getValor(), this.getBonusPoder());        
    }

}
