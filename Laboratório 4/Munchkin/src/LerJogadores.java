import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class LerJogadores implements LeArquivo{

    public void lerArquivo(Jogo jogo, String path) {
        List<Jogador> jogadores = new ArrayList<>();

        try {
            File file = new File(path);
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
        
            NodeList nodeList = doc.getElementsByTagName("Jogador");
        
            for(int i = 0; i < nodeList.getLength(); i++) {
                Element jogadorElement = (Element)nodeList.item(i);

                String nome = jogadorElement.getElementsByTagName ("nome").item(0).getTextContent();
                int nivel = Integer.parseInt( jogadorElement.getElementsByTagName ("nivel").item(0).getTextContent());
                Raca raca = Raca.valueOf( jogadorElement.getElementsByTagName("raca").item(0).getTextContent());                
                Classe classe = Classe.valueOf( jogadorElement.getElementsByTagName("classe").item(0).getTextContent());   
                
                Jogador jogador = new Jogador( nome , nivel , raca , classe , new Inventario(10));
                jogadores.add(jogador);
            }

         } catch(Exception e) {
            System.err.println ("Erro ao ler o arquivo: " + e. getMessage () );
            e.printStackTrace();
        }
        
        jogo.setJogadores(jogadores);
    }
}
