package computacao_grafica.geometria.arte;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;

public class EdwardScissorHands {

	public Set<Ponto2D> recortar(final List<Forma2D> formas, final Retangulo2D recorte){
		Set<Ponto2D> figuraRecortada = new HashSet<Ponto2D>();
		for(Forma2D forma : formas){
			for(Ponto2D ponto : forma.getPontos()){
				if(recorte.contem(ponto)){
					figuraRecortada.add(ponto);
				}
			}
		}
		return figuraRecortada;
	}
}
