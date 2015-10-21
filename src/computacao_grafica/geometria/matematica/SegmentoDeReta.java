package computacao_grafica.geometria.matematica;

public class SegmentoDeReta implements FormaMatematica {

    private Ponto a;

    private Ponto b;

    private double coeficienteLinear;

    private double coeficienteAngular;

    public SegmentoDeReta(Ponto a, Ponto b) {
        this.a = a;
        this.b = b;
        this.coeficienteAngular = (a.getY() - b.getY()) / (a.getX() - b.getX());
        this.coeficienteLinear = a.getY() - this.coeficienteAngular * a.getX();
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
}
