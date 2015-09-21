package computacao_grafica.geometria.formas;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;

public class Retangulo2D extends Forma2D{

	private Retangulo retangulo;
	
	private SegmentoDeReta2D arestaA;

	private SegmentoDeReta2D arestaB;
	
	private SegmentoDeReta2D arestaC;
	
	private SegmentoDeReta2D arestaD;
	
	public Retangulo2D(Retangulo r){
		this.retangulo = r;
		arestaA = new SegmentoDeReta2D(this.retangulo.getArestaA());
		arestaB = new SegmentoDeReta2D(this.retangulo.getArestaB());
		arestaC = new SegmentoDeReta2D(this.retangulo.getArestaC());
		arestaD = new SegmentoDeReta2D(this.retangulo.getArestaD());
		adicionarPontos();
	}
	
	
	public Retangulo2D(Ponto a, Ponto b){
		this.retangulo = new Retangulo(a, b);
		arestaA = new SegmentoDeReta2D(this.retangulo.getArestaA());
		arestaB = new SegmentoDeReta2D(this.retangulo.getArestaB());
		arestaC = new SegmentoDeReta2D(this.retangulo.getArestaC());
		arestaD = new SegmentoDeReta2D(this.retangulo.getArestaD());
		adicionarPontos();
	}
	
	private void adicionarPontos() {
		addAllPontos(arestaA.getPontos());
		addAllPontos(arestaB.getPontos());
		addAllPontos(arestaC.getPontos());
		addAllPontos(arestaD.getPontos());
	}
	
	public boolean contem(final Ponto2D ponto){
		int x1 = (int)retangulo.getPontoA().getX();
		int x2 = (int)retangulo.getPontoB().getX();
		int y1 = (int)retangulo.getPontoA().getY();
		int y2 = (int)retangulo.getPontoB().getY();
		
		int pX = (int) ponto.getX();
		int pY = (int) ponto.getY();

		return pX >= x1 && pX <= x2 && pY >= y1 && pY <= y2;
	}
	
}
