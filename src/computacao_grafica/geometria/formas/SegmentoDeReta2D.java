package computacao_grafica.geometria.formas;

import java.awt.Color;

import computacao_grafica.geometria.io.out.SaveElements;
import computacao_grafica.geometria.matematica.FormaMatematica;
import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class SegmentoDeReta2D extends Forma2D {

    private SegmentoDeReta segmentoDeReta;

    private SaveElements saveElements;

    public SegmentoDeReta2D(Ponto a, Ponto b) {
        this.segmentoDeReta = new SegmentoDeReta(a, b);
        init();
    }

    private void init() {
        definirEstrategia();
        setSaveElements();
    }

    public SegmentoDeReta2D(SegmentoDeReta s) {
        this.segmentoDeReta = s;
        init();
    }

    // M�todo que define a estrat�gia de desenho da reta a ser utilizada.
    private void definirEstrategia() {
        if (this.segmentoDeReta.getA().getX() == this.segmentoDeReta.getB().getX()) {
            semEquacaoDaReta();
        } else {
            comEquacaoReta();
        }
    }

    private void comEquacaoReta() {
        Ponto2D p;
        if (this.segmentoDeReta.getA().getX() > this.segmentoDeReta.getB().getX()) {
            for (double i = this.segmentoDeReta.getB().getX(); i <= this.segmentoDeReta.getA().getX(); i += 0.05) {
                p = new Ponto2D((int) i, (int) this.segmentoDeReta.getY(i), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                addPonto(p);
            }
        } else {
            for (double i = this.segmentoDeReta.getA().getX(); i <= this.segmentoDeReta.getB().getX(); i += 0.05) {
                p = new Ponto2D((int) i, (int) this.segmentoDeReta.getY(i), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
                addPonto(p);
            }
        }

    }

    private void semEquacaoDaReta() {
        if (this.segmentoDeReta.getA().getY() > this.segmentoDeReta.getB().getY()) {
            this.segmentoDeReta.inverterPontos();
        }
        Ponto2D p;
        for (int i = (int) this.segmentoDeReta.getA().getY(); i <= (int) this.segmentoDeReta.getB().getY(); i++) {
            p = new Ponto2D((int) this.segmentoDeReta.getA().getX(), i, Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
            addPonto(p);
        }

    }

    @Override
    public FormaMatematica getFormaMatematica() {
        return this.segmentoDeReta;
    }

    private void setSaveElements() {
        this.saveElements = new SaveElements();
        this.saveElements.setCor(super.getPontos().stream().findFirst().get().get_cor());
        Ponto2D a = new Ponto2D(segmentoDeReta.getA(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
        Ponto2D b = new Ponto2D(segmentoDeReta.getB(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
        a.setModoCoordenada(ModoCoordenada.NORMALIZADA);
        b.setModoCoordenada(ModoCoordenada.NORMALIZADA);
        this.saveElements.addPonto(a);
        this.saveElements.addPonto(b);
        this.saveElements.setNome("Reta");
    }

    @Override
    public SaveElements getSaveElements() {
        return this.saveElements;
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        this.segmentoDeReta.transladar(deltaX, deltaY);
        super.resetPontos();
        init();
    }

	@Override
	public void escalar(float fator) {
		this.segmentoDeReta.escalar(fator);
        super.resetPontos();
        init();
		
	}

	@Override
	public void rotacionar(float angulo) {
		this.segmentoDeReta.rotacionar(angulo);
        super.resetPontos();
        init();
		
	}

}
