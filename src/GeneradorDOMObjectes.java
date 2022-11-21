import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//////////////////////////////////////////////////  XML EMPLOYEE ///////////////////////////////////////////////////////////

public class GeneradorDOMObjectes {
	private List<Employee> empleats = new ArrayList<Employee>();

	public static void main(String[] args) {
		GeneradorDOMObjectes gen = new GeneradorDOMObjectes();
		try {
			gen.guardaObjectes();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
        }
	
	public GeneradorDOMObjectes() {
		empleats.add(new Employee("Ana", "Rebollo", 34, 178, "Enginyera Tecnica"));
		empleats.add(new Employee("Sandra", "Fernandez", 55, 165, "Cap departament"));
		empleats.add(new Employee("Juan", "Doe", 19, 190, "Practiques"));
        }
	
	public void guardaObjectes() throws IOException {
		try (FileWriter writer = new FileWriter("empleats_XML.xml")) {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        
/////// AFEGIM UN PAS MÉS I UTILITZEM DOMImplementation. ENS PERMET AFEGIR UN ESPAI DE NOMS (NAMESPACES) AL NOSTRE XML /////////
			DOMImplementation domImplementation = documentBuilder.getDOMImplementation(); 
			Document document = domImplementation.
					createDocument("http://www.elmeunamespace.com",
							"empleats", null);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			document.setXmlVersion("1.0");

			for (Employee empleat : empleats) {			
				Element arrel = document.createElement("empleat");
				document.getDocumentElement().appendChild(arrel);
				
				crearElement("nom", empleat.getName(), arrel, document);
				crearElement("cognom", empleat.getSurname(), arrel, document);
				crearElement("edat", Integer.toString(empleat.getAge()), arrel, document);
				crearElement("mida", Float.toString(empleat.getHeight()), arrel, document);
				crearElement("carrec", empleat.getJob(), arrel, document);
			}
			Source source = new DOMSource(document); 
			Result result = new StreamResult(writer);

			Transformer transformerFactory= TransformerFactory.newInstance().newTransformer();
			transformerFactory.setOutputProperty(OutputKeys.INDENT, "yes");
			transformerFactory.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformerFactory.transform(source, result);
			
			Result console = new StreamResult(System.out);
			transformerFactory.transform(source, console);
                        
        ///////////////// HEM UNIT TOTES TOTES LES EXCEPTIONS I LES HEM TRANSFORMAT EN UN SOL TIPUS ///////////                
		} catch (ParserConfigurationException | TransformerException | IOException e) { 
			throw new IOException(e);
		}
        //////////////////////////////////////////////////////////////////////////////////////////////////////        
	}
        
	////////////////// IMPLEMENTEM EL MÈTODE crearElement() PER EVITAR REPETIR CODI //////////////////////
	private static void crearElement(String dada, String valor, Element arrel, Document document) {
		Element e = document.createElement(dada);
		Text text = document.createTextNode(valor);
		arrel.appendChild(e);
		e.appendChild(text);	
	}
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
}