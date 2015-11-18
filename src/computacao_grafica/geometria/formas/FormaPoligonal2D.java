package computacao_grafica.geometria.formas;

import java.awt.Color;
import computacao_grafica.geometria.io.out.SaveElements;
import computacao_grafica.geometria.matematica.FormaMatematica;
import computacao_grafica.geometria.matematica.FormaPoligonal;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class FormaPoligonal2D extends Forma2D {

    private FormaPoligonal formaPoligonal = new FormaPoligonal();

    private SaveElements saveElements;

    public Integer quantidadeSegmentos() {
        return formaPoligonal.getSegmentos().size();
    }

    public void addSegmento(SegmentoDeReta segmento) {
        formaPoligonal.addSegmento(segmento);
        super.addAllPontos(new SegmentoDeReta2D(segmento).getPontos());
    }

    public boolean isPoligono() {
        return this.formaPoligonal.isFechada();
    }

    @Override
    public FormaMatematica getFormaMatematica() {
        return this.formaPoligonal;
    }

    private void setSaveElements() {
        if (!this.formaPoligonal.getSegmentos().isEmpty() && this.saveElements == null) {
            this.saveElements = new SaveElements();
            int i = 0;
            SegmentoDeReta r = null;
            if (isPoligono()) {
                while (i < this.formaPoligonal.getSegmentos().size() - 1) {
                    r = this.formaPoligonal.getSegmentos().get(i);
                    Ponto2D p = new Ponto2D(r.getA(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                    p.setModoCoordenada(ModoCoordenada.NORMALIZADA);
                    this.saveElements.addPonto(p);
                    i++;
                }
                Ponto2D p = new Ponto2D(r.getB(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                p.setModoCoordenada(ModoCoordenada.NORMALIZADA);
                this.saveElements.addPonto(p);
            } else {
                r = this.formaPoligonal.getSegmentos().get(i);
                Ponto2D p = new Ponto2D(r.getA(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                p.setModoCoordenada(ModoCoordenada.NORMALIZADA);
                this.saveElements.addPonto(p);
                p = new Ponto2D(r.getB(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                p.setModoCoordenada(ModoCoordenada.NORMALIZADA);
                this.saveElements.addPonto(p);
                i++;
                while (i < this.formaPoligonal.getSegmentos().size()) {
                    r = this.formaPoligonal.getSegmentos().get(i);
                    p = new Ponto2D(r.getB(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                    p.setModoCoordenada(ModoCoordenada.NORMALIZADA);
                    this.saveElements.addPonto(p);
                    i++;
                }
                this.saveElements.addPonto(p);
            }
            this.saveElements.setCor(super.getPontos().stream().findFirst().get().get_cor());
            if (isPoligono()) {
                this.saveElements.setNome("Poligono");
            } else {
                this.saveElements.setNome("LinhaPoligonal");
            }
        }
    }

    @Override
    public SaveElements getSaveElements() {
        setSaveElements();
        return this.saveElements;
    }

    public void fechar() {
        this.formaPoligonal.fechar();
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        formaPoligonal.transladar(deltaX, deltaY);
        super.resetPontos();
        for (SegmentoDeReta s : formaPoligonal.getSegmentos()) {
            super.addAllPontos(new SegmentoDeReta2D(s).getPontos());
        }
    }

}
