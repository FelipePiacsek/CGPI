package computacao_grafica.geometria.io.in;

import java.awt.Color;

import org.w3c.dom.Element;

import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public abstract class AbstractForma2DParser {

	private static Color getColorFromElement(Element eElement){
		Element cor = (Element) eElement.getElementsByTagName("Cor").item(0);
		int r = Integer.valueOf(cor.getElementsByTagName("R").item(0).getTextContent());
		int g = Integer.valueOf(cor.getElementsByTagName("G").item(0).getTextContent());
		int b = Integer.valueOf(cor.getElementsByTagName("B").item(0).getTextContent());
		
		return new Color(r,g,b);
	}
	
	protected static Ponto2D getPonto2DFromElement(Element eElement, int index){
		Element ponto = (Element) eElement.getElementsByTagName("Ponto").item(index);
		double xA = Double.valueOf(ponto.getElementsByTagName("x").item(0).getTextContent());
		double yA = Double.valueOf(ponto.getElementsByTagName("y").item(0).getTextContent());

		Color color = getColorFromElement(eElement);

		Ponto2D ponto2DA = new Ponto2D(xA, yA, color, ModoCoordenada.NORMALIZADA);
		ponto2DA.setModoCoordenada(ModoCoordenada.ABSOLUTA_JANELA);
		
		return ponto2DA;
	}
}