package computacao_grafica.geometria.matematica;

public class Retangulo {

	private SegmentoDeReta arestaA;
	
	private SegmentoDeReta arestaB;
	
	private SegmentoDeReta arestaC;
	
	private SegmentoDeReta arestaD;
	
	public Retangulo (Ponto a, Ponto b){
		Ponto c = new Ponto(a.getX(), b.getY());
		Ponto d = new Ponto(b.getX(), a.getY());
		this.arestaA = new SegmentoDeReta(a, c);
		this.arestaB = new SegmentoDeReta(a, d);
		this.arestaC = new SegmentoDeReta(d, b);
		this.arestaD = new SegmentoDeReta(c, b);
	}
	
	public SegmentoDeReta getArestaA() {
		return arestaA;
	}

	public SegmentoDeReta getArestaB() {
		return arestaB;
	}

	public SegmentoDeReta getArestaC() {
		return arestaC;
	}

	public SegmentoDeReta getArestaD() {
		return arestaD;
	}
}
