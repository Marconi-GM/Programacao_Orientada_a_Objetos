import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private int limiteInventario;
    private List<Item> inventario = new ArrayList<Item>();

    
    public Inventario(int limite, List<Item> lista_itens) // construtor
    {
        this.setLimiteInventario(limite);
        this.setInventario(lista_itens);
    }

    public int getLimiteInventario()
    {
        return this.limiteInventario;
    }

    public void setLimiteInventario(int limite)
    {
        if(limite >= 0)
        {
            this.limiteInventario = limite;
        }

        else
        {
            System.out.println("Limite inválido, por favor insira outro.");
        }
    }


    // retorna todo o inventário de uma vez
    public List<Item> getInventario()
    {
        return this.inventario;
    }

    public void setInventario(List <Item> lista_itens)
    {
        if(lista_itens.size() <= this.getLimiteInventario())
        {
            for(int i = 0; i < lista_itens.size(); i++)
            {
                this.inventario.add(lista_itens.get(i));
            }
        }

        else
        {
            System.out.printf("O inventário comporta apenas %d itens, sua lista possui %d itens.",
                               this.getLimiteInventario(), lista_itens.size());
        }
    }


    public String toString()
    {
        return String.format("\t\t=== INFORMAÇÕES SOBRE O INVENTÁRIO ===\n" +
                            "Limite de itens do inventário: %d\nNúmero de itens atualmente no invetario %d\n" +
                            "Inventário: \n"+ this.getInventario() + "\n", this.getLimiteInventario(), this.inventario.size());
    }


    private boolean possuiItemGrande()
    {
        for(int i = 0; i < this.inventario.size(); i++)
        {
            if(this.inventario.get(i).isItemGrande(this.inventario.get(i).getNome()))
            {
                return true;
            }
        }

        // retorna falso se não encontrou nenhum item grande e então saiu do for
        return false;

    }

    public int tamanhoInventario()
    {
        return this.inventario.size();
    }

    public Item get(int indice)
    {
        return this.inventario.get(indice);
    }


    public boolean adicionarItem(Item item_novo)
    {
        if(getLimiteInventario() == inventario.size())
        {
            /* Fiquei em dúvida se colocar o print dentro do método é uma boa prática ou se
             * devemos evitar e, nesse caso, esse print não deveria estar aqui
             */
            System.out.println("Inventário cheio, não é possível adicionar mais itens.");
            return false;
        }

        else
        {
            if( !this.possuiItemGrande() )
            {
                this.inventario.add(item_novo);
                return true;
            }

            else
            {
                System.out.println("Esse inventário já possui um item grande");
                return false;
            }
        }
    }

    public Item acessarItem(String item_desejado)
    {
        boolean encontrou = false;
        int index_do_item = -1; // aqui inicializei o index_do_item como -1 apenas
                                // evitar erro de inicialização (dentro do if(encontrou))
        for(int i = 0; i < inventario.size() && !encontrou; i++)
        {
            if(this.inventario.get(i).getNome().equals(item_desejado))
            {
                index_do_item = i;
                encontrou = true;
            }
        }

        if(encontrou)
        {
            Item item_encontrado;
            item_encontrado = inventario.get(index_do_item);

            return item_encontrado;
        }

        else
        {
            System.out.println("Item não encontrado!");
            return null;
        }
    }

    public void removeItem(String nome_do_item)
    {
        boolean encontrou = false;
        int index_do_item = -1;

        for(int i = 0; i < this.inventario.size() && !encontrou; i++)
        {
            if(this.inventario.get(i).getNome().equals(nome_do_item))
            {
                index_do_item = i;
                encontrou = true;
            }
        }

        if(encontrou)
        {
            inventario.remove(index_do_item);
        }

        else
        {
            System.out.println("Item não encontrado! Não pode ser removido");
        }
    }

    public void listarInventario()
    {
        for(int i = 0; i < inventario.size(); i++)
        {
            System.out.printf(inventario.get(i).toString());
        }
    }
}
