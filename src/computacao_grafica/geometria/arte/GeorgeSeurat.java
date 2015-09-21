package computacao_grafica.geometria.arte;

import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_PREVIEW;
import java.awt.Graphics;
import java.util.Set;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;

public class GeorgeSeurat extends Pontilhista {

    private Graphics graphics;

    public GeorgeSeurat(Graphics graphics) {
        this.graphics = graphics;
    }

    public void desenharPreview(Forma2D forma) {
        for (Ponto2D ponto : forma.getPontos()) {
            ponto.setModoCoordenada(ABSOLUTA_PREVIEW);
            super.pontilhar(ponto, graphics);
        }

    }

    public void desenharRecorte(Set<Ponto2D> recorte, Retangulo2D quadro) {
        for (Ponto2D p : recorte) {
            Ponto2D ponto = new Ponto2D(p, p.get_cor(), p.getModoCoordenada());
            ponto.clip(quadro.getRetangulo());
            ponto.setModoCoordenada(ABSOLUTA_PREVIEW);
            super.pontilhar(ponto, graphics);
        }
    }
}
