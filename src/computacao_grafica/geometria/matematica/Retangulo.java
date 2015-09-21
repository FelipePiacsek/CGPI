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
		if(!a.getModoCoordenada().equals(b.getModoCoordenada())){
			throw new IllegalArgumentException();
		}
		Ponto c = new Ponto(a.getX(), b.getY(), a.getModoCoordenada());
		Ponto d = new Ponto(b.getX(), a.getY(), a.getModoCoordenada());
		if(a.getX() <= b.getX() && a.getY() <= b.getY()){
			this.pontoA = a;
			this.pontoB = b;
			this.pontoC = c;
			this.pontoD = d;
		}else if (a.getX() <= b.getX() && a.getY() >= b.getY()){
			this.pontoA = c;
			this.pontoB = d;
			this.pontoC = a;
			this.pontoD = b;
		}else if (a.getX() >= b.getX() && a.getY() <= b.getY()){
			this.pontoA = d;
			this.pontoB = c;
			this.pontoC = b;
			this.pontoD = a;
		}else if (a.getX() >= b.getX() && a.getY() >= b.getY()){
			this.pontoA = b;
			this.pontoB = a;
			this.pontoC = d;
			this.pontoD = c;
		}
		this.arestaA = new SegmentoDeReta(this.pontoA, this.pontoC);
		this.arestaB = new SegmentoDeReta(this.pontoA, this.pontoD);
		this.arestaC = new SegmentoDeReta(this.pontoD, this.pontoB);
		this.arestaD = new SegmentoDeReta(this.pontoC, this.pontoB);
		this.altura = this.pontoA.calcularDistancia(this.pontoC);
		this.largura = this.pontoA.calcularDistancia(this.pontoD);
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
