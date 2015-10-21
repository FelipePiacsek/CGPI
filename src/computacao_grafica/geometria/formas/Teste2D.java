package computacao_grafica.geometria.formas;

import static java.awt.Color.RED;

import computacao_grafica.geometria.matematica.Circunferencia;
import computacao_grafica.geometria.matematica.Ponto;

public class Teste2D extends Forma2D{

	//TODO Fazer o algoritmo de espelhamento para otimizar a circunferência.

	private Circunferencia circunferencia;
	
	public Teste2D(Circunferencia c){
		this.circunferencia = c;
		definirPontosCircunferencia();
	}
	
	public Teste2D(double raio, Ponto centro){
		for(double d=0;d<4;d+=0.1){
			this.circunferencia = new Circunferencia(d, centro);
			definirPontosCircunferencia();
		}
	}
	
	public Teste2D(Ponto a, Ponto b){
		this.circunferencia = new Circunferencia(a, b);
		definirPontosCircunferencia();
	}
	
	private void definirPontosCircunferencia(){
		Ponto2D p;
		for(double i = 0.0; i <= 360.0; i+=0.5){
			p = new Ponto2D(circunferencia.getPontoDaCircunferencia(i), RED, Ponto.ModoCoordenada.ABSOLUTA_JANELA);
			super.addPonto(p);
		}
	}
	
}
