package computacao_grafica.geometria.main;

import java.awt.Graphics;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import computacao_grafica.geometria.arte.GeorgeSeurat;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.FormaPoligonal2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;

public class MicroVisor extends JPanel {

    /**
     * Unique ID.
     */
    private static final long serialVersionUID = -8448212652433488462L;

    private List<Forma2D> formas;

    private Forma2D elastico;

    private GeorgeSeurat georgeSeurat;

    private Set<Ponto2D> recorte;

    private Retangulo2D quadro;

    private FormaPoligonal2D poligono;

    @Override
    protected void paintComponent(Graphics g) {
        georgeSeurat = new GeorgeSeurat(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        if (recorte != null) {
            georgeSeurat.desenharRecorte(recorte, quadro);
            recorte = null;
        } else {
            for (Forma2D forma : formas) {
                georgeSeurat.desenharPreview(forma);
            }
            if (elastico != null) {
                georgeSeurat.desenharPreview(elastico);
            }
            if (poligono != null) {
                georgeSeurat.desenharPreview(poligono);
            }
            elastico = null;
            poligono = null;
        }
    }

    public void atualizarVisor(final List<Forma2D> formas, final Forma2D elastico) {
        this.formas = formas;
        this.elastico = elastico;
        this.recorte = null;
        this.poligono = null;
        repaint();
    }

    public void atualizarVisor(final FormaPoligonal2D poligono) {
        this.poligono = poligono;
        this.recorte = null;
        repaint();
    }

    public void atualizarVisor(Set<Ponto2D> recorte, final Retangulo2D quadro) {
        this.recorte = recorte;
        this.quadro = quadro;
        this.poligono = null;
        repaint();
    }
}
