import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class LerMonstros implements LeArquivo{

    public void lerArquivo(Jogo jogo, String path) {
        List<Monstro> monstros = new ArrayList<>();

        try {

            /* Comentários a baixo são para me ajudar no futuro e, portanto, não
             * são extrememente corretos e ou precisos
             */
            
            // Criando um ponteiro do tipo FILE (chamado file) e passando path 
            // que é o endereço do arquivo
            File file = new File(path);

            // Aqui chama a fábrica para criar uma instancia de Document builder factory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // esse DocumentBuilderFactory possui um método newDocumentBuilder
            // esse método devolve um DocumentBuilder e por isso deve ser criado
            // o objeto dBuilder para receber esse DocumentBuilder  
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // esse dBuilder, por sua vez possui o método parse, esse método
            // é o método que """formatará""" seu arquivo de uma maneira que você
            // possa manipular. Ele devolve um Document
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize(); 

            // aqui criamos uma lista de nós (cada tag com <tag> do arquivo xml
            // é um nó) e dizemos que queremos separar esses nós plea tag <Monstro>
            NodeList nodeList = doc.getElementsByTagName("Monstro");

            for(int i = 0; i < nodeList.getLength(); i++) {

                // aqui cada objeto da sua node list será um elemento
                Element monstroElement = (Element)nodeList.item(i);

                // aqui se recebemos os atributos desse elemento
                String nome = monstroElement.getElementsByTagName("nome").item(0).getTextContent();
                int poder = Integer.parseInt(monstroElement.getElementsByTagName("poder").item(0).getTextContent());
                int tesouros = Integer.parseInt(monstroElement.getElementsByTagName("tesouros").item(0).getTextContent());
                int niveisPerdidos = Integer.parseInt(monstroElement.getElementsByTagName("niveisPerdidos").item(0).getTextContent());

                // aqui instanciamos um novo objeto com esses atributos, e o
                // adicionamos na lista
                Monstro monstro = new Monstro(nome, poder, tesouros, niveisPerdidos);
                monstros.add(monstro);
            }
        
        } catch(Exception error) {
            System.err.println("Erro ao ler o arquivo: " + error.getMessage());
            error.printStackTrace();
        }

        jogo.setMonstros(monstros);
    }
}
