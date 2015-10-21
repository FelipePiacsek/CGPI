package computacao_grafica.geometria.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class BorrachaLegacy {

    private Set<Ponto2D> pontosASeremAvaliados;

    public BorrachaLegacy(Ponto2D pontoClicado) {
        this.pontosASeremAvaliados = new HashSet<Ponto2D>();
        this.pontosASeremAvaliados.addAll(new Circunferencia2D(1, pontoClicado).getPontos());
        this.pontosASeremAvaliados.addAll(new Circunferencia2D(2, pontoClicado).getPontos());
        this.pontosASeremAvaliados.add(pontoClicado);
    }

    public Forma2D apagar(Collection<Forma2D> formas) {
        Forma2D formaASerApagada = null;
        Iterator<Forma2D> itF2D = formas.iterator();
        while (formaASerApagada == null && itF2D.hasNext()) {
            Forma2D forma = itF2D.next();
            for (Ponto2D ponto : forma.getPontos()) {
                Ponto2D avaliacao = new Ponto2D(ponto, ponto.get_cor(), ModoCoordenada.ABSOLUTA_PREVIEW);
                avaliacao.setModoCoordenada(ModoCoordenada.ABSOLUTA_JANELA);
                if (avaliarPontos(avaliacao)) {
                    formaASerApagada = forma;
                    break;
                }
            }
        }
        return formaASerApagada;
    }

    private boolean avaliarPontos(Ponto2D avaliacao) {
        for (Ponto2D p : pontosASeremAvaliados) {
            p.setModoCoordenada(ModoCoordenada.ABSOLUTA_JANELA);
            if ((int) p.getX() == (int) avaliacao.getX() && (int) p.getY() == (int) avaliacao.getY()) {
                return true;
            }
        }
        return false;
    }
}
