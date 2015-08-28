package computacao_grafica.geometria.formas;

import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Triangulo;

public class Triangulo2D {

	private Triangulo triangulo;
	
	private Graphics g;
	
	public Triangulo2D(Triangulo t, Graphics g){
		this.triangulo = t;
		this.g = g;
	}
	
	public void desenharTriangulo(){
		SegmentoDeReta2D aresta;
		
		aresta = new SegmentoDeReta2D(this.triangulo.getArestaA(), this.g);
		aresta.desenharSegmentoReta();
		
		
		aresta = new SegmentoDeReta2D(this.triangulo.getArestaB(), this.g);
		aresta.desenharSegmentoReta();
		
		
		aresta = new SegmentoDeReta2D(this.triangulo.getArestaC(), this.g);
		aresta.desenharSegmentoReta();
	}

	

}
