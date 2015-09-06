package computacao_grafica.geometria.matematica;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Circunferencia {

	private double raio;
	
	private Ponto centro;
	
	public Circunferencia(double raio, Ponto centro){
		this.raio = raio;
		this.centro = centro;
	}
	
	public Circunferencia(Ponto centro, Ponto extremo){
		this.raio = centro.calcularDistancia(extremo);
		this.centro = centro;
	}
	
	public double getRaio(){
		return this.raio;
	}
	
	public Ponto getCentro(){
		return this.centro;
	}
	
	public Ponto getPontoDaCircunferencia(double angulo){
		return new Ponto(centro.getX() + cos(angulo)*this.raio, centro.getY() + sin(angulo)*this.raio);
	}
}
