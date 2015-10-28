package computacao_grafica.geometria.io.in;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;

public abstract class RetanguloParser extends AbstractForma2DParser{

	public static List<Retangulo2D> extrairRetangulos(NodeList nodeRetangulos) {
		List<Retangulo2D> retangulos = new ArrayList<Retangulo2D>();
		for (int i = 0; i < nodeRetangulos.getLength(); i++) {
			Node nNode = nodeRetangulos.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Retangulo2D retangulo = getRetanguloFromNode((Element)nNode);
				retangulos.add(retangulo);
			}
			
		}
		return retangulos;
	}

	private static Retangulo2D getRetanguloFromNode(Element eElement) {
		Ponto2D ponto2DA = getPonto2DFromElement(eElement, 0);
		Ponto2D ponto2DB = getPonto2DFromElement(eElement, 1);
		return new Retangulo2D(ponto2DA, ponto2DB);
	}
}
