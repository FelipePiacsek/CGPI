package computacao_grafica.geometria.main;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;
import computacao_grafica.geometria.formas.Triangulo2D;
import computacao_grafica.geometria.matematica.Ponto;

public class MainFrame extends JFrame implements MouseMotionListener, MouseListener, ActionListener{

	private enum ModoDeDesenho{
		RETA, CIRCUNFERENCIA, RETANGULO, TRIANGULO;
	}
	/**
	 * Unique ID.
	 */
	private static final long serialVersionUID = 1L;

	public static final int LIMITE_MINIMO_HORIZONTAL = 200;

	JButton botaoModoReta = new JButton("Reta");

	JButton botaoModoCircunferencia = new JButton("Circunferência");
	
	JButton botaoModoRetangulo = new JButton("Retângulo");
	
	JButton botaoModoTriangulo = new JButton("Triângulo");

	private Ponto2D pontoA, pontoB;

	private Forma2D elastico;

	private ModoDeDesenho modoAtual = ModoDeDesenho.RETA;
	
	private List<Forma2D> formas = new ArrayList<Forma2D>();
	
	private Ponto[][] pontos = new Ponto[1000][600];
	
	public static void main(String[] args) {
		/**
		 * Definicoes de janela
		 */
		MainFrame p = new MainFrame();
		p.setVisible(true);

		
	}
	
	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		this.setResizable(false);
		getContentPane().setLayout(null);	
		
		botaoModoReta.setSize(150, 25);
		botaoModoReta.setLocation(20, 170);
		botaoModoReta.addActionListener(this);
		getContentPane().add(botaoModoReta);
		
		botaoModoCircunferencia.setSize(150, 25);
		botaoModoCircunferencia.setLocation(20, 220);
		botaoModoCircunferencia.addActionListener(this);
		getContentPane().add(botaoModoCircunferencia);
		
		botaoModoRetangulo.setSize(150, 25);
		botaoModoRetangulo.setLocation(20, 270);
		botaoModoRetangulo.addActionListener(this);
		getContentPane().add(botaoModoRetangulo);
		
		botaoModoTriangulo.setSize(150, 25);
		botaoModoTriangulo.setLocation(20, 320);
		botaoModoTriangulo.addActionListener(this);
		getContentPane().add(botaoModoTriangulo);

		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(WHITE);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) getGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	        RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.draw(new Line2D.Double(200, 0, 200, getHeight()));
	    g2.setPaint(Color.gray);
		g.clearRect(201, 0, getWidth(), getHeight());
		for (Forma2D forma : formas) {
			forma.desenhar();
		}
		if (elastico != null){
			elastico.desenhar();
		}
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
		pontoA = new Ponto2D(e.getX(), e.getY(), RED, getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		elastico = getElastico();
		setPontosLimpeza();
		salvarPontos(elastico);
		formas.add(elastico);
		elastico = null;
		pontoA = pontoB = null;
		repaint();
	}

	private void setPontosLimpeza() {
		
	}

	private void salvarPontos(Forma2D elastico) {
//		for(Ponto p : elastico.getPontos()){
//			pontos[(int)p.getX()][(int)p.getY()] = p;
//		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pontoB = new Ponto2D(e.getX(), e.getY(), RED, getGraphics());
		elastico = getElastico();
		repaint();
	}

	private Forma2D getElastico() {
		Forma2D forma;
		switch (this.modoAtual){
		case CIRCUNFERENCIA:
			forma = new Circunferencia2D(pontoA, pontoB, getGraphics());
			break;
		case RETA:
			forma = new SegmentoDeReta2D(pontoA, pontoB, getGraphics());
			break;
		case RETANGULO:
			forma = new Retangulo2D(pontoA, pontoB, getGraphics());
			break;
		case TRIANGULO:
			forma = new Triangulo2D(pontoA, pontoB, getGraphics());
			break;
		default:
			forma = null;
			break;
		
		}
		return forma;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoModoCircunferencia){
			this.modoAtual = ModoDeDesenho.CIRCUNFERENCIA;
		}
		
		if(e.getSource() == botaoModoReta){
			this.modoAtual = ModoDeDesenho.RETA;
		}
		
		if(e.getSource() == botaoModoRetangulo){
			this.modoAtual = ModoDeDesenho.RETANGULO;
		}
		
		if(e.getSource() == botaoModoTriangulo){
			this.modoAtual = ModoDeDesenho.TRIANGULO;
		}
	}
}