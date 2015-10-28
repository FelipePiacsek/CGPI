package computacao_grafica.geometria.io.in;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;

public abstract class SegmentoDeRetaParser extends AbstractForma2DParser{

	private static SegmentoDeReta2D getRetaFromNode(Node nNode) {
		Element eElement = (Element) nNode;
		Ponto2D ponto2DA = getPonto2DFromElement(eElement, 0);
		Ponto2D ponto2DB = getPonto2DFromElement(eElement, 1);
		return new SegmentoDeReta2D(ponto2DA, ponto2DB);
	}

	public static List<SegmentoDeReta2D> extrairSegmentos(NodeList nodeRetas) {
		List<SegmentoDeReta2D> retas = new ArrayList<SegmentoDeReta2D>();
		for (int i = 0; i < nodeRetas.getLength(); i++) {
			Node nNode = nodeRetas.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				SegmentoDeReta2D reta = getRetaFromNode(nNode);
				retas.add(reta);
			}
		}
		return retas;
	}
}
