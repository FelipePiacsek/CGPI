package computacao_grafica.geometria.formas;

import java.awt.Graphics;
import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;

public class Retangulo2D implements Forma2D{

	private Retangulo retangulo;
	
	private Graphics g;
	
	public Retangulo2D(Retangulo r, Graphics g){
		this.retangulo = r;
		this.g = g;
	}
	
	
	public Retangulo2D(Ponto a, Ponto b, Graphics g){
		this.retangulo = new Retangulo(a, b);
		this.g = g;
	}
	
	
	
	private void desenharRetangulo(){
		SegmentoDeReta2D aresta;
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaA(), this.g);
		aresta.desenhar();
		
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaB(), this.g);
		aresta.desenhar();
		
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaC(), this.g);
		aresta.desenhar();
		
		
		aresta = new SegmentoDeReta2D(this.retangulo.getArestaD(), this.g);
		aresta.desenhar();
		
	}

	@Override
	public void desenhar() {
		this.desenharRetangulo();
	}


	@Override
	public Set<Ponto> getPontos() {
		return null;
	}


	@Override
	public Retangulo getRetanguloQueCircunscreve() {
		return this.retangulo;
	}

	

}
