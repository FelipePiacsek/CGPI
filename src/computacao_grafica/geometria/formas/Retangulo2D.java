package computacao_grafica.geometria.formas;

import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;

public class Retangulo2D implements Forma2D{

	private Retangulo retangulo;
	
	private SegmentoDeReta2D arestaA;

	private SegmentoDeReta2D arestaB;
	
	private SegmentoDeReta2D arestaC;
	
	private SegmentoDeReta2D arestaD;
	
	private Graphics g;
	
	public Retangulo2D(Retangulo r, Graphics g){
		this.retangulo = r;
		this.g = g;
		arestaA = new SegmentoDeReta2D(this.retangulo.getArestaA(), this.g);
		arestaB = new SegmentoDeReta2D(this.retangulo.getArestaB(), this.g);
		arestaC = new SegmentoDeReta2D(this.retangulo.getArestaC(), this.g);
		arestaD = new SegmentoDeReta2D(this.retangulo.getArestaD(), this.g);
	}
	
	
	public Retangulo2D(Ponto a, Ponto b, Graphics g){
		this.retangulo = new Retangulo(a, b);
		this.g = g;
		arestaA = new SegmentoDeReta2D(this.retangulo.getArestaA(), this.g);
		arestaB = new SegmentoDeReta2D(this.retangulo.getArestaB(), this.g);
		arestaC = new SegmentoDeReta2D(this.retangulo.getArestaC(), this.g);
		arestaD = new SegmentoDeReta2D(this.retangulo.getArestaD(), this.g);
	}
	
	
	
	private void desenharRetangulo(){
		arestaA.desenhar();
		arestaB.desenhar();
		arestaC.desenhar();
		arestaD.desenhar();
	}

	@Override
	public void desenhar() {
		this.desenharRetangulo();
	}

}
