package computacao_grafica.geometria.formas;

import static java.awt.Color.RED;

import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Circunferencia;

public class Circunferencia2D {

	private Circunferencia circunferencia;
	
	private Graphics g;
	
	public Circunferencia2D(Circunferencia c, Graphics g){
		this.circunferencia = c;
		this.g = g;
	}
	
	public void desenharCircunferencia(){
		Ponto2D p;
		for(double i = 0.0; i <= 360.0; i+=0.5){
			p = new Ponto2D(circunferencia.getPontoDaCircunferencia(i), RED);
			p.desenharPonto(this.g);
		}
	}

	

}
