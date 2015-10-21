package computacao_grafica.geometria.matematica;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

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

}
