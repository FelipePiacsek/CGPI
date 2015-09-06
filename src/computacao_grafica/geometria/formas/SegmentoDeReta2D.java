package computacao_grafica.geometria.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class SegmentoDeReta2D implements Forma2D{

	private SegmentoDeReta segmentoDeReta;
	
	private Graphics g;
	
	public SegmentoDeReta2D(Ponto a, Ponto b, Graphics g){
		this.segmentoDeReta = new SegmentoDeReta(a, b);
		this.g = g;
	}
	
	public SegmentoDeReta2D(SegmentoDeReta s, Graphics g){
		this.segmentoDeReta = s;
		this.g = g;
	}
	
	
	//M�todo que define a estrat�gia de desenho da reta a ser utilizada.
	private void definirEstrategia() {
		if(this.segmentoDeReta.getA().getX() == this.segmentoDeReta.getB().getX()){
			desenharSemEquacaoDaReta();
		}else{
			desenharEquacaoReta();
		}
	}
	
	private void desenharEquacaoReta(){
		if(this.segmentoDeReta.getA().getX() > this.segmentoDeReta.getB().getX()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(double i = this.segmentoDeReta.getA().getX(); i <= this.segmentoDeReta.getB().getX(); i+=0.05){
			p = new Ponto2D((int)i, (int) this.segmentoDeReta.getY(i), Color.RED, this.g);
			p.desenhar();
		}
		
	}
	
	private void desenharSemEquacaoDaReta(){
		if(this.segmentoDeReta.getA().getY() > this.segmentoDeReta.getB().getY()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(int i = (int) this.segmentoDeReta.getA().getY(); i <= (int) this.segmentoDeReta.getB().getY(); i++){
			p = new Ponto2D((int) this.segmentoDeReta.getA().getX(), i, Color.RED, this.g);
			p.desenhar();
		}
		
	}
	
	private void desenharSegmentoReta(){
		definirEstrategia();
	}

	@Override
	public void desenhar() {
		this.desenharSegmentoReta();
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
