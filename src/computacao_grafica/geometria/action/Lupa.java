package computacao_grafica.geometria.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class Lupa implements FiguraFinder {

    private Set<Ponto2D> pontosASeremAvaliados;

    public Lupa(Ponto2D pontoClicado) {
        this.pontosASeremAvaliados = new HashSet<Ponto2D>();
        this.pontosASeremAvaliados.addAll(new Circunferencia2D(1, pontoClicado).getPontos());
        this.pontosASeremAvaliados.addAll(new Circunferencia2D(2, pontoClicado).getPontos());
        this.pontosASeremAvaliados.add(pontoClicado);
    }

    public Forma2D encontrar(Collection<Forma2D> formas) {
        Forma2D formaEncontrada = null;
        Iterator<Forma2D> itF2D = formas.iterator();
        while (formaEncontrada == null && itF2D.hasNext()) {
            Forma2D forma = itF2D.next();
            for (Ponto2D ponto : pontosASeremAvaliados) {
                Ponto2D avaliacao = new Ponto2D(ponto, ponto.get_cor(), ModoCoordenada.ABSOLUTA_JANELA);
                if (forma.getFormaMatematica().contem(avaliacao)) {
                    formaEncontrada = forma;
                    break;
                }
            }
        }
        return formaEncontrada;
    }
}
