package computacao_grafica.geometria.formas;

import static java.awt.Color.RED;
import static java.util.Collections.unmodifiableSet;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import computacao_grafica.geometria.matematica.Circunferencia;
import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;

public class Circunferencia2D implements Forma2D{

	//TODO Fazer o algoritmo de espelhamento para otimizar a circunferência.
	
	private Circunferencia circunferencia;
	
	private Graphics g;
	
	private Set<Ponto2D> pontos;
	
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
		this.pontos = new HashSet<Ponto2D>();
		for(double i = 0.0; i <= 360.0; i+=0.5){
			p = new Ponto2D(circunferencia.getPontoDaCircunferencia(i), RED, this.g);
			pontos.add(p);
			p.desenhar();
		}
	}
	
	@Override
	public void desenhar(){
		this.desenharCircunferencia();
	}

	@Override
	public Set<Ponto> getPontos() {
		return unmodifiableSet(pontos);
	}

	@Override
	public Retangulo getRetanguloQueCircunscreve() {
		Ponto a = new Ponto(circunferencia.getCentro().getX() - circunferencia.getRaio() - 1, circunferencia.getCentro().getY() - circunferencia.getRaio() - 1);
		Ponto b = new Ponto(circunferencia.getCentro().getX() + circunferencia.getRaio() + 1, circunferencia.getCentro().getY() + circunferencia.getRaio() + 1);
		return new Retangulo(a, b);
	}

	

}
