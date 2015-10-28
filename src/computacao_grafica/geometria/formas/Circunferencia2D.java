package computacao_grafica.geometria.formas;

import static java.awt.Color.RED;

import java.awt.Color;

import computacao_grafica.geometria.io.out.SaveElements;
import computacao_grafica.geometria.matematica.Circunferencia;
import computacao_grafica.geometria.matematica.FormaMatematica;
import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class Circunferencia2D extends Forma2D {

    // TODO Fazer o algoritmo de espelhamento para otimizar a circunferência.

    private Circunferencia circunferencia;
    
    private SaveElements saveElements;

    public Circunferencia2D(Circunferencia c) {
        this.circunferencia = c;
        definirPontosCircunferencia();
        setSaveElements();
    }

    public Circunferencia2D(double raio, Ponto centro) {
        this.circunferencia = new Circunferencia(raio, centro);
        definirPontosCircunferencia();
        setSaveElements();
    }

    public Circunferencia2D(Ponto a, Ponto b) {
        this.circunferencia = new Circunferencia(a, b);
        definirPontosCircunferencia();
        setSaveElements();
    }

    private void definirPontosCircunferencia() {
        Ponto2D p;
        for (double i = 0.0; i <= 360.0; i += 0.5) {
            p = new Ponto2D(circunferencia.getPontoDaCircunferencia(i), RED, Ponto.ModoCoordenada.ABSOLUTA_JANELA);
            super.addPonto(p);
        }
    }

	private void setSaveElements() {
		this.saveElements = new SaveElements();
		Ponto2D centro = new Ponto2D(this.circunferencia.getCentro(), Color.RED, Ponto.ModoCoordenada.ABSOLUTA_JANELA);
    	centro.setModoCoordenada(ModoCoordenada.NORMALIZADA);
    	this.saveElements.addPonto(centro);
    	this.saveElements.addElementByName("Raio", circunferencia.getRaio());
    	this.saveElements.setCor(super.getPontos().stream().findFirst().get().get_cor());
    	this.saveElements.setNome("Circulo");
	}

    @Override
    public FormaMatematica getFormaMatematica() {
        return this.circunferencia;
    }

	@Override
	public SaveElements getSaveElements() {
		return this.saveElements;
	}

}
