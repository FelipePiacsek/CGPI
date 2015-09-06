package computacao_grafica.geometria.formas;

import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Retangulo;

public interface Forma2D {
	public void desenhar();
	
	public Set<Ponto> getPontos();
	
	public Retangulo getRetanguloQueCircunscreve();
}
