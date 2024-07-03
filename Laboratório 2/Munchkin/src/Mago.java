public class Mago extends Classe{
    
    private Item itemCabeca;

    public Mago(String nome_da_classe)
    {
        super(nome_da_classe);
        this.itemCabeca = null;
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
                            "Item Mão Direita: %s\n" +
                            "Item Mão Esquerda: %s\n" + 
                            "Item Pé: %s\n", this.getDescricao(),
                            this.getItemCabeca(),
                            this.getItemMaoDireita(),
                            this.getItemMaoEsquerda(),
                            this.getItemPe()
        );
    }

}
