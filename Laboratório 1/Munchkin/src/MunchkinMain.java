public class MunchkinMain {
    public static void main(String[] args){
        Jogador player1 = new Jogador();

        player1.setNome("Johnny Cash");
        player1.setRaca("Elfo");
        player1.setClasse("Arqueiro");
        player1.setNivel(99);
        player1.setItemCabeca("Chapeu");
        player1.setItemCorpo("Gibao de couro");
        player1.setItemMaoDireita("Luva de couro");
        player1.setItemMaoEsquerda("Luva de couro");
        player1.setItemPe("Bota Texana");

        System.out.println(player1.toString());

        if(player1.possuiMaoVazia())
        {
            System.out.println("O jogador " + player1.getNome() + " possui alguma mão sem item equipado!\n");
        }

        else
        {
            System.out.println("O jogador " + player1.getNome() + " possui itens em ambas as mãos!\n");
        }


        Item instrumento = new Item();

        instrumento.setNome("Violão");
        instrumento.setTipo("Musical");
        instrumento.setValor(999);
        instrumento.setBonusPoder(10000);

        System.out.println(instrumento.toString());

        Monstro espectro = new Monstro();

        espectro.setNome("Ghost rider");
        espectro.setPoder(666);
        espectro.setQuantidade_Tesouros(9999);
        espectro.setNiveisPerdidos(80);

        System.out.println(espectro.toString());
    }
}
