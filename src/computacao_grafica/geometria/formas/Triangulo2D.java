package computacao_grafica.geometria.formas;

import java.awt.Graphics;
import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;
import computacao_grafica.geometria.matematica.Triangulo;

public class Triangulo2D implements Forma2D{

	private Triangulo triangulo;
	
	private Graphics g;
	
	public Triangulo2D(Triangulo t, Graphics g){
		this.triangulo = t;
		this.g = g;
	}
	
	public Triangulo2D(Ponto a, Ponto b, Graphics g){
		Ponto alfa = new Ponto(b.getX() + a.calcularDistancia(b), b.getY());
		Ponto beta= new Ponto(b.getX() - a.calcularDistancia(b), b.getY());
		this.triangulo = new Triangulo(a, alfa, beta);
		this.g = g;
	}
	private void desenharTriangulo(){
		SegmentoDeReta2D aresta;
		
		aresta = new SegmentoDeReta2D(this.triangulo.getArestaA(), this.g);
		aresta.desenhar();
		
		
		aresta = new SegmentoDeReta2D(this.triangulo.getArestaB(), this.g);
		aresta.desenhar();
		
		
		aresta = new SegmentoDeReta2D(this.triangulo.getArestaC(), this.g);
		aresta.desenhar();
	}

	@Override
	public void desenhar() {
		this.desenharTriangulo();
	}

	@Override
	public Set<Ponto> getPontos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retangulo getRetanguloQueCircunscreve() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
