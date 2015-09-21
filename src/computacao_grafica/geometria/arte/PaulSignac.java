package computacao_grafica.geometria.arte;

import static computacao_grafica.geometria.main.ParametrosConfiguracao.LIMITE_MINIMO_HORIZONTAL;
import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_JANELA;

import java.awt.Graphics;

import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;

public class PaulSignac extends Pontilhista {

	private Graphics graphics;
	
	public PaulSignac(Graphics graphics) {
		this.graphics = graphics;
	}

	public void desenharJanela(Forma2D forma){
		for (Ponto2D ponto : forma.getPontos()) {
			ponto.setModoCoordenada(ABSOLUTA_JANELA);
			int x =  (int)ponto.getX();
		    if(x > LIMITE_MINIMO_HORIZONTAL){
		    	super.pontilhar(ponto, graphics);
		    }
		}
	}
	
}
