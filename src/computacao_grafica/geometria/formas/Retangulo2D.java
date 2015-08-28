package computacao_grafica.geometria.formas;

import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Retangulo;

public class Retangulo2D {

	private Retangulo retangulo;
	
	private Graphics g;
	
	public Retangulo2D(Retangulo r, Graphics g){
		this.retangulo = r;
		this.g = g;
	}
	
	public void desenharRetangulo(){
		SegmentoDeReta2D aresta;
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaA(), this.g);
		aresta.desenharSegmentoReta();
		
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaB(), this.g);
		aresta.desenharSegmentoReta();
		
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaC(), this.g);
		aresta.desenharSegmentoReta();
		
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaD(), this.g);
		aresta.desenharSegmentoReta();
		
	}

	

}
