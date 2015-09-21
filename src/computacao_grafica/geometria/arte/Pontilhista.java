package computacao_grafica.geometria.arte;

import java.awt.Graphics;

import computacao_grafica.geometria.formas.Ponto2D;

public abstract class Pontilhista {

	protected void pontilhar(Ponto2D ponto, Graphics g){
		g.setColor(ponto.get_cor());
		g.fillOval((int)ponto.getX(), (int)ponto.getY() -1, 3, 3);// mais visivel (r = 3 pixels)
		g.drawString(ponto.get_str(), (int)ponto.getX() + 5, (int)ponto.getY());
	}
	
}
