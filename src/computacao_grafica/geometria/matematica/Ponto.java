package computacao_grafica.geometria.matematica;

import static computacao_grafica.geometria.main.ParametrosConfiguracao.PREVIEW_HEIGTH;
import static computacao_grafica.geometria.main.ParametrosConfiguracao.PREVIEW_WIDTH;
import static computacao_grafica.geometria.main.ParametrosConfiguracao.WINDOW_HEIGTH;
import static computacao_grafica.geometria.main.ParametrosConfiguracao.WINDOW_WIDTH;
import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_JANELA;
import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.NORMALIZADA;

public class Ponto {

    private static final String name = "Ponto";

    public enum ModoCoordenada {
        ABSOLUTA_JANELA, NORMALIZADA, ABSOLUTA_PREVIEW, ABSOLUTA_RECORTE;
    }

    private double x;

    private double y;

    private ModoCoordenada modoCoordenada;

    public Ponto(final ModoCoordenada modoCoordenada) {
        this.x = 0;
        this.y = 0;
        this.modoCoordenada = modoCoordenada;
    }

    public Ponto(final double x, final double y, final ModoCoordenada modoCoordenada) {
        this.x = x;
        this.y = y;
        this.modoCoordenada = modoCoordenada;
    }

    protected Ponto(Ponto p, final ModoCoordenada modoCoordenada) {
        this.x = p.getX();
        this.y = p.getY();
        this.modoCoordenada = modoCoordenada;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public ModoCoordenada getModoCoordenada() {
        return this.modoCoordenada;
    }

    public void setModoCoordenada(final ModoCoordenada modoCoordenada) {
        switch (modoCoordenada) {
            case NORMALIZADA:
                normalizarCoordenadas(this.modoCoordenada);
                break;
            case ABSOLUTA_JANELA:
                normalizarCoordenadas(this.modoCoordenada);
                converterParaCoordenadaAbsolutaJanela();
                break;
            case ABSOLUTA_PREVIEW:
                normalizarCoordenadas(this.modoCoordenada);
                converterParaCoordenadaAbsolutaPreview();
                break;
            case ABSOLUTA_RECORTE:
                break;
            default:
                throw new IllegalArgumentException();
        }
        this.modoCoordenada = modoCoordenada;
    }

    private void normalizarCoordenadas(final ModoCoordenada modoAnterior) {
        switch (modoAnterior) {
            case NORMALIZADA:
                // Meh :p.
                break;

            case ABSOLUTA_JANELA:
                this.x = this.x / WINDOW_WIDTH;
                this.y = this.y / WINDOW_HEIGTH;
                break;

            case ABSOLUTA_PREVIEW:
                this.x = this.x / PREVIEW_WIDTH;
                this.y = this.y / PREVIEW_HEIGTH;
                break;

            default:
                throw new IllegalArgumentException();
        }
    }

    private void converterParaCoordenadaAbsolutaJanela() {
        this.x = this.x * WINDOW_WIDTH;
        this.y = this.y * WINDOW_HEIGTH;
    }

    private void converterParaCoordenadaAbsolutaPreview() {
        this.x = this.x * PREVIEW_WIDTH;
        this.y = this.y * PREVIEW_HEIGTH;
    }

    public double calcularDistancia(Ponto q) {
        Ponto p = new Ponto(this, this.modoCoordenada);
        p.setModoCoordenada(ABSOLUTA_JANELA);
        if (q != null) {
            q.setModoCoordenada(ABSOLUTA_JANELA);
            return Math.sqrt(Math.pow((p.getY() - q.getY()), 2) + Math.pow((p.getX() - q.getX()), 2));
        }
        return 0.0;
    }

    public void clip(Retangulo retangulo) {
        final double largura = retangulo.getLargura();
        final double altura = retangulo.getAltura();

        this.x = ((this.x - retangulo.getPontoA().getX()) / largura);
        this.y = ((this.y - retangulo.getPontoA().getY()) / altura);
        this.modoCoordenada = NORMALIZADA;
    }

}
