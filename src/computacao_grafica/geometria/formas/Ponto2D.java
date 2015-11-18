package computacao_grafica.geometria.formas;

import java.awt.Color;

import computacao_grafica.geometria.matematica.Ponto;

public class Ponto2D extends Ponto {

    private Color _cor;

    private String _str;

    private Color _corStr;

    int larg = 4;


    public Ponto2D(Ponto p, Color cor, final Ponto.ModoCoordenada modoCoordenada) {
        super(p.getX(), p.getY(), modoCoordenada);
        setCor(cor);
        setCorStr(Color.black);
        setStr("");
    }

    public Ponto2D(int x, int y, Color cor, final Ponto.ModoCoordenada modoCoordenada) {
        super(x, y, modoCoordenada);
        setCor(cor);
        setCorStr(Color.black);
        setStr("");
    }

    public Ponto2D(double x, double y, Color cor, final Ponto.ModoCoordenada modoCoordenada) {
        super(x, y, modoCoordenada);
        setCor(cor);
        setCorStr(Color.black);
        setStr("");
    }

    public Ponto2D(int x, int y, Color cor, String str, final Ponto.ModoCoordenada modoCoordenada) {
        super(x, y, modoCoordenada);
        setCor(cor);
        setCorStr(Color.black);
        setStr(str);
    }

    Ponto2D(Ponto2D p2d, Color cor, final Ponto.ModoCoordenada modoCoordenada) {
        super(p2d, modoCoordenada);
        setCor(cor);
        setCorStr(Color.black);
        setStr("");
    }

    private void setCor(Color cor) {
        _cor = cor;
    }

    private void setCorStr(Color corStr) {
        _corStr = corStr;
    }

    private void setStr(String str) {
        _str = str;
    }

    public Color get_cor() {
        return _cor;
    }

    public void set_cor(Color _cor) {
        this._cor = _cor;
    }

    public String get_str() {
        return _str;
    }

    public void set_str(String _str) {
        this._str = _str;
    }

    public Color get_corStr() {
        return _corStr;
    }

    public void set_corStr(Color _corStr) {
        this._corStr = _corStr;
    }

    public void log(String... nome) {
        StringBuilder sb = new StringBuilder();
        if (nome != null && nome.length == 1) {
            sb.append("Título: ");
            sb.append(nome[0]);
            sb.append("\nX: ");
        } else {
            sb.append("X: ");
        }
        sb.append(this.getX());
        sb.append("\nY: ");
        sb.append(this.getY());
        sb.append("\nModo coordenada: ");
        sb.append(this.getModoCoordenada());
        System.out.println(sb.toString());
    }

}
