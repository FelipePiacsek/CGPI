package computacao_grafica.geometria.formas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;



public abstract class Forma2D {
	
	private Set<Ponto2D> pontos = new HashSet<Ponto2D>();
	
	public void addPonto(Ponto2D ponto){
		pontos.add(ponto);
	}

	
	public void addAllPontos(Set<Ponto2D> pontos){
		this.pontos.addAll(pontos);
	}
	
	
	public Set<Ponto2D> getPontos(){
		return Collections.unmodifiableSet(this.pontos);
	}
	
}
