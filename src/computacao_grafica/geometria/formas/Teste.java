package computacao_grafica.geometria.formas;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class Teste {

	public static void main(String[] args) {

		Ponto2D a = new Ponto2D(1, 1, Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
		Ponto2D b = new Ponto2D(1, 1, Color.RED, ModoCoordenada.ABSOLUTA_JANELA);
		Set<Ponto2D> pontos = new HashSet<Ponto2D>();
		pontos.add(a);
		pontos.add(b);
		System.out.println(pontos.size());
	}

}
