/* SUGESTÕES AOS PROFESSORES/PED's SOBRE OS LABs
 * 
 * Professor/PED's, eu entendo a ideia do labs e acho bacana. O problema é que os
 * labs tem um problema grande na forma e maneira que são pedidos.
 * Muitas vezes a dificuldade não está na implentação de algo ou como manipular tal
 * estrutura. Muitas vezes, ela reside no fato de como vocês pedem que seja feito.
 * As implementações que vocês pedem são vagas, podendo ser feitas de inúmeras maneiras,
 * o que não é um problema, se você souber onde que chegar e o que fazer com o resultado.
 * A questão é que até isso está ficando vago.
 * É como andar sem saber pra onde ir e torcer pra estar indo na direção certa.
 * Nesse lab trombei com algumas dificuldades que, creio eu, seriam facilmente 
 * resolvidas se fossem um pouco mais detalhadas nos PDF's.
 * 
 * Algo que ajudaria seria deixar um exemplo de saída e de entrada.
 * Espero que entendam meu ponto <3
 * Mto obrigado :D
 */


import java.util.ArrayList;

public class MunchkinMain {
    public static void main(String[] args){

        // =========================================
        // Criando itens
        
        /* Poderia ter colocado as classes compatíveis dos itens como uma lista 
         * de classes (ou strings, nomes das classes) e adicionar as classes
         * compatives pelo construtor.
         * Optei por acrescentá-las por um método publico, no qual se coloca o
         * nome da classe.
         */
        Item armadura1, armadura2, armadura3;
        Item arma1, arco_flecha, arma2, arma3;
        
        armadura1 = new Item(
        "Peitoral de espinhos", 
        "armadura",
        125,
        99,
        "PEQuenO");

        armadura1.setClassesCompatives("Ladrao");
        armadura1.setClassesCompatives("Guerreiro");


        armadura2 = new Item(
        "Elmo alado", 
        "Elmo",
        80,
        25,
        "Pequeno");

        armadura2.setClassesCompatives("Mago");


        armadura3 = new Item(
        "Botas aladas", 
        "Botas",
        40,
        50,
        "pequeno");

        armadura3.setClassesCompatives("Mago");
        
        
        arma1 = new Item(
        "Espada longa",
        "Espada",
        300,
        175,
        "grande");

        arma1.setClassesCompatives("Guerreiro");
    

        arma2 = new Item(
        "Cutelo sujo",
        "Arma Branca",
        100,
        75,
        "pequeno");

        arma2.setClassesCompatives("Ladrao");
        arma2.setClassesCompatives("Guerreiro");


        arma3 = new Item(
        "Espada Curvada",
        "Espada",
        350,
        200,
        "grande");

        arma3.setClassesCompatives("Guerreiro");
        arma3.setClassesCompatives("Ladrao");


        arco_flecha = new Item(
        "Arco e Flecha",
        "Arma de distância",
        425,
        300,
        "grande");

        arco_flecha.setClassesCompatives("Ladrao");
        arco_flecha.setClassesCompatives("Mago");


        // =========================================
        // Criando Monstro

        Monstro ogro;
        ArrayList<Item> tesouros;

        tesouros = new ArrayList<Item>();
        tesouros.add(arco_flecha);
        tesouros.add(arma2);
        ogro = new Monstro("Bob", 130, 20, tesouros);

        System.out.println(ogro.toString());


        // =========================================
        // Criando um MAGO

        /* Os prints estão com comentários, dessa forma só basta você tirar os comentários e rodar 
         * o programa para ver as saídas
         */
        Jogador player1;
        ArrayList<Item> itens;

        itens = new ArrayList<Item>();
        itens.add(armadura2);
        itens.add(armadura3);
        
        Raca raca = new Raca("Jogador do vasco", "vasconha", 10);

        Mago mago = new Mago("Mago");

        try {
            player1 = new Jogador("Vasconha", 100, raca, mago, itens);

            player1.inventario.adicionarItem(arco_flecha);
            
            player1.inventario.removeItem("Botas aladas");
            

            Mago teste = (Mago)player1.getClasse();

            System.out.println(teste.getItemCabeca());
            player1.inventario.listarInventario();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
