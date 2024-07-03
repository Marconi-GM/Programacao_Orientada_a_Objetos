public class MunchkinMain {

    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo();
        
        LerJogadores jogadores = new LerJogadores();
        jogadores.lerArquivo(jogo, "/home/marconi/Desktop/UNICAMP/1S2024/MC322 - Programação Orientada a Objetos/Laboratórios/laboratorio-4-Marconi-GM/Munchkin/src/Jogadores.xml");

        LerMonstros monstros = new LerMonstros();
        monstros.lerArquivo(jogo, "/home/marconi/Desktop/UNICAMP/1S2024/MC322 - Programação Orientada a Objetos/Laboratórios/laboratorio-4-Marconi-GM/Munchkin/src/Monstros.xml");

        LerTesouros itens = new LerTesouros();
        itens.lerArquivo(jogo, "/home/marconi/Desktop/UNICAMP/1S2024/MC322 - Programação Orientada a Objetos/Laboratórios/laboratorio-4-Marconi-GM/Munchkin/src/Itens.xml");

        jogo.loopDeJogo();
    }
        
}
