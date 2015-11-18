package computacao_grafica.geometria.matematica;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class FormaPoligonal implements FormaMatematica {

    private List<SegmentoDeReta> segmentos = new ArrayList<SegmentoDeReta>();

    private boolean fechada = false;

    public void addSegmento(SegmentoDeReta segmento) {
        segmentos.add(segmento);
    }

    public List<SegmentoDeReta> getSegmentos() {
        return unmodifiableList(segmentos);
    }

    @Override
    public boolean contem(Ponto ponto) {
        for (SegmentoDeReta r : segmentos) {
            if (r.contem(ponto)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFechada() {
        return fechada;
    }

    public void fechar() {
        this.fechada = true;
    }

    @Override
    public void transladar(int deltaX, int deltaY) {
        for (SegmentoDeReta segmentoDeReta : segmentos) {
            segmentoDeReta.transladar(deltaX, deltaY);
        }
    }

	@Override
	public void escalar(float fator) {
		for (SegmentoDeReta segmentoDeReta : segmentos) {
			segmentoDeReta.escalar(fator);
		}
		double xA, xB;
		double yA, yB;
		SegmentoDeReta s, r;
		int ate;
		if(this.fechada){
			ate = segmentos.size() - 2;
		}else{
			ate = segmentos.size() - 1;
		}
		for(int i = 1;i <= ate; i++){
			s = segmentos.get(i-1);
			r = segmentos.get(i);
			xA = r.getA().getX();
			yA = r.getA().getY();
			xB = s.getB().getX();
			yB = s.getB().getY();
			int deltaX = (int)(xB-xA);
			int deltaY = (int)(yB-yA);
			r.transladar(deltaX, deltaY);
		}
	}

	@Override
	public void rotacionar(float angulo) {
		for (SegmentoDeReta segmentoDeReta : segmentos) {
			segmentoDeReta.rotacionar(angulo);
		}
		
	}
}
