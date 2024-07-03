import java.util.List;

public class Jogador {

    private final String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;
    private Item itemCabeca = null;
    private Item itemCorpo = null;
    private Item itemMaoDireita = null;
    private Item itemMaoEsquerda = null;
    private Item itemPe = null;

    
    public Jogador(String nome, int nivel, Raca raca, Classe classe, Inventario inventario) {

                    this.nome = nome;
                    this.nivel = nivel;
                    this.raca = raca;
                    this.classe = classe;
                    this.inventario = inventario;
    }


    private int encontraIndiceDoItem(
    List<Item> lista_itens, 
    String item_procurado
    ) {
    for(int i = 0; i < lista_itens.size(); i++) {
        if(lista_itens.get(i).getNome().equals(item_procurado)) {
            return i;
        }
    }

    return -1;
}

    public boolean equiparItem(String nomeItem) {
        int indice_item;
        Item item;

        indice_item = encontraIndiceDoItem(this.inventario.getItens(), nomeItem);
        
        if(indice_item == -1) {
            return false;
        } else {
            item = this.inventario.getItens().get(indice_item);

            switch (item.getTipoItem()) {
                case CABECA:
                    this.setItemCabeca(item);
                    break;

                case CORPO:
                    this.setItemCorpo(item);
                    break;

                case MAO:
                    this.setItemMaoDireita(item);
                    this.setItemMaoEsquerda(item);
                    break;

                case PE:
                    this.setItemPe(item);
                    break;           
            }
            
            return true;
        }

        
    }


    public String getNome() {
        return nome;
    }


    public int getNivel() {
        return nivel;
    }


    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    public Raca getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = Raca.valueOf(raca.toUpperCase());
    }

    public Inventario getInventario() {
        return inventario;
    }


    public Classe getClasse() {
        return classe;
    }


    public void setClasse(String classe) {
        this.classe = Classe.valueOf(classe.toUpperCase());
    }


    public void abrirInventario() {
        this.inventario.listarItens();
    }


    public Item getItemCabeca() {
        return itemCabeca;
    }


    public void setItemCabeca(Item itemCabeca) {
        this.itemCabeca = itemCabeca;
    }


    public Item getItemCorpo() {
        return itemCorpo;
    }


    public void setItemCorpo(Item itemCorpo) {
        this.itemCorpo = itemCorpo;
    }


    public Item getItemMaoDireita() {
        return itemMaoDireita;
    }


    public void setItemMaoDireita(Item itemMaoDireita) {
        this.itemMaoDireita = itemMaoDireita;
    }


    public Item getItemMaoEsquerda() {
        return itemMaoEsquerda;
    }


    public void setItemMaoEsquerda(Item itemMaoEsquerda) {
        this.itemMaoEsquerda = itemMaoEsquerda;
    }


    public Item getItemPe() {
        return this.itemPe;
    }


    public void setItemPe(Item pe) {
        itemPe = pe;
    }

    public int poderJogador() {
        int poder_total = this.getNivel();
        poder_total += this.getItemCabeca().getValor();
        poder_total += this.getItemCorpo().getValor();
        poder_total += this.getItemMaoDireita().getValor();
        poder_total += this.getItemMaoEsquerda().getValor();
        poder_total += this.getItemPe().getValor();

        return poder_total;
    }

    public boolean venderItens(List<String> itensParaVender) {
        int valor_dos_itens_vendidos = 0;

        for(int i = 0; i < itensParaVender.size(); i++){
            if(this.inventario.acessarItem(itensParaVender.get(i)).getNome() == null){

                System.out.println("Não há esse item no inventario");

                return false;

            } else {
                valor_dos_itens_vendidos += this.inventario.acessarItem(itensParaVender.get(i)).getValor();
                this.inventario.removerItem(itensParaVender.get(i));
            }

            if(valor_dos_itens_vendidos >= 1000) {
                this.nivel += 1;
                valor_dos_itens_vendidos = 0;
            }
        }
        return true;
    }


    public String toString() {
        return String.format("\t\t=== Informações sobre o jogador ===\n" + 
                            "Nome: %s\nNivel: %d\nClasse: %s\nRaca: %s\n\n" + 
                            "Item equipado na cabeça: %s\n" + 
                            "Item equipado no corpo: %s\n" + 
                            "Item equipado na mão direita: %s\n" + 
                            "Item equipado na mão esquerda: %s\n" + 
                            "Item equipado no pé: %s\n", this.getNome(),
                            this.getNivel(), this.getClasse(), this.getRaca(),
                            this.getItemCabeca(), this.getItemCorpo(), 
                            this.getItemMaoDireita(), this.getItemMaoEsquerda(),
                            this.getItemPe());
    }
}