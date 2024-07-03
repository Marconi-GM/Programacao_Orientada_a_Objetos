public class Monstro {

    private final String nome;

    private int poder;
    private int tesouros;
    private int niveisPerdidos;

    public Monstro(String nome, int poder_monstro, int tesouros_monstro,
                   int niveis_perdidos_se_derrotado) {
                
                this.nome = nome;
                this.poder = poder_monstro;
                this.tesouros = tesouros_monstro;
                this.niveisPerdidos = niveis_perdidos_se_derrotado;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getTesouros() {
        return tesouros;
    }

    public void setTesouros(int tesouros) {
        this.tesouros = tesouros;
    }

    public int getNiveisPerdidos() {
        return niveisPerdidos;
    }

    public void setNiveisPerdidos(int niveisPerdidos) {
        this.niveisPerdidos = niveisPerdidos;
    }

    @Override
    public String toString() {
        return String.format("\t\t---- Monstro: %s ----\n" +
                            "Poder: %d\n" +
                            "Quantiade de tesouros: %d\n" +
                            "Niveis perdidos se derrotado por %s: %d\n",
                            this.getNome(), this.getPoder(), this.getTesouros(),
                            this.getNome(), this.getNiveisPerdidos());
    }
}
