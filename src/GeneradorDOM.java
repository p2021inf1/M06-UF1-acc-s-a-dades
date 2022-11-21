import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class GeneradorDOM {
    public static void main(String[] args) {
	try (FileWriter writer = new FileWriter("C:/Users/tonla/empleats_XML_2.xml")) {
            
             //////////////////////////////////////// CREACI� DOCUMENT XML AMB ARBRE, ELEMENTS, ATRIBUTS... /////////////////////////////////////////////
             
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //creem un DocumentBuilderFactory amb el m�tode est�tic newInstance(). Despr�s, creem un objecte DocumentBuilder().
            Document document = builder.newDocument(); //creem un nou Document.
            document.setXmlVersion("1.0"); //assignem la versi� d�XML que utilitzem.
           // document.setXmlStandalone(true);
			
            Element elementEmpleats = document.createElement("empleats"); //creem l�element empleats.
            document.appendChild(elementEmpleats); //afegim empleats com element arrel del document.

            Element elementEmpleat = document.createElement("empleat"); //creem un element empleat.
            elementEmpleat.setAttribute("id", "1"); //assigna un atribut anomenat id amb valor 1 a l�empleat.
            document.getDocumentElement().appendChild(elementEmpleat); //afegeix el nou empleat a l�element arrel del document.

            Element elementCognom = document.createElement("cognom"); //creem un element cognom.
            Text text = document.createTextNode("Gasol"); //creem un element de text.
            elementCognom.appendChild(text); //afegim l�element de text al cognom.
            elementEmpleat.appendChild(elementCognom); //afegim el cognom a l'empleat.

            
            ///////////////////////////////////////// PASSOS A SEGUIR PER LA GENERACI� DEL FITXER ///////////////////////////////////////////////////////
            
            Source source = new DOMSource(document); //especifiquem que l�origen de la transformaci� ser� el nostre document.
            Result result = new StreamResult(writer); //especifiquem que el resultat de la transformaci� ser� el fitxer que hem preparat al principi.

            Transformer transformer = TransformerFactory.newInstance().newTransformer(); //obtenim una TransformerFactory i a partir d�ella un Transformer.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // indiquem que volem identar la sortida amb 5 espais. (lines 45 i 46)
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "5");
            transformer.transform(source, result); //fem la transformaci�. Aqu� �s on es genera el fitxer.

            Result console = new StreamResult(System.out); //especifiquem la consola com un altre resultat per a la transformaci�.
            transformer.transform(source, console); //transformem el document en un fitxer XML que es mostra per pantalla.
            
            
            ////////////////////////////////////// MISSATGE EN CAS D'ERROR ///////////////////////////////////////////////////////////////
            
	} catch (ParserConfigurationException | TransformerException | IOException e) {
            System.err.println(e.getMessage());
	}
    }
}