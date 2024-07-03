import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class BauDeTesouros extends Inventario{

    Random randomNumbers = new Random();

    public BauDeTesouros(int limite_de_itens) {
        super(limite_de_itens);
    }

    public List<Item> pegarItensAleatorios(int quantidade_itens) {
        List<Item> itens_aleatorios = new ArrayList<Item>();
        int indice_aleatorio;
        
        for(int i = 0; i < quantidade_itens; i++) {
            indice_aleatorio = randomNumbers.nextInt(this.getItens().size());
            itens_aleatorios.add(this.getItens().get(indice_aleatorio));
            this.removerItem(this.getItens().get(indice_aleatorio).getNome());
        }
    
        return itens_aleatorios;
    }

    public Item acessarItem(String nome_item) {
        Item item_auxiliar = null;

        for(int i = 0; i < this.getItens().size(); i++) {
            if(this.getItens().get(i).getNome().equals(nome_item)) {
                item_auxiliar = this.getItens().get(i);
                this.removerItem(nome_item);

                return item_auxiliar;
            }
        }

        // retorna null caso não encontre o item
        return item_auxiliar;
    }

    public void listarItens() {
        int limite_de_itens;
        int item1, item2;
        
        limite_de_itens = this.getItens().size();
        item1 = randomNumbers.nextInt(limite_de_itens);
        item2 = randomNumbers.nextInt(limite_de_itens);

        System.out.printf("- %s --> %s\n", this.getItens().get(item1).getNome(), this.getItens().get(item1).getTipoItem());
        System.out.printf("- %s --> %s\n", this.getItens().get(item2).getNome(), this.getItens().get(item2).getTipoItem());        
    }

    public void infosBauTesouro() {
        System.out.println("=== Monstrando informações sobre o Baú de Tesouros:   ===");
        System.out.printf("Tamanho do baú:  %d itens\n", this.getLimiteDeItens());
        for(int i = 0; i < this.getItens().size(); i++) {
            this.getItens().get(i).toString();
        }
    }
}
