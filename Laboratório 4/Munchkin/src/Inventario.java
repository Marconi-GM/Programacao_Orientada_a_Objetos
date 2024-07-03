import java.util.List;
import java.util.ArrayList;

public class Inventario {

    private int limiteDeItens;
    private List<Item> itens;

    public Inventario(int limite_de_itens) {
        this.limiteDeItens = limite_de_itens;
        this.itens = new ArrayList<>(limite_de_itens);
    }


    public int getLimiteDeItens() {
        return limiteDeItens;
    }

    public void setLimiteDeItens(int limiteDeItens) {
        this.limiteDeItens = limiteDeItens;
    }


    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Item> getItens() {
        return itens;
    }

    public boolean adicionarItem(Item item_novo){
        if(this.itens.size() >= limiteDeItens)
        {
            return false;
        } else{
            this.itens.add(item_novo);
            return true;
        }
    }

    public Item acessarItem(String nome_item){
        Item item_auxiliar = null;

        //retorna null se não houver item com o nome procurado
        item_auxiliar = null;

        for(int i = 0; i < this.itens.size(); i++){
            if(itens.get(i).getNome().equals(nome_item.toLowerCase())){
                item_auxiliar = itens.get(i).clone();
                itens.remove(i);

                return item_auxiliar;
            }
        }

        return item_auxiliar;
    }


    public void removerItem(String nome_item) {
        for(int i = 0; i < this.itens.size(); i++){
            if(itens.get(i).getNome().equals(nome_item.toLowerCase())){
                itens.remove(i);
                break;
            }
        }
    }

    public void removerItem(List<Item> lista_itens){
        for(int i = 0; i < lista_itens.size(); i++){
            removerItem(lista_itens.get(i).getNome());
        }
    }

    public void listarItens() {
        for(int i = 0; i < this.itens.size(); i++) {
            System.out.printf("- %s --> tipo: %s", this.itens.get(i).getNome(),
                              this.itens.get(i).getTipoItem());
        }
    }
}
