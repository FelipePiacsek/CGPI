package computacao_grafica.geometria.formas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import computacao_grafica.geometria.io.out.SaveElements;
import computacao_grafica.geometria.matematica.FormaMatematica;

public abstract class Forma2D {

    private Set<Ponto2D> pontos = new HashSet<Ponto2D>();

    public void addPonto(Ponto2D ponto) {
        pontos.add(ponto);
    }

    public void addAllPontos(Set<Ponto2D> pontos) {
        this.pontos.addAll(pontos);
    }

    public Set<Ponto2D> getPontos() {
        return Collections.unmodifiableSet(this.pontos);
    }

    public abstract FormaMatematica getFormaMatematica();

    public abstract SaveElements getSaveElements();

    public abstract void transladar(int deltaX, int deltaY);
    
    public abstract void escalar(float fator);
    
    public abstract void rotacionar(float angulo);

    public void resetPontos() {
        pontos = new HashSet<Ponto2D>();
    }
}
