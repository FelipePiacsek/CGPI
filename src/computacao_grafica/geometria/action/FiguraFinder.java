package computacao_grafica.geometria.action;

import java.util.Collection;
import computacao_grafica.geometria.formas.Forma2D;

public interface FiguraFinder {

    public Forma2D encontrar(Collection<Forma2D> formas);
}
