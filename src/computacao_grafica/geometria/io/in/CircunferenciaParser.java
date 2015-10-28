package computacao_grafica.geometria.io.in;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Ponto2D;

public abstract class CircunferenciaParser extends AbstractForma2DParser{

	public static List<Circunferencia2D> extrairCircunferencias(NodeList nodeCircunferencias) {
		List<Circunferencia2D> circunferencias = new ArrayList<Circunferencia2D>();
		for (int i = 0; i < nodeCircunferencias.getLength(); i++) {
			Node nNode = nodeCircunferencias.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Circunferencia2D circunferencia = getCircunferenciaFromNode(nNode);
				circunferencias.add(circunferencia);
			}

		}
		return circunferencias;
	}

	private static Circunferencia2D getCircunferenciaFromNode(Node nNode) {
		Element eElement = (Element) nNode;
		Ponto2D centro = getPonto2DFromElement(eElement, 0);
		double raio = Double.valueOf(eElement.getElementsByTagName("Raio").item(0).getTextContent());
		return new Circunferencia2D(raio, centro);
	}
}
