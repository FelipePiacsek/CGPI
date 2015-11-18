package computacao_grafica.geometria.matematica;

import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class SegmentoDeReta implements FormaMatematica {

    private Ponto a;

    private Ponto b;

    private double coeficienteLinear;

    private double coeficienteAngular;

    private void init(Ponto a, Ponto b) {
        this.a = a;
        this.b = b;
        this.coeficienteAngular = (a.getY() - b.getY()) / (a.getX() - b.getX());
        this.coeficienteLinear = a.getY() - this.coeficienteAngular * a.getX();
    }

    public SegmentoDeReta(Ponto a, Ponto b) {
        init(a, b);
    }

    public Ponto getA() {
        return this.a;
    }

    public Ponto getB() {
        return this.b;
    }

    public void setA(Ponto p) {
        this.a = p;
    }

    public void setB(Ponto p) {
        this.b = p;
    }

    public double getY(double x) {
        return this.coeficienteAngular * x + this.coeficienteLinear;
    }

    public void inverterPontos() {
        Ponto p = this.a;
        this.a = this.b;
        this.b = p;
    }

    @Override
    public boolean contem(Ponto ponto) {
        if (this.a.getX() == this.b.getX()) {
            int inicio = 0;
            int fim = 0;
            if (this.a.getY() < this.b.getY()) {
                inicio = (int) this.a.getY();
                fim = (int) this.b.getY();
            } else {
                inicio = (int) this.b.getY();
                fim = (int) this.a.getY();
            }
            for (int i = inicio; i < fim; i++) {
                if (i == (int) ponto.getY() && (int) this.a.getX() == (int) ponto.getX()) {
                    return true;
                }
            }
            return false;
        } else {
            return (int) this.getY(ponto.getX()) == (int) ponto.getY();
        }
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        Ponto nA = new Ponto(a.getX() + deltaX, a.getY() + deltaY, ModoCoordenada.ABSOLUTA_JANELA);
        Ponto nB = new Ponto(b.getX() + deltaX, b.getY() + deltaY, ModoCoordenada.ABSOLUTA_JANELA);
        init(nA, nB);
    }

    @Override
    public void escalar(float fator, Ponto ponto) {
        double x1 = ponto.getX();
        double y1 = ponto.getX();
        Ponto nA = new Ponto(fator * (a.getX() - x1) + x1, fator * (a.getY() - y1) + y1, ModoCoordenada.ABSOLUTA_JANELA);
        Ponto nB = new Ponto(fator * (b.getX() - x1) + x1, fator * (b.getY() - y1) + y1, ModoCoordenada.ABSOLUTA_JANELA);
        init(nA, nB);
    }

    @Override
    public void rotacionar(float angulo, Ponto ponto) {
        double x1 = ponto.getX();
        double y1 = ponto.getX();
        double rad = (Math.PI * angulo) / 180;
        Ponto nA = new Ponto(x1 + Math.cos(rad) * (a.getX() - x1) - Math.sin(rad) * (a.getY() - y1), y1 + Math.sin(rad) * (a.getX() - x1) + Math.cos(rad) * (a.getY() - y1),
                ModoCoordenada.ABSOLUTA_JANELA);
        Ponto nB = new Ponto(x1 + Math.cos(rad) * (b.getX() - x1) - Math.sin(rad) * (b.getY() - y1), y1 + Math.sin(rad) * (b.getX() - x1) + Math.cos(rad) * (b.getY() - y1),
                ModoCoordenada.ABSOLUTA_JANELA);
        init(nA, nB);
    }

    public double getComprimento() {
        return a.calcularDistancia(b);
    }
}
