package computacao_grafica.geometria.matematica;

public class Retangulo {

	private SegmentoDeReta arestaA;
	
	private SegmentoDeReta arestaB;
	
	private SegmentoDeReta arestaC;
	
	private SegmentoDeReta arestaD;
	
	private Ponto pontoA;

	private Ponto pontoB;
	
	private Ponto pontoC;
	
	private Ponto pontoD;
	
	private double altura;
	
	private double largura;
	
	public Retangulo (Ponto a, Ponto b){
		Ponto c = new Ponto(a.getX(), b.getY());
		Ponto d = new Ponto(b.getX(), a.getY());
		this.pontoA = a;
		this.pontoB = b;
		this.pontoC = c;
		this.pontoD = d;
		this.arestaA = new SegmentoDeReta(a, c);
		this.arestaB = new SegmentoDeReta(a, d);
		this.arestaC = new SegmentoDeReta(d, b);
		this.arestaD = new SegmentoDeReta(c, b);
		this.altura = a.calcularDistancia(c);
		this.largura = a.calcularDistancia(d);
	}
	
	public Ponto getPontoA() {
		return pontoA;
	}

	public Ponto getPontoB() {
		return pontoB;
	}

	public Ponto getPontoC() {
		return pontoC;
	}

	public Ponto getPontoD() {
		return pontoD;
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

	public double getAltura() {
		return altura;
	}
	
	public double getLargura() {
		return largura;
	}
}
