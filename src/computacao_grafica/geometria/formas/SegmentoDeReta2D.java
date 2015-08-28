package computacao_grafica.geometria.formas;

import java.awt.Color;
import java.awt.Graphics;

import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class SegmentoDeReta2D {

	private SegmentoDeReta segmentoDeReta;
	
	private Graphics g;
	
	public SegmentoDeReta2D(SegmentoDeReta s, Graphics g){
		this.segmentoDeReta = s;
		this.g = g;
	}
	
	
	//Método que define a estratégia de desenho da reta a ser utilizada.
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
		for(int i = (int) this.segmentoDeReta.getA().getX(); i <= (int) this.segmentoDeReta.getB().getX(); i++){
			p = new Ponto2D(i, (int) this.segmentoDeReta.getY(i), Color.RED);
			p.desenharPonto(this.g);
		}
		
	}
	
	private void desenharSemEquacaoDaReta(){
		if(this.segmentoDeReta.getA().getY() > this.segmentoDeReta.getB().getY()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(int i = (int) this.segmentoDeReta.getA().getY(); i <= (int) this.segmentoDeReta.getB().getY(); i++){
			p = new Ponto2D((int) this.segmentoDeReta.getA().getX(), i, Color.RED);
			p.desenharPonto(this.g);
		}
		
	}
	
	public void desenharSegmentoReta(){
		definirEstrategia();
	}

	

}
