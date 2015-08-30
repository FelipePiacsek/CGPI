package computacao_grafica.geometria.main;
import static java.awt.Color.RED;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

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

public class Principal extends JFrame implements MouseMotionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private boolean callback;
	
	private Ponto2D pontoA, pontoB;

	private SegmentoDeReta2D segmento;

	private List<SegmentoDeReta2D> retas = new ArrayList<SegmentoDeReta2D>();
	
	public static void main(String[] args) {
		/**
		 * Definicoes de janela
		 */
		Principal p = new Principal();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(500, 500);
		p.setVisible(true);
		
	}
	
	public Principal() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		if(segmento != null){
			segmento.desenharSegmentoReta();
		}
	}

	private void primeiraAula(Graphics g) {
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


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pontoA = new Ponto2D(e.getX(), e.getY(), RED);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pontoB = new Ponto2D(e.getX(), e.getY(), RED);
		segmento = new SegmentoDeReta2D(pontoA, pontoB, getGraphics());
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pontoB = new Ponto2D(e.getX(), e.getY(), RED);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		setTitle("Programa"+" (" + e.getX() + ", " + e.getY() + ")");		
	}
}
