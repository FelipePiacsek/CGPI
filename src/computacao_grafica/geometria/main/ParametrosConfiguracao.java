package computacao_grafica.geometria.main;

import java.util.HashMap;
import java.util.Map;

public abstract class ParametrosConfiguracao {

	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGTH = 600;

	public static final int PREVIEW_WIDTH = 200;
	public static final int PREVIEW_HEIGTH = 200;

	public static final int BUTTON_WIDTH = 150;
	public static final int BUTTON_HEIGTH = 25;
	
    public static final int LIMITE_MINIMO_HORIZONTAL = 220;
    
    public static final Map<String, ModoDeAcao> OPCOES_PRIMITIVOS;
    static
    {
        OPCOES_PRIMITIVOS = new HashMap<String, ModoDeAcao>();
        OPCOES_PRIMITIVOS.put("Reta", ModoDeAcao.RETA);
        OPCOES_PRIMITIVOS.put("Retângulo", ModoDeAcao.RETANGULO);
        OPCOES_PRIMITIVOS.put("Circunferência", ModoDeAcao.CIRCUNFERENCIA);
        OPCOES_PRIMITIVOS.put("Triângulo", ModoDeAcao.TRIANGULO);
        OPCOES_PRIMITIVOS.put("Polígono", ModoDeAcao.POLIGONO);
        OPCOES_PRIMITIVOS.put("Linha Poligonal", ModoDeAcao.LINHA_POLIGONAL);
    }
	public static enum ModoDeAcao {
		RETA, CIRCUNFERENCIA, RETANGULO, TRIANGULO, RECORTE, POLIGONO, LINHA_POLIGONAL;
	}
}
