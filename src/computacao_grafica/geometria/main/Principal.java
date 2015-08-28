package computacao_grafica.geometria.main;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;
import computacao_grafica.geometria.formas.Triangulo2D;
import computacao_grafica.geometria.matematica.Circunferencia;
import computacao_grafica.geometria.matematica.Retangulo;
import computacao_grafica.geometria.matematica.SegmentoDeReta;
import computacao_grafica.geometria.matematica.Triangulo;

class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Principal() {

		/**
		 * Definicoes de janela
		 */
		super("Programa");
		this.setSize(1000,1000);
		this.setVisible(true);
		

	}

	public void paint(Graphics g) {
		Ponto2D ponto[]; // coordenadas capturadas pelo mouse

		// Cria um vetor de 3 pontos
		ponto = new Ponto2D[6];

		// Define 3 pontos
		ponto[0] = new Ponto2D(100, 150, Color.red, "P1");
		ponto[1] = new Ponto2D(100, 88,  Color.red, "P2");
		ponto[2] = new Ponto2D(155, 175, Color.red, "P3");

		ponto[3] = new Ponto2D(100, 100, Color.red, "P1");
		ponto[4] = new Ponto2D(100, 150, Color.red, "P2");
		ponto[5] = new Ponto2D(200, 100, Color.red, "P3");

//		ponto[0].desenharPonto(g);
//		ponto[1].desenharPonto(g);
//		ponto[2].desenharPonto(g);
		
		SegmentoDeReta segmentoDeReta = new SegmentoDeReta(ponto[0], ponto[5]);
		SegmentoDeReta2D segmentoDeReta2D = new SegmentoDeReta2D(segmentoDeReta, g);
		segmentoDeReta2D.desenharSegmentoReta();
		
		Circunferencia circunferencia = new Circunferencia(120.0, ponto[2]);
		Circunferencia2D circunferencia2D = new Circunferencia2D(circunferencia, g);
		circunferencia2D.desenharCircunferencia();

		Retangulo retangulo = new Retangulo(ponto[0], ponto[2]);
		Retangulo2D retangulo2D = new Retangulo2D(retangulo, g);
		retangulo2D.desenharRetangulo();
		
		
		Triangulo triangulo = new Triangulo(ponto[3], ponto[4], ponto[5]);
		Triangulo2D triangulo2D = new Triangulo2D(triangulo, g);
		triangulo2D.desenharTriangulo();

	}


	public static void main(String args[]) {
		new Principal();
	}
}
