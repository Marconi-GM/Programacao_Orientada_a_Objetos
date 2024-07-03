import java.util.List;

public class Item implements Cloneable{

    private final String nome;
    
    private int bonusPoder;

    private int valor;

    private TipoItem tipo;

    private boolean isItemGrande;

    private List<Classe> classesCompativeis;
    
    private List<Raca> racasCompativeis;


    public Item(String nome_item, int bonus_poder, int valor_item,
                String tipo_item, boolean item_grande,
                List<Classe> classes_compativeis, List<Raca> racas_compativeis) {

                this.nome = nome_item.toLowerCase();
                this.bonusPoder = bonus_poder;
                this.valor = valor_item;
                this.tipo = TipoItem.valueOf(tipo_item.toUpperCase());
                this.isItemGrande = item_grande;
                this.classesCompativeis = classes_compativeis;
                this.racasCompativeis = racas_compativeis;

    }


    public String getNome() {
        return this.nome;
    }

    public int getBonusPoder() {
        return this.bonusPoder;
    }

    public void setBonusPoder(int bonusPoder) {
        this.bonusPoder = bonusPoder;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public TipoItem getTipoItem() {
        return this.tipo;
    }

    public void setTipoItem(String tipo_item) {

        this.tipo = TipoItem.valueOf(tipo_item.toUpperCase());
    }

    public boolean isItemGrande() {
        return this.isItemGrande;
    }

    public void setItemGrande(boolean itemGrande) {
        this.isItemGrande = itemGrande;
    }

    public List<Classe> getClassesCompativeis() {
        return this.classesCompativeis;
    }

    public void setClassesCompativeis(List<Classe> classesCompativeis) {
        this.classesCompativeis = classesCompativeis;
    }

    public List<Raca> getRacasCompativeis() {
        return this.racasCompativeis;
    }

    public void setRacasCompativeis(List<Raca> racasCompativeis) {
        this.racasCompativeis = racasCompativeis;
    }

    @Override
    public Item clone() {
        return this.clone();
    }

    @Override
    public String toString() {
        return String.format("\t\t~~~ Item: %s ~~~\n" +
                            "Bonus de Poder: %d\n" +
                            "Valor do item: %d\n" +
                            "Item grande: %b\n" +
                            "Classes compatíveis: " + "CLASSES COMPATIVEIS AQUI" + "\n" +
                            "Racas compativeis: " + "RACAS COMPATIVEIS AQUI" + "\n",
                            this.getNome(), this.getBonusPoder(), this.getValor(),
                            this.isItemGrande());
    }
}
