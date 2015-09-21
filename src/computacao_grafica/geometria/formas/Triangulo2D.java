package computacao_grafica.geometria.formas;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;
import computacao_grafica.geometria.matematica.Triangulo;

public class Triangulo2D extends Forma2D{

	private Triangulo triangulo;
	
	private SegmentoDeReta2D arestaA;

	private SegmentoDeReta2D arestaB;
	
	private SegmentoDeReta2D arestaC;
	
	public Triangulo2D(Triangulo t){
		this.triangulo = t;
		arestaA = new SegmentoDeReta2D(this.triangulo.getArestaA());
		arestaB = new SegmentoDeReta2D(this.triangulo.getArestaB());
		arestaC = new SegmentoDeReta2D(this.triangulo.getArestaC());
		adicionarPontos();
	}
	
	public Triangulo2D(Ponto a, Ponto b){
		Ponto alfa = new Ponto(b.getX() + a.calcularDistancia(b), b.getY(), ModoCoordenada.ABSOLUTA_JANELA);
		Ponto beta= new Ponto(b.getX() - a.calcularDistancia(b), b.getY(), ModoCoordenada.ABSOLUTA_JANELA);
		this.triangulo = new Triangulo(a, alfa, beta);
		arestaA = new SegmentoDeReta2D(this.triangulo.getArestaA());
		arestaB = new SegmentoDeReta2D(this.triangulo.getArestaB());
		arestaC = new SegmentoDeReta2D(this.triangulo.getArestaC());
		adicionarPontos();
	}

	private void adicionarPontos() {
		addAllPontos(arestaA.getPontos());
		addAllPontos(arestaB.getPontos());
		addAllPontos(arestaC.getPontos());
	}
	
}
