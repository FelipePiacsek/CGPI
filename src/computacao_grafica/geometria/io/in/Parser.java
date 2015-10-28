package computacao_grafica.geometria.io.in;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.FormaPoligonal2D;
import computacao_grafica.geometria.formas.Retangulo2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;

public class Parser {
	public List<Forma2D> ler(String filePath) {
		List<Forma2D> formas = new ArrayList<Forma2D> ();
		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			List<Retangulo2D> retangulos = RetanguloParser.extrairRetangulos(doc.getElementsByTagName("Retangulo"));
			List<SegmentoDeReta2D> retas = SegmentoDeRetaParser.extrairSegmentos(doc.getElementsByTagName("Reta"));
			List<FormaPoligonal2D> poligonos = FormaPoligonalParser.extrairPoligonos(doc.getElementsByTagName("Poligono"));
			List<FormaPoligonal2D> linhasPoligonais = FormaPoligonalParser.extrairLinhasPoligonais(doc.getElementsByTagName("LinhaPoligonal"));
			List<Circunferencia2D> circunferencias = CircunferenciaParser.extrairCircunferencias(doc.getElementsByTagName("Circulo"));
			formas.addAll(retangulos);
			formas.addAll(retas);
			formas.addAll(poligonos);
			formas.addAll(linhasPoligonais);
			formas.addAll(circunferencias);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return formas;
	}


}
