public class Guerreiro extends Classe{

    private Item itemCabeca;
    private Item itemCorpo;

    public Guerreiro(String nome_da_classe)
    {
        super(nome_da_classe);
        this.itemCorpo = null;
        this.itemCabeca = null;

    }

    public Item getItemCorpo()
    {
        return this.itemCorpo;
    }

    public void setItemCorpo(Item item_corpo)
    {
        this.itemCorpo = item_corpo;
    }


    public Item getItemCabeca()
    {
        return this.itemCabeca;
    }

    public void setItemCabeca(Item item_cabeca)
    {
        this.itemCabeca = item_cabeca;
    }


    @Override
    public String toString()
    {
        return String.format("Descrição da classe: %s\n" + 
                            "Item Cabeça: %s\n" +
                            "Item Corpo: %s\n" +
                            "Item Mão Direita: %s\n" +
                            "Item Mão Esquerda: %s\n" + 
                            "Item Pé: %s\n", this.getDescricao(),
                            this.getItemCabeca(),
                            this.getItemCorpo(),
                            this.getItemMaoDireita(),
                            this.getItemMaoEsquerda(),
                            this.getItemPe()
        );
    }
}
