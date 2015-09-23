package computacao_grafica.geometria.formas;

import static java.util.Collections.unmodifiableSet;
import java.util.HashSet;
import java.util.Set;

public class Poligono2D extends Forma2D {

    private Set<SegmentoDeReta2D> segmentos = new HashSet<SegmentoDeReta2D>();

    public Set<SegmentoDeReta2D> getSegmentos() {
        return unmodifiableSet(segmentos);

    }

    public void addSegmento(SegmentoDeReta2D segmento) {
        segmentos.add(segmento);
        super.addAllPontos(segmento.getPontos());
    }

}
