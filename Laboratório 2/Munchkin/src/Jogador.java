import java.util.ArrayList;

public class Jogador {

    private final String nome;

    private Raca raca;

    protected Classe classe;

    protected Inventario inventario;

    private int nivel;


    public Jogador( String nome_jogador, int nivel_jogador,
                    Raca raca, Classe classe, ArrayList<Item> itens_inventario) throws Exception // Método construtor
    {
        this.nome = nome_jogador;
        this.nivel = nivel_jogador;
        this.raca = raca;

        for(int i = 0; i < itens_inventario.size(); i++)
        {
            if(!itens_inventario.get(i).getClassesCompativeis().contains(classe.getDescricao()))
            {
                throw new Exception("Classe incompatível");
            }
        }

        this.inventario = new Inventario(10, itens_inventario);
        this.classe = classe;
        
    }


    public Raca getRaca()
    {
        return this.raca;
    }

    public void setRaca(Raca raca_jogador)
    {
        this.raca = raca_jogador;
    }

    public Classe getClasse()
    {
        return this.classe;
    }

    public void setClasse(Classe classe_jogador)
    {
        this.classe = classe_jogador;
    }

    public String getNome()
    {
        return this.nome;
    }

    public int getNivel()
    {
        return this.nivel;
    }

    public void setNivel(int nivel_jogador)
    {
        this.nivel = nivel_jogador;
    }

    
    public int poderJogador()
    {
        int poder_total = 0;
        for(int i = 0; i < this.inventario.tamanhoInventario(); i++)
        {
            poder_total += this.inventario.get(i).getValor();
        }

        poder_total += this.getNivel();


        return poder_total;
    }

    

}
