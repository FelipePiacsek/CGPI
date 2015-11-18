package computacao_grafica.geometria.formas;

import java.awt.Color;

import computacao_grafica.geometria.io.out.SaveElements;
import computacao_grafica.geometria.matematica.FormaMatematica;
import computacao_grafica.geometria.matematica.Ponto;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;
import computacao_grafica.geometria.matematica.Retangulo;

public class Retangulo2D extends Forma2D {

    private Retangulo retangulo;

    private SegmentoDeReta2D arestaA;

    private SegmentoDeReta2D arestaB;

    private SegmentoDeReta2D arestaC;

    private SegmentoDeReta2D arestaD;

    private SaveElements saveElements;

    public Retangulo2D(Retangulo r) {
        this.retangulo = r;

        init();
    }

    private void init() {
        arestaA = new SegmentoDeReta2D(this.retangulo.getArestaA());
        arestaB = new SegmentoDeReta2D(this.retangulo.getArestaB());
        arestaC = new SegmentoDeReta2D(this.retangulo.getArestaC());
        arestaD = new SegmentoDeReta2D(this.retangulo.getArestaD());
        adicionarPontos();
        setSaveElements();
    }

    public Retangulo2D(Ponto a, Ponto b) {
        this.retangulo = new Retangulo(a, b);
        init();
    }

    private void adicionarPontos() {
        addAllPontos(arestaA.getPontos());
        addAllPontos(arestaB.getPontos());
        addAllPontos(arestaC.getPontos());
        addAllPontos(arestaD.getPontos());
    }

    public boolean contem(final Ponto2D ponto) {
        int x1 = (int) retangulo.getPontoA().getX();
        int x2 = (int) retangulo.getPontoB().getX();
        int y1 = (int) retangulo.getPontoA().getY();
        int y2 = (int) retangulo.getPontoB().getY();

        int pX = (int) ponto.getX();
        int pY = (int) ponto.getY();

        return pX >= x1 && pX <= x2 && pY >= y1 && pY <= y2;
    }

    @Override
    public FormaMatematica getFormaMatematica() {
        return this.retangulo;
    }

    public Retangulo getRetangulo() {
        return this.retangulo;
    }

    private void setSaveElements() {
        this.saveElements = new SaveElements();
        this.saveElements.setCor(super.getPontos().stream().findFirst().get().get_cor());
        Ponto2D a = new Ponto2D(retangulo.getPontoA(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
        Ponto2D b = new Ponto2D(retangulo.getPontoB(), Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
        a.setModoCoordenada(ModoCoordenada.NORMALIZADA);
        b.setModoCoordenada(ModoCoordenada.NORMALIZADA);
        this.saveElements.addPonto(a);
        this.saveElements.addPonto(b);
        this.saveElements.setNome("Retangulo");
    }

    @Override
    public SaveElements getSaveElements() {
        return this.saveElements;
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        this.retangulo.transladar(deltaX, deltaY);
        super.resetPontos();
        init();
    }

	@Override
	public void escalar(float fator) {
		this.retangulo.escalar(fator);
        super.resetPontos();
        init();		
	}

	@Override
	public void rotacionar(float angulo) {
		this.retangulo.rotacionar(angulo);
        super.resetPontos();
        init();
		
	}
}
