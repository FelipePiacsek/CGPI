package computacao_grafica.geometria.matematica;

import static java.util.Collections.unmodifiableList;
import java.util.ArrayList;
import java.util.List;

public class FormaPoligonal implements FormaMatematica {

    private List<SegmentoDeReta> segmentos = new ArrayList<SegmentoDeReta>();

    private boolean fechada = false;

    public void addSegmento(SegmentoDeReta segmento) {
        segmentos.add(segmento);
    }

    public List<SegmentoDeReta> getSegmentos() {
        return unmodifiableList(segmentos);
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

    public boolean isFechada() {
        return fechada;
    }

    public void fechar() {
        this.fechada = true;
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        for (SegmentoDeReta segmentoDeReta : segmentos) {
            segmentoDeReta.transladar(deltaX, deltaY);
        }
    }
}
