package computacao_grafica.geometria.matematica;

public interface FormaMatematica {

    public boolean contem(Ponto ponto);

    public void transladar(int deltaX, int deltay);
    
    public void escalar(float fator);
    
    public void rotacionar(float angulo);

}
