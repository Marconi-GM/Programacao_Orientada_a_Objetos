import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class MunchkinMain {

    public static void main(String[] args) throws Exception {

        ArrayList<Classe> ladrao = new ArrayList<Classe>();
        ArrayList<Classe> mago_guerreiro = new ArrayList<Classe>();
        mago_guerreiro.add(Classe.MAGO);
        mago_guerreiro.add(Classe.GUERREIRO);
        ladrao.add(Classe.LADRAO);

        ArrayList<Raca> elfo_humano = new ArrayList<Raca>();
        elfo_humano.add(Raca.ELFO);
        elfo_humano.add(Raca.HUMANO);

        ArrayList<Raca> anao = new ArrayList<Raca>();
        anao.add(Raca.ANAO);

        Item item1 = new Item("Canivete", 10, 15, "MAO", false, ladrao, elfo_humano);
        Item item2 = new Item("arco e flecha", 100, 300, "MAO", true, mago_guerreiro, elfo_humano);
        Item item3 = new Item("Machado", 125, 75, "MAO", true, ladrao, anao);                
        Item item4 = new Item("Elmo alado", 300, 350, "CABECA", false, mago_guerreiro, elfo_humano);
        Item item5 = new Item("Peitoral encouracado", 525, 700, "CORPO", true, mago_guerreiro, elfo_humano);
        Item item6 = new Item("botas comum", 50, 25, "PE", false, mago_guerreiro, elfo_humano);
        Item item7 = new Item("Gibao", 150, 175, "CORPO", false, mago_guerreiro, elfo_humano);

        Inventario inventario = new Inventario(10);
        inventario.adicionarItem(item2);

        BauDeTesouros bau = new BauDeTesouros(10);
        bau.adicionarItem(item1);
        bau.adicionarItem(item3);
        bau.adicionarItem(item4);
        bau.adicionarItem(item5);
        bau.adicionarItem(item6);
        bau.adicionarItem(item7);

        ArrayList<Monstro> monstros = new ArrayList<Monstro>();
        Monstro monstro1 = new Monstro("Org", 350, 300, 20);
        Monstro monstro2 = new Monstro("Harpia", 120, 100, 10);
        Monstro monstro3 = new Monstro("Aranha", 50, 25, 12);
        Monstro monstro4 = new Monstro("Escorpiao", 100, 175, 50);
        Monstro monstro5 = new Monstro("Gerson", 999, 9999, 999);

        monstros.add(monstro1);
        monstros.add(monstro2);
        monstros.add(monstro3);
        monstros.add(monstro4);
        monstros.add(monstro5);


        Masmorra masmorra = new Masmorra(monstros, bau);
        

        Jogador player = new Jogador("Vasconha", 99, Raca.HUMANO, Classe.MAGO, inventario);


        int acao = -1;

        System.out.println("===================================================");
        System.out.println("\t\tJogo Mostra:");
        System.out.printf("Jogador: %s\n", player.getNome());
        
        Scanner scanner = new Scanner(System.in);
        

       do {
            System.out.printf("\nO que você deseja fazer?\n");
            System.out.println("[1] - Listar itens do invetário.");
            System.out.println("[2] - Equipar itens do invetário.");
            System.out.println("[3] - Vender itens do inventário.");
            System.out.println("[4] - Ver informações do jogador.");
            System.out.println("[5] - Passar para abrir a porta.");
            System.out.println("[0] - Sair.");

            acao = scanner.nextInt();

            switch(acao) {
                case 0:
                    break;

                case 1:
                    listarItensInventario(player);
                    break;

                case 2:
                    equiparItensDoInventario(player);
                    break;

                case 3:
                    venderItensDoInventario(player);
                    break;

                case 4:
                    informacoesJogador(player);
                    break;

                case 5:
                    abrirPorta(player, masmorra, monstros);
                    break;

                default:
                    System.out.println("Ação inválida!");
                    break;
            }
        } while(acao != 0);

        scanner.close();
    }

    private static void listarItensInventario(Jogador player) {
        System.out.println("Jogo mostra:\nListando itens do inventário");
        player.getInventario().listarItens();
    }

    private static void equiparItensDoInventario(Jogador player) {
        String item;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Os itens disponíveis para serem equipados são:");
        player.getInventario().listarItens();

        List<String> partesDoCorpo = Arrays.asList(
        "\nQual item você deseja equipar na cabeça?\n",
        "\nQual item você deseja equipar no corpo?\n",
        "\nQual item você deseja equipar na mao?\n",
        "\nQual item você deseja equipar no pe?\n"
        );

        for(String frase: partesDoCorpo){
            boolean item_equipado;

            do {
                System.out.printf(frase);
                item = scanner.nextLine();
                item_equipado = player.equiparItem(item);
                if(!item_equipado) {
                    System.out.println("Item inexistente");
                }
            } while(!item_equipado);   
        }
        scanner.close();
    }


    private static void venderItensDoInventario(Jogador player) {
        String item = null;
        ArrayList<String> itens_para_vender = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Listando os itens que podem ser vendidos:");
        player.getInventario().listarItens();
        System.out.println("\nQuais itens deseja vender?\n" +
                            "Digite o nome dos itens a serem vendidos." +
                            "Caso deseje parar de vender digite parar");

        item = scanner.nextLine();
        while(!item.equals("parar")){
            item = scanner.nextLine();
            itens_para_vender.add(item);
        }

    if (player.venderItens(itens_para_vender)) {
        System.out.println("Itens vendidos com sucesso!");
    } else {
        System.out.println("Não foi possível vender os itens.");
    }

        scanner.close();
    }


    private static void informacoesJogador(Jogador player) {
        player.toString();
    }


    private static void abrirPorta(
        Jogador player, 
        Masmorra masmorra, 
        List<Monstro> monstros 
        ) {

        Resultado resultado_batalha;
        
        Random randomNumbers = new Random();

        Item item;
        List<Item> itens_aleatorios = new ArrayList<Item>();
        
        Monstro monstro_batalha;
        
        int monstro_ou_item;

        monstro_ou_item = randomNumbers.nextInt(2);

        switch(monstro_ou_item) {
            case 0:
                item = masmorra.abrirPortaItem(player);
                player.getInventario().adicionarItem(item);
                break;
                

            case 1:
                monstro_batalha = masmorra.abrirPortaMonstro(player);
                resultado_batalha = CampoDeBatalha.batalharContraMonstro(monstro_batalha, player);
                
                switch(resultado_batalha) {
                    case Resultado.VITORIA:
                        itens_aleatorios = masmorra.getTesouros().pegarItensAleatorios(monstro_batalha.getTesouros());
                        for(int i = 0; i < itens_aleatorios.size(); i++) {
                            player.getInventario().adicionarItem(itens_aleatorios.get(i));
                        }
                        System.out.println("VITORIA! O monstro foi derrotado!");
                        System.out.printf("%d Itens foram adicionados ao seu inventário", monstro_batalha.getTesouros());

                        break;

                    case Resultado.DERROTA:
                        player.setNivel(player.getNivel() - monstro_batalha.getNiveisPerdidos());
                        System.out.printf("Voce foi derrotado! %d Niveis foram perdidos.",
                                            monstro_batalha.getNiveisPerdidos());
                        
                        break;

                    case Resultado.FUGA:
                        System.out.println("Fuga bem sucedida!");
                        
                        break;
                }
                break;
        }
    }
}
