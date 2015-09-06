package computacao_grafica.geometria.formas;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;
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

	@Override
	public Set<Ponto> getPontos() {
		Set<Ponto> pontos = new HashSet<Ponto>();
		pontos.addAll(arestaA.getPontos());
		pontos.addAll(arestaB.getPontos());
		pontos.addAll(arestaC.getPontos());
		return pontos;
	}

	@Override
	public Retangulo getRetanguloQueCircunscreve() {
		double xA = triangulo.getPontoA().getX();
		double xB = triangulo.getPontoB().getX();
		double xC = triangulo.getPontoC().getX();

		double yA = triangulo.getPontoA().getY();
		double yB = triangulo.getPontoB().getY();
		double yC = triangulo.getPontoC().getY();
		
		double menorX = min(xA, min(xB, xC));
		double menorY = min(yA, min(yB, yC));
		double maiorX = max(xA, max(xB, xC));
		double maiorY = max(yA, max(yB, yC));
		
		Ponto a = new Ponto(menorX - 1, menorY - 1);
		Ponto b = new Ponto(maiorX + 1, maiorY + 1);

		return new Retangulo(a, b);
	}

	

}
