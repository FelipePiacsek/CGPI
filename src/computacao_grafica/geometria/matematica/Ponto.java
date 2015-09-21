package computacao_grafica.geometria.matematica;

import static computacao_grafica.geometria.main.ParametrosConfiguracao.PREVIEW_HEIGTH;
import static computacao_grafica.geometria.main.ParametrosConfiguracao.PREVIEW_WIDTH;
import static computacao_grafica.geometria.main.ParametrosConfiguracao.WINDOW_HEIGTH;
import static computacao_grafica.geometria.main.ParametrosConfiguracao.WINDOW_WIDTH;
import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_JANELA;

public class Ponto {

	private static final String name = "Ponto";
	public enum ModoCoordenada{
		ABSOLUTA_JANELA, NORMALIZADA, ABSOLUTA_PREVIEW;
	}
			
	private double x;
	
	private double y;
	
	private ModoCoordenada modoCoordenada;
	
	public Ponto (final ModoCoordenada modoCoordenada) {
		this.x = 0;
		this.y = 0;
		this.modoCoordenada = modoCoordenada;
	}

	public Ponto (final double x, final double y, final ModoCoordenada modoCoordenada) {
		this.x = x;
		this.y = y;
		this.modoCoordenada = modoCoordenada;
	}

	protected Ponto (Ponto p, final ModoCoordenada modoCoordenada) {
		this.x = p.getX();
		this.y = p.getY();
		this.modoCoordenada = modoCoordenada;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public ModoCoordenada getModoCoordenada(){
		return this.modoCoordenada;
	}
	
	
	public void setModoCoordenada(final ModoCoordenada modoCoordenada){
		normalizarCoordenadas(this.modoCoordenada);
		switch(modoCoordenada){
			case NORMALIZADA:
				break;
			case ABSOLUTA_JANELA:
				converterParaCoordenadaAbsolutaJanela();
				break;
			case ABSOLUTA_PREVIEW:
				converterParaCoordenadaAbsolutaPreview();
				break;
			default:
				throw new IllegalArgumentException();
		}
		this.modoCoordenada = modoCoordenada;
	}
	
	


	private void normalizarCoordenadas(final ModoCoordenada modoAnterior){
		switch (modoAnterior){
			case NORMALIZADA:
				//Meh :p.
				break;
			
			case ABSOLUTA_JANELA:
				this.x = this.x / WINDOW_WIDTH;
				this.y = this.y / WINDOW_HEIGTH;
				break;

			case ABSOLUTA_PREVIEW:
				this.x = this.x / PREVIEW_WIDTH;
				this.y = this.y / PREVIEW_HEIGTH;
				break;
			
			default:
				throw new IllegalArgumentException();
		}
	}
	
	private void converterParaCoordenadaAbsolutaJanela(){
    	this.x = this.x * WINDOW_WIDTH;
    	this.y = this.y * WINDOW_HEIGTH;
    }
	
	private void converterParaCoordenadaAbsolutaPreview(){
		this.x = this.x * PREVIEW_WIDTH;
		this.y = this.y * PREVIEW_HEIGTH;
	}
    
	public double calcularDistancia(Ponto q) {
		Ponto p = new Ponto(this, this.modoCoordenada);
		p.setModoCoordenada(ABSOLUTA_JANELA);
		if(q !=null){
			q.setModoCoordenada(ABSOLUTA_JANELA);
			return Math.sqrt(Math.pow((p.getY() - q.getY()),2) +
					Math.pow((p.getX() - q.getX()),2));
		}
		return 0.0;
	}
    

	@Override
	public boolean equals(Object p) {
		return (p instanceof Ponto) && ((Ponto)(p)).getX() == this.x && ((Ponto)(p)).getY() == this.y;
	};
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
