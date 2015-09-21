package computacao_grafica.geometria.formas;

import java.awt.Color;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class SegmentoDeReta2D extends Forma2D{

	private SegmentoDeReta segmentoDeReta;
	
	public SegmentoDeReta2D(Ponto a, Ponto b){
		this.segmentoDeReta = new SegmentoDeReta(a, b);
		definirEstrategia();
	}
	
	public SegmentoDeReta2D(SegmentoDeReta s){
		this.segmentoDeReta = s;
		definirEstrategia();
	}
	
	
	//Método que define a estratégia de desenho da reta a ser utilizada.
	private void definirEstrategia() {
		if(this.segmentoDeReta.getA().getX() == this.segmentoDeReta.getB().getX()){
			semEquacaoDaReta();
		}else{
			comEquacaoReta();
		}
	}
	
	private void comEquacaoReta(){
		if(this.segmentoDeReta.getA().getX() > this.segmentoDeReta.getB().getX()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(double i = this.segmentoDeReta.getA().getX(); i <= this.segmentoDeReta.getB().getX(); i+=0.05){
			p = new Ponto2D((int)i, (int) this.segmentoDeReta.getY(i), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
			addPonto(p);
		}
		
	}
	
	private void semEquacaoDaReta(){
		if(this.segmentoDeReta.getA().getY() > this.segmentoDeReta.getB().getY()){
			this.segmentoDeReta.inverterPontos();
		}
		Ponto2D p;
		for(int i = (int) this.segmentoDeReta.getA().getY(); i <= (int) this.segmentoDeReta.getB().getY(); i++){
			p = new Ponto2D((int) this.segmentoDeReta.getA().getX(), i, Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
			addPonto(p);
		}
		
	}
	


}
