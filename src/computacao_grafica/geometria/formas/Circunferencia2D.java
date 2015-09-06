package computacao_grafica.geometria.formas;

import static java.awt.Color.RED;

import java.awt.Graphics;
import java.util.Set;

import computacao_grafica.geometria.matematica.Circunferencia;
import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class Circunferencia2D implements Forma2D{

	//TODO Fazer o algoritmo de espelhamento para otimizar a circunfer�ncia.
	
	private Circunferencia circunferencia;
	
	private Graphics g;
	
	public Circunferencia2D(Circunferencia c, Graphics g){
		this.circunferencia = c;
		this.g = g;
	}
	
	public Circunferencia2D(Ponto a, Ponto b, Graphics g){
		this.circunferencia = new Circunferencia(a, b);
		this.g = g;
	}
	
	private void desenharCircunferencia(){
		Ponto2D p;
		for(double i = 0.0; i <= 360.0; i+=0.5){
			p = new Ponto2D(circunferencia.getPontoDaCircunferencia(i), RED, this.g);
			p.desenhar();
		}
	}
	
	public void desenhar(){
		this.desenharCircunferencia();
	}

	@Override
	public Set<Ponto> getPontos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retangulo getRetanguloQueCircunscreve() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
