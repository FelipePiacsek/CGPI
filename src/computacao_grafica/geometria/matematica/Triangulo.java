package computacao_grafica.geometria.matematica;

public class Triangulo {

	private SegmentoDeReta arestaA;
	
	private SegmentoDeReta arestaB;
	
	private SegmentoDeReta arestaC;
	
	private Ponto pontoA;
	
	private Ponto pontoB;
	
	private Ponto pontoC;

	private boolean isTriangulo(Ponto a, Ponto b, Ponto c){
		double[][] m = new double[3][2];
		m[0][0] = a.getX();
		m[0][1] = a.getY();
		
		m[1][0] = b.getX();
		m[1][1] = b.getY();
		
		m[2][0] = c.getX();
		m[2][1] = c.getY();
		
		double determinante = m[0][0] * m[1][1] + m[0][1] * m[2][0] + m[1][0] * m[2][1]
				- m[1][1] * m[2][0] - m[0][0] * m[2][1] - m[1][0] * m[0][1];
		
		return determinante != 0;
	}
	
	public Triangulo (Ponto a, Ponto b, Ponto c){
		if (!isTriangulo(a, b, c)){
			System.out.println("Os pontos informados não formam um triângulo!");
		}
		this.pontoA = a;
		this.pontoB = b;
		this.pontoC = c;
		this.arestaA = new SegmentoDeReta(a, b);
		this.arestaB = new SegmentoDeReta(a, c);
		this.arestaC = new SegmentoDeReta(b, c);
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

	public Ponto getPontoA() {
		return pontoA;
	}

	public Ponto getPontoB() {
		return pontoB;
	}

	public Ponto getPontoC() {
		return pontoC;
	}
	
}
