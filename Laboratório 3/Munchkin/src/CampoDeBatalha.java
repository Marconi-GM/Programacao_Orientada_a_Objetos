import java.util.Random;

public class CampoDeBatalha {
    public static Resultado batalharContraMonstro(
    Monstro monstro, 
    Jogador player
    ) {
        Resultado resultado;

        Random randomNumbers = new Random();
        
        int poder_jogador = player.poderJogador();
        int poder_monstro = monstro.getPoder();
        
        int dado;

        if(poder_jogador > poder_monstro) {
            resultado = Resultado.VITORIA;
        } else {
            dado = randomNumbers.nextInt(6);

            // aqui, como os valores de dado vão de 0 a 5, 0 5 representa o 6
            // e o 4 representa o 5
            if(dado == 4 || dado == 5) {
                resultado = Resultado.FUGA;
            } else {
                resultado = Resultado.DERROTA;
            }
        }
        
        return resultado;
    }
}
