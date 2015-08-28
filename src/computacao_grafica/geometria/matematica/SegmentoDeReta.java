package computacao_grafica.geometria.matematica;

public class SegmentoDeReta {

	private Ponto a;
	
	private Ponto b;
	
	private double coeficienteLinear;
	
	private double coeficienteAngular;
	
	public SegmentoDeReta (Ponto a, Ponto b){
		this.a = a;
		this.b = b;
		this.coeficienteAngular = (a.getY() - b.getY()) / (a.getX() - b.getX());
		this.coeficienteLinear = a.getY() - this.coeficienteAngular * a.getX(); 
	}
	
	public Ponto getA(){
		return this.a;
	}
	
	public Ponto getB(){
		return this.b;
	}
	
	public void setA(Ponto p){
		this.a = p;
	}
	
	public void setB(Ponto p){
		this.b = p;
	}
	
	public double getY(double x){
		return this.coeficienteAngular * x + this.coeficienteLinear;
	}
	
	public void inverterPontos(){
		Ponto p = this.a;
		this.a = this.b;
		this.b = p;
	}
}
