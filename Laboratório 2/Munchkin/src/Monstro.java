import java.util.List;
import java.util.ArrayList;

public class Monstro {

    private final String nome;

    private List<Item> tesouros = new ArrayList<Item>();

    private int poder;
    private int niveisPerdidos;

    public Monstro(String nome_monstro, int poder_monstro, int niveis_perd, ArrayList<Item> tesouros_monstro) // Método construtor
    {
        this.nome = nome_monstro;
        this.poder = poder_monstro;
        this.niveisPerdidos = niveis_perd;

        for(int i = 0; i < tesouros_monstro.size(); i++)
        {
            this.setTesouros(tesouros_monstro.get(i));
        }
    }

    public String getNome()
    {
        return this.nome;
    }


    public int getPoder()
    {
        return this.poder;
    }

    public void setPoder(int poder_monstro)
    {
        this.poder = poder_monstro;
    }


    public List<Item> getTesouros()
    {
        return this.tesouros;
    }

    public void setTesouros(Item nome_do_item)
    {
        this.tesouros.add(nome_do_item);
    }


    public int getNiveisPerdidos()
    {
        return this.niveisPerdidos;
    }

    public void setNiveisPerdidos(int niveis_perdidos)
    {
        this.niveisPerdidos = niveis_perdidos;
    }


    public String toString()
    {
        return String.format("\t\t==== INFORMAÇÕES SOBRE O MONSTRO ====\n" +
                            "Nome: %s\n" +
                            "Poder: %d\n" +
                            "Niveis perdidos se derrotado ao enfrentá-lo: %d\n" +
                            "Tesouros que possui:\n" + tesouros.toString() + "\n", this.getNome(),
                            this.getPoder(), this.getNiveisPerdidos());
    }

}
