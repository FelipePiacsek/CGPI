package computacao_grafica.geometria.matematica;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class Circunferencia implements FormaMatematica {

    private double raio;

    private Ponto centro;

    public Circunferencia(double raio, Ponto centro) {
        this.raio = raio;
        this.centro = centro;
    }

    public Circunferencia(Ponto centro, Ponto extremo) {
        this.raio = centro.calcularDistancia(extremo);
        this.centro = centro;
    }

    public double getRaio() {
        return this.raio;
    }

    public Ponto getCentro() {
        return this.centro;
    }

    public Ponto getPontoDaCircunferencia(double angulo) {
        return new Ponto(centro.getX() + cos(angulo) * this.raio, centro.getY() + sin(angulo) * this.raio, centro.getModoCoordenada());
    }

    @Override
    public boolean contem(Ponto ponto) {
        final double xMenosAQuadrado = (ponto.getX() - centro.getX()) * (ponto.getX() - centro.getX());
        final double yMenosBQuadrado = (ponto.getY() - centro.getY()) * (ponto.getY() - centro.getY());
        final double raioQuadrado = raio * raio;
        return ((int) xMenosAQuadrado + (int) yMenosBQuadrado == (int) raioQuadrado);
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        Ponto nCentro = new Ponto(centro.getX() + deltaX, centro.getY() + deltaY, ModoCoordenada.ABSOLUTA_JANELA);
        this.centro = nCentro;
    }

    @Override
    public void escalar(float fator, Ponto ponto) {
        this.raio = this.raio * fator;
    }

    @Override
    public void rotacionar(float angulo, Ponto ponto) {
        double x1 = ponto.getX();
        double y1 = ponto.getX();
        double rad = (Math.PI * angulo) / 180;
        this.centro = new Ponto(x1 + Math.cos(rad) * (centro.getX() - x1) - Math.sin(rad) * (centro.getY() - y1),
                y1 + Math.sin(rad) * (centro.getX() - x1) + Math.cos(rad) * (centro.getY() - y1), ModoCoordenada.ABSOLUTA_JANELA);

    }

}
