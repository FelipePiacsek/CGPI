package computacao_grafica.geometria.arte;

import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_PREVIEW;

import java.awt.Graphics;
import java.util.Set;

import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;

public class GeorgeSeurat extends Pontilhista{

	private Graphics graphics;
	
	public GeorgeSeurat(Graphics graphics) {
		this.graphics = graphics;
	}
	
	public void desenharPreview(Forma2D forma){
		for (Ponto2D ponto : forma.getPontos()) {
			ponto.setModoCoordenada(ABSOLUTA_PREVIEW);
			super.pontilhar(ponto, graphics);
		}
		
	}

	public void desenharRecorte(Set<Ponto2D> recorte) {
		for (Ponto2D ponto : recorte) {
			ponto.setModoCoordenada(ABSOLUTA_PREVIEW);
			super.pontilhar(ponto, graphics);
		}		
	}
}
