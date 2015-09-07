package computacao_grafica.geometria.formas;

import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Triangulo;

public class Triangulo2D implements Forma2D{

	private Triangulo triangulo;
	
	private SegmentoDeReta2D arestaA;

	private SegmentoDeReta2D arestaB;
	
	private SegmentoDeReta2D arestaC;
	
	private Graphics g;
	
	public Triangulo2D(Triangulo t, Graphics g){
		this.triangulo = t;
		this.g = g;
		arestaA = new SegmentoDeReta2D(this.triangulo.getArestaA(), this.g);
		arestaB = new SegmentoDeReta2D(this.triangulo.getArestaB(), this.g);
		arestaC = new SegmentoDeReta2D(this.triangulo.getArestaC(), this.g);
	}
	
	public Triangulo2D(Ponto a, Ponto b, Graphics g){
		Ponto alfa = new Ponto(b.getX() + a.calcularDistancia(b), b.getY());
		Ponto beta= new Ponto(b.getX() - a.calcularDistancia(b), b.getY());
		this.triangulo = new Triangulo(a, alfa, beta);
		this.g = g;
		arestaA = new SegmentoDeReta2D(this.triangulo.getArestaA(), this.g);
		arestaB = new SegmentoDeReta2D(this.triangulo.getArestaB(), this.g);
		arestaC = new SegmentoDeReta2D(this.triangulo.getArestaC(), this.g);
	}
	private void desenharTriangulo(){
		arestaA.desenhar();
		arestaB.desenhar();
		arestaC.desenhar();
	}

	@Override
	public void desenhar() {
		this.desenharTriangulo();
	}

}
