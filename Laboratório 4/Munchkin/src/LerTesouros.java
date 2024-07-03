import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class LerTesouros implements LeArquivo{

    @Override
    public void lerArquivo(Jogo jogo, String path) {
        List<Item> itens = new ArrayList<>();

        try {
            File file = new File(path);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Item");

            for(int i = 0; i < nodeList.getLength(); i++) {
                Element itemElement = (Element)nodeList.item(i);

                String nome = itemElement.getElementsByTagName("nome").item(0).getTextContent();
                int bonusPoder = Integer.parseInt(itemElement.getElementsByTagName("bonusPoder").item(0).getTextContent());
                int valor = Integer.parseInt(itemElement.getElementsByTagName("valor").item(0).getTextContent());
                String tipo = itemElement.getElementsByTagName("tipo").item(0).getTextContent();
                boolean itemGrande = Boolean.parseBoolean(itemElement.getElementsByTagName("itemGrande").item(0).getTextContent());
                
                List<Classe> classesCompativeis = new ArrayList<Classe>();
                NodeList nodeList2 = itemElement.getElementsByTagName("classesCompativeis");
                for(int j = 0; j < nodeList2.getLength(); j++) {
                    classesCompativeis.add(Classe.valueOf(itemElement.getElementsByTagName("classe").item(j).getTextContent()));
                }
                
                List<Raca> racasCompativeis = new ArrayList<Raca>();
                NodeList nodeList3 = itemElement.getElementsByTagName("racasCompativeis");
                for(int k = 0; k < nodeList3.getLength(); k++) {
                    racasCompativeis.add(Raca.valueOf(itemElement.getElementsByTagName("raca").item(k).getTextContent()));
                }

                Item item = new Item(nome, bonusPoder, valor, tipo, itemGrande, classesCompativeis, racasCompativeis);
                itens.add(item);
            }
        
        } catch(Exception error) {
            System.err.println("Erro ao ler o arquivo: " + error.getMessage());
            error.printStackTrace();
        }

        jogo.setItens(itens);
    }
}
