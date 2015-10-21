package computacao_grafica.geometria.main;

import static computacao_grafica.geometria.main.ParametrosConfiguracao.LIMITE_MINIMO_HORIZONTAL;
import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_JANELA;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

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
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import computacao_grafica.geometria.arte.EdwardScissorHands;
import computacao_grafica.geometria.arte.PaulSignac;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Poligono2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;
import computacao_grafica.geometria.formas.Triangulo2D;
import computacao_grafica.geometria.main.ParametrosConfiguracao.ModoDeAcao;

public class MainFrame extends JFrame implements MouseMotionListener, MouseListener, ActionListener {



	/**
	 * Unique ID.
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelSelecionePrimitivo = new JLabel("Selecione um primitivo");

	private JButton botaoOkPrimitivo = new JButton("Ok");

	private JButton botaoModoRecorte = new JButton("Recorte");

	private JButton botaoModoLinhaPoligonal = new JButton("Linha Poligonal");

	private Ponto2D pontoA, pontoB, inicioPoligono, previousPontoPoligono, nextPontoPoligono;

	private Forma2D elastico;

	private Retangulo2D quadro;

	private Poligono2D poligono;

	private ModoDeAcao modoAtual = ModoDeAcao.RETA;

	private List<Forma2D> formas = new ArrayList<Forma2D>();

	private MicroVisor microVisor = new MicroVisor();

	private PaulSignac paulSignac;

	private EdwardScissorHands johnnyDepp = new EdwardScissorHands();

	private Set<Ponto2D> recorte;

	private JComboBox<String> opcoesPrimitivos = null;

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
		
		labelSelecionePrimitivo.setSize(70,30);
		labelSelecionePrimitivo.setLocation(0,0);
		getContentPane().add(labelSelecionePrimitivo);
		
		opcoesPrimitivos = new JComboBox<String>();
		for(String opcao : ParametrosConfiguracao.OPCOES_PRIMITIVOS.keySet()){
			opcoesPrimitivos.addItem(opcao);
		}
		opcoesPrimitivos.setSize(165,25);
		opcoesPrimitivos.setLocation(0,40);
		opcoesPrimitivos.addActionListener(this);
		getContentPane().add(opcoesPrimitivos);
		
		botaoOkPrimitivo.setSize(50, 30);
		botaoOkPrimitivo.setLocation(165, 40);
		botaoOkPrimitivo.addActionListener(this);
		getContentPane().add(botaoOkPrimitivo);

		botaoModoRecorte.setSize(150, 25);
		botaoModoRecorte.setLocation(20, 240);
		botaoModoRecorte.addActionListener(this);
		getContentPane().add(botaoModoRecorte);

		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(WHITE);

		microVisor.setBounds(0, 400, LIMITE_MINIMO_HORIZONTAL - 25, LIMITE_MINIMO_HORIZONTAL - 25);
		microVisor.setVisible(true);
		getContentPane().add(microVisor);

	}

	@Override
	public void paint(Graphics g) {
		paulSignac = new PaulSignac(g);
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.draw(new Line2D.Double(LIMITE_MINIMO_HORIZONTAL, 0, LIMITE_MINIMO_HORIZONTAL, getHeight()));
		g2.draw(new Line2D.Double(0, 425, LIMITE_MINIMO_HORIZONTAL, 425));
		g2.setPaint(Color.gray);
		g.clearRect(LIMITE_MINIMO_HORIZONTAL + 1, 0, getWidth(), getHeight());
		for (Forma2D forma : formas) {
			paulSignac.desenharJanela(forma);
		}
		if (elastico != null) {
			paulSignac.desenharJanela(elastico);
		}
		if (this.modoAtual != ModoDeAcao.RECORTE) {
			microVisor.atualizarVisor(formas, elastico);
		}
		if (recorte != null) {
			microVisor.atualizarVisor(recorte, quadro);
			recorte = null;
			quadro = null;
		}
		if (poligono != null) {
			paulSignac.desenharJanela(poligono);
			microVisor.atualizarVisor(poligono);
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
		if (isLeftMouseButton(e)) {
			if (this.modoAtual == ModoDeAcao.POLIGONO || this.modoAtual == ModoDeAcao.LINHA_POLIGONAL) {
				if (poligono == null) {
					poligono = new Poligono2D();
					inicioPoligono = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
					previousPontoPoligono = new Ponto2D(inicioPoligono, inicioPoligono.get_cor(),
							inicioPoligono.getModoCoordenada());
				} else {
					nextPontoPoligono = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
					SegmentoDeReta2D segmento = new SegmentoDeReta2D(previousPontoPoligono, nextPontoPoligono);
					poligono.addSegmento(segmento);
					previousPontoPoligono = new Ponto2D(nextPontoPoligono, nextPontoPoligono.get_cor(),
							nextPontoPoligono.getModoCoordenada());
					repaint();
				}
			} else if (e.getX() > LIMITE_MINIMO_HORIZONTAL) {
				pontoA = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
			}
		}
		if (isRightMouseButton(e)) {
			if (this.modoAtual == ModoDeAcao.POLIGONO) {
				if (poligono != null) {
					if (poligono.getSegmentos().size() < 2) {
						JOptionPane.showMessageDialog(null,
								"Crie pelo menos dois segmentos do polígono antes de fechá-lo.");
					} else {
						SegmentoDeReta2D segmento = new SegmentoDeReta2D(inicioPoligono, previousPontoPoligono);
						poligono.addSegmento(segmento);
						finalizarPoligono();
					}
				}
			}
		}
	}

	private void finalizarPoligono() {
		formas.add(poligono);
		poligono = null;
		inicioPoligono = previousPontoPoligono = nextPontoPoligono = null;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.modoAtual != ModoDeAcao.POLIGONO && this.modoAtual != ModoDeAcao.LINHA_POLIGONAL && pontoA != null
				&& pontoB != null) {
			elastico = getElastico();
			if (this.modoAtual != ModoDeAcao.RECORTE) {
				formas.add(elastico);
			} else {
				quadro = (Retangulo2D) elastico;
				recorte = johnnyDepp.recortar(formas, quadro);
			}
			elastico = null;
			repaint();
			pontoA = pontoB = null;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.modoAtual != ModoDeAcao.POLIGONO && this.modoAtual != ModoDeAcao.LINHA_POLIGONAL
				&& e.getX() > LIMITE_MINIMO_HORIZONTAL) {
			pontoB = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
			elastico = getElastico();
			repaint();
		}
	}

	private Forma2D getElastico() {
		Forma2D forma;
		switch (this.modoAtual) {
		case CIRCUNFERENCIA:
			forma = new Circunferencia2D(pontoA, pontoB);
			break;
		case RETA:
			forma = new SegmentoDeReta2D(pontoA, pontoB);
			break;
		case RETANGULO:
			forma = new Retangulo2D(pontoA, pontoB);
			break;
		case TRIANGULO:
			forma = new Triangulo2D(pontoA, pontoB);
			break;
		case RECORTE:
			forma = new Retangulo2D(pontoA, pontoB);
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
		if (this.modoAtual == ModoDeAcao.POLIGONO && inicioPoligono != null) {
			JOptionPane.showMessageDialog(null,
					"Finalize o poligono que está sendo desenhado apertando o botão direito.");
		} else {
			if (this.modoAtual == ModoDeAcao.LINHA_POLIGONAL) {
				finalizarPoligono();
			}
			mudarModoDeAcao(e);
		}
	}

	private void mudarModoDeAcao(ActionEvent e) {
		if (e.getSource() == botaoOkPrimitivo) {
			this.modoAtual = ParametrosConfiguracao.OPCOES_PRIMITIVOS.get(opcoesPrimitivos.getSelectedItem().toString());
		}

		if (e.getSource() == botaoModoRecorte) {
			this.modoAtual = ModoDeAcao.RECORTE;
		}

		if (e.getSource() == botaoModoLinhaPoligonal) {
			this.modoAtual = ModoDeAcao.LINHA_POLIGONAL;
		}
	}

}