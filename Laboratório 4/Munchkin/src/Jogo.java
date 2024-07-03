import java.util.ArrayList;
import java.util.List;  
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Jogo {

    Masmorra masmorra;

    List<Jogador> jogadores;
    List<Monstro> monstros;

    BauDeTesouros tesouros = new BauDeTesouros(15);

    public void loopDeJogo() throws Exception {
        this.setMasmorra(this.monstros, this.tesouros);
        this.inicializaItensJogador(this.jogadores.get(0));

        int acao = -1;

        System.out.println("===================================================");
        System.out.println("\t\tJogo Mostra:");

        // Aqui coloquei o jogador na posição 0 da lista de proprósito, caso
        // queira colocar outros jogadores, teria que colocar isso em um laço
        // estou ciente de que talvez essa não é a opção final do jogo
        // mas como criei apenas um jogador no arquivo Jogadores.XML então 
        // deixarei assim mesmo
        System.out.printf("Jogador: %s\n", jogadores.get(0).getNome());
        

        Scanner scanner = new Scanner(System.in);
        

       do {
            System.out.printf("\nO que você deseja fazer?\n");
            System.out.println("[1] - Listar itens do invetário.");
            System.out.println("[2] - Equipar itens do invetário.");
            System.out.println("[3] - Vender itens do inventário.");
            System.out.println("[4] - Ver informações do jogador.");
            System.out.println("[5] - Passar para abrir a porta.");
            System.out.println("[0] - Sair.");

            acao = Integer.parseInt(scanner.nextLine());

            switch(acao) {
                case 0:
                    break;

                case 1:
                    listarItensInventario(jogadores.get(0));
                    break;

                case 2:
                    equiparItensDoInventario(jogadores.get(0), scanner);
                    break;

                case 3:
                    venderItensDoInventario(jogadores.get(0), scanner);
                    break;

                case 4:
                    informacoesJogador(jogadores.get(0));
                    break;

                case 5:
                    abrirPorta(jogadores.get(0), masmorra, monstros, scanner);
                    break;

                default:
                    System.out.println("Ação inválida!");
                    break;
            }
        } while(acao != 0);

        scanner.close();
    }

    public void setMonstros(List<Monstro> monstros) {
        this.monstros = monstros;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setItens(List<Item> itens) {
        this.tesouros.setItens(itens);
    }

    public void setMasmorra(List<Monstro> monstros, BauDeTesouros bauTesouros) {
        this.masmorra = new Masmorra(monstros, tesouros);
    }

    private void inicializaItensJogador(Jogador player) {
        Random randomNumbers = new Random();

        String nome_item;

        int numeroAleatorio;
        int itensEquipados = 0;

        TipoItem parteCorpo;
        
        Item item;

        // for executado 4 vezes, uma para cada tipo de item
        while(itensEquipados < 4) {
            numeroAleatorio = randomNumbers.nextInt(this.tesouros.getItens().size());

            // item recebe um item aleatorio do bau de tesouros do jogo
            item = this.tesouros.getItens().get(numeroAleatorio);
            nome_item = item.getNome();
            parteCorpo = item.getTipoItem();
            
            switch(parteCorpo) {
                case TipoItem.CABECA:
                    // se player.getItemCabeca é nullo, então não tem um item
                    // já equipado nessa parte do corpo
                    if(player.getItemCabeca() == null)
                    {
                        player.setItemCabeca(tesouros.acessarItem(nome_item));
                        itensEquipados += 1;
                    }

                    break;

                case TipoItem.CORPO:
                    if(player.getItemCorpo() == null)
                    {
                        player.setItemCorpo(tesouros.acessarItem(nome_item));
                        itensEquipados += 1;
                    }
                    break;

                case TipoItem.PE:
                    if(player.getItemPe() == null)
                    {
                        player.setItemPe(tesouros.acessarItem(nome_item));
                        itensEquipados += 1;
                    }
                    break;

                case TipoItem.MAO:
                    if(player.getItemMaoDireita() == null && player.getItemMaoEsquerda() == null)
                    {
                        Item mao = tesouros.acessarItem(nome_item);

                        player.setItemMaoEsquerda(mao);
                        player.setItemMaoDireita(mao);
                        itensEquipados += 1;
                    }
                    break;
            }
        }
    }


    private static void listarItensInventario(Jogador player) {
        if(player.getInventario().getItens().size() == 0) {
            System.out.printf("\nO inventario do jogador esta vazio!\n" +
                              "Tente adicionar alguns itens...\n");
        } else {                      
            System.out.println("Jogo mostra:\nListando itens do inventário");
            player.getInventario().listarItens();
        }
    }


    private static void equiparItensDoInventario(Jogador player, Scanner scanner) {
        String item;

        if(player.getInventario().getItens().size() == 0) {
            System.out.printf("\nO inventario do jogador esta vazio!\n" +
                              "Tente adicionar alguns itens...\n");
        } else {
            System.out.println("Os itens disponíveis para serem equipados são:");
            player.getInventario().listarItens();

            // cria uma lista na qual os elementos são as partes do corpo
            // para ser usada mais abaixo
            List<String> partesDoCorpo = Arrays.asList(
        "\nQual item você deseja equipar na cabeça?\n",
            "\nQual item você deseja equipar no corpo?\n",
            "\nQual item você deseja equipar na mao?\n",
            "\nQual item você deseja equipar no pe?\n"
            );

            // para cada parte do corpo, pergunta qual item o jogador quer equipar
            for(String frase: partesDoCorpo){
                boolean item_equipado;

                System.out.println("Digite 'nenhum' caso não queira " + 
                                   "equipar item nessa parte do corpo");

                do {
                    // printa uma frase da lista de partes do corpo, acima
                    System.out.printf(frase);
                    item = scanner.nextLine();
                    
                    // caso o jogador não queria equipar nenhum item
                    if(item.toLowerCase().equals("nenhum")) {
                        // item equipado recebe true para sair do while
                        item_equipado = true;
                        // caso contrário
                    } else {
                        // equipar item devolverá true se obter sucesso ao
                        // tentar equipar ou false caso contrário
                        item_equipado = player.equiparItem(item);
                        if(!item_equipado) {
                            System.out.println("Item inexistente");
                        }
                    }
                } while(!item_equipado);   
            }
        }
    }


    private static void venderItensDoInventario(Jogador player, Scanner scanner) {

        if(player.getInventario().getItens().size() == 0) {
            System.out.printf("\nO inventario do jogador esta vazio!\n" +
                              "Tente adicionar alguns itens...\n");
        } else {
            String item = null;
            ArrayList<String> itens_para_vender = new ArrayList<String>();

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
        }
    }


    private static void informacoesJogador(Jogador player) {
        System.out.println(player.toString());
    }


    private static void abrirPorta(
        Jogador player, 
        Masmorra masmorra, 
        List<Monstro> monstros,
        Scanner scanner
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
                item = masmorra.abrirPortaItem(player, scanner);
                player.getInventario().adicionarItem(item);
                break;
                

            case 1:
                System.out.println("=========================");
                System.out.printf("\tA porta dos monstros foi aberta! A batalha " +
                                "começará!\n");

                monstro_batalha = masmorra.abrirPortaMonstro(player);
                resultado_batalha = CampoDeBatalha.batalharContraMonstro(monstro_batalha, player);
                
                switch(resultado_batalha) {
                    case Resultado.VITORIA:
                        itens_aleatorios = masmorra.getTesouros().pegarItensAleatorios(masmorra.getTesouros().getItens().size());
                        for(int i = 0; i < itens_aleatorios.size(); i++) {
                            player.getInventario().adicionarItem(itens_aleatorios.get(i));
                        }
                        System.out.printf("VITORIA! O monstro %s foi derrotado!\n", monstro_batalha.getNome());
                        System.out.printf("%d Itens foram adicionados ao seu inventário", monstro_batalha.getTesouros());

                        break;

                    case Resultado.DERROTA:
                        if(player.getNivel() - monstro_batalha.getNiveisPerdidos() < 0) {
                            player.setNivel(0);
                        } else {
                            player.setNivel(player.getNivel() - monstro_batalha.getNiveisPerdidos());
                        }

                        System.out.printf("Voce foi derrotado pelo monstro %s \n" + 
                                         "%d Niveis foram perdidos.\n",
                                         monstro_batalha.getNome().toUpperCase(), 
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
