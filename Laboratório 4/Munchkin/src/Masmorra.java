import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Masmorra {

    private List<Monstro> monstros;
    private BauDeTesouros tesouros;

    
    public Masmorra(List<Monstro> monstros, BauDeTesouros tesouros) {
        this.monstros = monstros;
        this.tesouros = tesouros;
    }

    public List<Monstro> getMonstros() {
        return monstros;
    }

    public void setMonstros(List<Monstro> monstros) {
        this.monstros = monstros;
    }

    public BauDeTesouros getTesouros() {
        return tesouros;
    }

    public void setTesouros(BauDeTesouros tesouros) {
        this.tesouros = tesouros;
    }

    public void infosMasmorra()
    {
        System.out.println("=== Mostrando os monstros da Masmorra:  ===");
        for(int i = 0; i < this.monstros.size(); i++)
        {
            this.monstros.get(i).toString();
        }

        this.getTesouros().infosBauTesouro();
    }

    public Monstro abrirPortaMonstro(Jogador player)
    {
        Random randomNumbers = new Random();

        int monstro;
        monstro = randomNumbers.nextInt(this.getMonstros().size());

        Monstro monstro_aleatorio;
        monstro_aleatorio = this.getMonstros().get(monstro);

        return monstro_aleatorio;
    }

    public Item abrirPortaItem(Jogador player, Scanner scanner)
    {   
        String item;
        
        Item itemEscolhido;

        System.out.println("=========================");
        System.out.printf("\tA porta dos itens foi aberta! O jogador" +
                            "pode escolher um dos seguintes itens:\n");
        
        this.tesouros.listarItens();

        System.out.printf("\nDigite o nome do item escolhido:   ");
        item = scanner.nextLine();

        itemEscolhido = this.tesouros.acessarItem(item);

        return itemEscolhido;
    }
}
