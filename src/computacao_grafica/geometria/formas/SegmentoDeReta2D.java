package computacao_grafica.geometria.formas;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Collections.unmodifiableSet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class SegmentoDeReta2D implements Forma2D{

	private SegmentoDeReta segmentoDeReta;
	
	private Graphics g;
	
	private Set<Ponto2D> pontos;
	
	public SegmentoDeReta2D(Ponto a, Ponto b, Graphics g){
		this.segmentoDeReta = new SegmentoDeReta(a, b);
		this.g = g;
		this.pontos = new HashSet<Ponto2D>();
		criarPontos();
	}
	

	public SegmentoDeReta2D(SegmentoDeReta s, Graphics g){
		this.segmentoDeReta = s;
		this.g = g;
		this.pontos = new HashSet<Ponto2D>();
		criarPontos();
	}
	
	private void criarPontos() {
		definirEstrategia();
		
	}
	
	private void definirEstrategia() {
		if(this.segmentoDeReta.getA().getX() == this.segmentoDeReta.getB().getX()){
			semEquacaoDaRetaStrategy();
		}else{
			equacaoRetaStrategy();
		}
	}
	
	private void equacaoRetaStrategy(){
		if(this.segmentoDeReta.getA().getX() > this.segmentoDeReta.getB().getX()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(double i = this.segmentoDeReta.getA().getX(); i <= this.segmentoDeReta.getB().getX(); i+=0.05){
			p = new Ponto2D((int)i, (int) this.segmentoDeReta.getY(i), Color.RED, this.g);
			pontos.add(p);
		}
		
	}
	
	private void semEquacaoDaRetaStrategy(){
		if(this.segmentoDeReta.getA().getY() > this.segmentoDeReta.getB().getY()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(int i = (int) this.segmentoDeReta.getA().getY(); i <= (int) this.segmentoDeReta.getB().getY(); i++){
			p = new Ponto2D((int) this.segmentoDeReta.getA().getX(), i, Color.RED, this.g);
			pontos.add(p);
		}
		
	}
	
	private void desenharSegmentoReta(){
		for (Ponto2D ponto : pontos) {
			ponto.desenhar();
		}
	}

	@Override
	public void desenhar() {
		this.desenharSegmentoReta();
	}

	@Override
	public Set<Ponto> getPontos() {
		return unmodifiableSet(this.pontos);
	}

	@Override
	public Retangulo getRetanguloQueCircunscreve() {
		double xA = segmentoDeReta.getA().getX();
		double xB = segmentoDeReta.getB().getX();

		double yA = segmentoDeReta.getA().getY();
		double yB = segmentoDeReta.getB().getY();
		
		double menorX = min(xA, xB);
		double menorY = min(yA, yB);
		double maiorX = max(xA, xB);
		double maiorY = max(yA, yB);
		
		Ponto a = new Ponto(menorX - 1, menorY - 1);
		Ponto b = new Ponto(maiorX + 1, maiorY + 1);

		return new Retangulo(a, b);
	}

	

}
