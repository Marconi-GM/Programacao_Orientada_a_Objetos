public class Ladrao extends Classe{

    private Item itemCorpo;

    public Ladrao(String nome_da_classe)
    {
        super(nome_da_classe);
        this.itemCorpo = null;

    }

    public Item getItemCorpo()
    {
        return this.itemCorpo;
    }

    public void setItemCorpo(Item item_corpo)
    {
        this.itemCorpo = item_corpo;
    }

    @Override
    public String toString()
    {
        return String.format("Descrição da classe: %s\n" +
                            "Item Corpo: %s\n" +
                            "Item Mão Direita: %s\n" +
                            "Item Mão Esquerda: %s\n" + 
                            "Item Pé: %s\n", this.getDescricao(),
                            this.getItemCorpo(),
                            this.getItemMaoDireita(),
                            this.getItemMaoEsquerda(),
                            this.getItemPe()
        );
    }
}
