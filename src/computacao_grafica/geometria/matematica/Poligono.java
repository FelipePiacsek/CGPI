package computacao_grafica.geometria.matematica;

import static java.util.Collections.unmodifiableSet;
import java.util.HashSet;
import java.util.Set;

public class Poligono implements FormaMatematica {

    private Set<SegmentoDeReta> segmentos = new HashSet<SegmentoDeReta>();

    public void addSegmento(SegmentoDeReta segmento) {
        segmentos.add(segmento);
    }

    public Set<SegmentoDeReta> getSegmentos() {
        return unmodifiableSet(segmentos);
    }

    @Override
    public boolean contem(Ponto ponto) {
        for (SegmentoDeReta r : segmentos) {
            if (r.contem(ponto)) {
                return true;
            }
        }
        return false;
    }
}
