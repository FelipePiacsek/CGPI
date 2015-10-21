package computacao_grafica.geometria.formas;

import computacao_grafica.geometria.matematica.FormaMatematica;
import computacao_grafica.geometria.matematica.Poligono;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class Poligono2D extends Forma2D {

    private Poligono poligono = new Poligono();

    public Integer quantidadeSegmentos() {
        return poligono.getSegmentos().size();
    }

    public void addSegmento(SegmentoDeReta segmento) {
        poligono.addSegmento(segmento);
        super.addAllPontos(new SegmentoDeReta2D(segmento).getPontos());
    }

    @Override
    public FormaMatematica getFormaMatematica() {
        return this.poligono;
    }

}
