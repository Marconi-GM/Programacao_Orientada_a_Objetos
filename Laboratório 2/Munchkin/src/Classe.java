/* ANTES DE LER O CÓDIGO, LEIA O COMENTÁRIO NA CLASSE JOGADOR */

public abstract class Classe {

    private final String descricao;

    protected Item itemMaoDireita;
    protected Item itemMaoEsquerda;
    protected Item itemPe;

    // // Atributos adicionados por conta do erro mecionado no comentário na classe jogador
    // protected Item itemCabeca;
    // protected Item itemCorpo;

    public Classe(String nome_da_classe) // construtor
    {
        this.descricao = nome_da_classe;
        this.itemMaoDireita = null;
        this.itemMaoEsquerda = null;
        this.itemPe = null;
    }

    public String getDescricao()
    {
        return this.descricao;
    }


    public Item getItemMaoDireita()
    {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita(Item item_mao_direita)
    {
        this.itemMaoDireita = item_mao_direita;
    }


    public Item getItemMaoEsquerda()
    {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda(Item item_mao_esquerda)
    {
        this.itemMaoEsquerda = item_mao_esquerda;
    }


    public Item getItemPe()
    {
        return this.itemPe;
    }

    public void setItemPe(Item item_pe)
    {
        this.itemPe = item_pe;
    }

    public String toString()
    {
        return String.format("\t\t===INFORMAÇÕES SOBRE A CLASSE===\n" + 
                            "Descricao: %s\n" +
                            "Itens: \n" +
                            "-- Mão direita --\n %s" +
                            "-- Mão esquerda --\n %s" + 
                            "-- Pé --\n %s\n", this.getDescricao(), this.itemMaoDireita.toString(),
                            itemMaoEsquerda.toString(), itemPe.toString());
    }

    public boolean possuiMaoVazia()
    {
        if(this.getItemMaoDireita() == null || this.getItemMaoEsquerda() == null) {
            return true;
        }

       
        return false;
    }
}
