package computacao_grafica.geometria.formas;

import static java.awt.Color.RED;

import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Circunferencia;
import computacao_grafica.geometria.matematica.Ponto;

public class Circunferencia2D implements Forma2D{

	//TODO Fazer o algoritmo de espelhamento para otimizar a circunferência.
	
	private Circunferencia circunferencia;
	
	private Graphics g;
	
	public Circunferencia2D(Circunferencia c, Graphics g){
		this.circunferencia = c;
		this.g = g;
	}
	
	public Circunferencia2D(Ponto a, Ponto b, Graphics g){
		this.circunferencia = new Circunferencia(a, b);
		this.g = g;
	}
	
	private void desenharCircunferencia(){
		Ponto2D p;
		for(double i = 0.0; i <= 360.0; i+=0.5){
			p = new Ponto2D(circunferencia.getPontoDaCircunferencia(i), RED, this.g);
			p.desenhar();
		}
	}
	
	@Override
	public void desenhar(){
		this.desenharCircunferencia();
	}

	

}
