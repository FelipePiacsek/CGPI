package computacao_grafica.geometria.io.in;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import computacao_grafica.geometria.formas.FormaPoligonal2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public abstract class FormaPoligonalParser extends AbstractForma2DParser {

	public static List<FormaPoligonal2D> extrairPoligonos(NodeList nodePoligonos) {
		return extrair(nodePoligonos, true);
	}

	public static List<FormaPoligonal2D> extrairLinhasPoligonais(NodeList nodeLinhasPoligonais) {
		return extrair(nodeLinhasPoligonais, false);
	}

	private static List<FormaPoligonal2D> extrair(NodeList nodePoligonos, boolean fechar) {
		List<FormaPoligonal2D> formasPoligonais = new ArrayList<FormaPoligonal2D>();
		for (int i = 0; i < nodePoligonos.getLength(); i++) {
			Node nNode = nodePoligonos.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				FormaPoligonal2D forma = getFormaPoligonal(nNode, fechar);
				formasPoligonais.add(forma);
			}
		}
		return formasPoligonais;
	}

	private static FormaPoligonal2D getFormaPoligonal(Node nNode, boolean fechar) {
		FormaPoligonal2D formaPoligonal2D = new FormaPoligonal2D();
		Element eElement = (Element) nNode;
		List<Ponto2D> pontos2D = new ArrayList<Ponto2D>();
		int i = 0;
		for (i = 0; i < eElement.getElementsByTagName("Ponto").getLength(); i++) {
			pontos2D.add(getPonto2DFromElement(eElement, i));
		}
		for (i=0; i < pontos2D.size() - 1; i++) {
			formaPoligonal2D.addSegmento(new SegmentoDeReta(pontos2D.get(i), pontos2D.get(i+1)));
		}
		if(fechar){
			formaPoligonal2D.addSegmento(new SegmentoDeReta(pontos2D.get(0), pontos2D.get(pontos2D.size()-1)));
			formaPoligonal2D.fechar();
		}
		return formaPoligonal2D;
	}
}
