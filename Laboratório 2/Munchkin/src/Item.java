import java.util.List;
import java.util.ArrayList;

public class Item {

    private final String nome;
    private String tipo;
    private String tamanhoItem;

    private int valor;
    private int bonusPoder;

    private boolean itemGrande;

    private List<String> classesCompativeis = new ArrayList<String>();

    public Item(String nome_do_item, String tipo_item, int valor_item,
                int bonus_poder_item, String tamanho_item) // Método construtor
    {
        this.nome = nome_do_item;

        this.setTipo(tipo_item);
        this.setValor(valor_item);
        this.setBonusPoder(bonus_poder_item);
        this.setTamanhoItem(tamanho_item);
    }

    
    public String getNome()
    {
        return this.nome;
    }

    
    public List<String> getClassesCompativeis()
    {
        return this.classesCompativeis;
    }

    public void setClassesCompatives(String nome_da_classe)
    {
        this.classesCompativeis.add(nome_da_classe);
    }


    public String getTamanhoItem()
    {
        return this.tamanhoItem;
    }

    public void setTamanhoItem(String tamanho)
    {
        String tamanho_item;
        tamanho_item = tamanho.toLowerCase();

        if(tamanho_item.equals("grande") || tamanho_item.equals("pequeno"))
        {
            this.tamanhoItem = tamanho_item;

            if(tamanho_item.equals("grande"))
            {
                this.itemGrande = true;
            }

            else
            {
                this.itemGrande = false;
            }
        }

        else
        {
            System.out.println("Tamanho inválido, por favor insira outro!");
        }

    }

    public boolean isItemGrande(String nome_item)
    {
        if(this.itemGrande)
        {
            return true;
        }

        else
        {
            return false;
        }
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
        return String.format("\t=== INFORMAÇÕES SOBRE O ITEM %s ===\t\n\n" + 
                            "Nome: %s\n" + 
                            "Tipo: %s\n" +
                            "Valor: %s\n" +
                            "Bonus de Poder: %d\n" + 
                            "Tamanho do item: %s\n" +
                            "Classes compatíveis: " + this.getClassesCompativeis() + "\n", this.getNome(), this.getNome(), this.getTipo(),
                            this.getValor(), this.getBonusPoder(), this.getTamanhoItem());        
    }
}
