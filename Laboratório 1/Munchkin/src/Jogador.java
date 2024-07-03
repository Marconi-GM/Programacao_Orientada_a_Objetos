public class Jogador {

    private String nome;
    private String raca;
    private String classe;
    private String itemCabeca;
    private String itemCorpo;
    private String itemMaoDireita;
    private String itemMaoEsquerda;
    private String itemPe;

    private int nivel;


    public Jogador() // Método construtor
    {
        this.nome = "Jhonny";
        this.raca = "None";
        this.classe = "None";
        this.itemCabeca = "None";
        this.itemCorpo = "None";
        this.itemMaoDireita = "None";
        this.itemMaoEsquerda = "None";
        this.itemPe = "None";
        this.nivel = 0;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }


    public String getRaca()
    {
        return this.raca;
    }

    public void setRaca(String raca)
    {
        this.raca = raca;
    }


    public String getClasse()
    {
        return this.classe;
    }

    public void setClasse(String classe)
    {
        this.classe = classe;
    }


    public String getItemCabeca()
    {
        return this.itemCabeca;
    }

    public void setItemCabeca(String item_cabeca)
    {
        this.itemCabeca = item_cabeca;
    }

    
    public String getItemCorpo()
    {
        return this.itemCorpo;
    }
    
    public void setItemCorpo(String item_corpo)
    {
        this.itemCorpo = item_corpo;
    }


    public String getItemMaoDireita()
    {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita(String item_mao_direita)
    {
        this.itemMaoDireita = item_mao_direita;
    }


    public String getItemMaoEsquerda()
    {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda(String item_mao_esquerda)
    {
        this.itemMaoEsquerda = item_mao_esquerda;
    }


    public String getItemPe()
    {
        return this.itemPe;
    }

    public void setItemPe(String item_pe)
    {
        this.itemPe = item_pe;
    }


    public int getNivel()
    {
        return this.nivel;
    }

    public void setNivel(int nivel_jogador)
    {
        this.nivel = nivel_jogador;
    }


    public boolean possuiMaoVazia()
    {
        if(getItemMaoDireita() == "None" || getItemMaoEsquerda() == "None")
        {
            return true;
        }

        else
        {
            return false;
        }
    }


    public String toString()
    {
        return String.format("\t=== INFORMAÇÕES SOBRE O JOGADOR ===\t\n\n" + 
                            "Nome: %s\n" + 
                            "Raca: %s\n" +
                            "Classe: %s\n" +
                            "Nivel: %d\n" +
                            "Item Equipado da Cabeca: %s\n" +
                            "Item Equipado do Corpo: %s\n" +
                            "Item Equipado da Mão direita: %s\n" +
                            "Item Equipado da Mão esquerda: %s\n" +
                            "Item Equipado do Pe: %s\n", this.getNome(), this.getRaca(),
                            this.getClasse(), this.getNivel(), this.getItemCabeca(), this.getItemCorpo(),
                            this.getItemMaoDireita(), this.getItemMaoEsquerda(), this.getItemPe());        
    }

}
