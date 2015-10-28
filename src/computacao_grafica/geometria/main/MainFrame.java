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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import computacao_grafica.geometria.action.Borracha;
import computacao_grafica.geometria.arte.EdwardScissorHands;
import computacao_grafica.geometria.arte.PaulSignac;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.FormaPoligonal2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;
import computacao_grafica.geometria.io.in.Parser;
import computacao_grafica.geometria.io.out.Saver;
import computacao_grafica.geometria.matematica.SegmentoDeReta;

public class MainFrame extends JFrame implements MouseMotionListener, MouseListener, ActionListener, KeyListener {

    private enum ModoDeAcao {
        RETA, CIRCUNFERENCIA, RETANGULO, RECORTE, POLIGONO, LINHA_POLIGONAL, APAGAR;
    }

    /**
     * Unique ID.
     */
    private static final long serialVersionUID = 1L;

    private JButton botaoModoReta = new JButton("Reta");

    private JButton botaoModoCircunferencia = new JButton("Circunferência");

    private JButton botaoModoRetangulo = new JButton("Retângulo");

    private JButton botaoModoRecorte = new JButton("Recorte");

    private JButton botaoModoPoligono = new JButton("Polígono");

    private JButton botaoModoLinhaPoligonal = new JButton("Linha Poligonal");

    private JButton botaoApagarPrimitivo = new JButton("Apagar");

    private Ponto2D pontoA, pontoB, inicioPoligono, previousPontoPoligono, nextPontoPoligono;

    private Forma2D elastico;

    private Retangulo2D quadro;

    private FormaPoligonal2D poligono2D;

    private ModoDeAcao modoAtual = ModoDeAcao.RETA;

    private List<Forma2D> formas = new ArrayList<Forma2D>();

    private MicroVisor microVisor = new MicroVisor();

    private PaulSignac paulSignac;

    private EdwardScissorHands johnnyDepp = new EdwardScissorHands();

    private Set<Ponto2D> recorte;

    private Map<JButton, ModoDeAcao> mapaAcoes = new HashMap<JButton, ModoDeAcao>();

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
        botaoModoReta.setLocation(20, 40);
        botaoModoReta.addActionListener(this);
        botaoModoReta.addKeyListener(this);
        getContentPane().add(botaoModoReta);
        mapaAcoes.put(botaoModoReta, ModoDeAcao.RETA);

        botaoModoCircunferencia.setSize(150, 25);
        botaoModoCircunferencia.setLocation(20, 90);
        botaoModoCircunferencia.addActionListener(this);
        botaoModoCircunferencia.addKeyListener(this);
        getContentPane().add(botaoModoCircunferencia);
        mapaAcoes.put(botaoModoCircunferencia, ModoDeAcao.CIRCUNFERENCIA);

        botaoModoRetangulo.setSize(150, 25);
        botaoModoRetangulo.setLocation(20, 140);
        botaoModoRetangulo.addActionListener(this);
        botaoModoRetangulo.addKeyListener(this);
        getContentPane().add(botaoModoRetangulo);
        mapaAcoes.put(botaoModoRetangulo, ModoDeAcao.RETANGULO);

        botaoApagarPrimitivo.setSize(150, 25);
        botaoApagarPrimitivo.setLocation(20, 190);
        botaoApagarPrimitivo.addActionListener(this);
        botaoApagarPrimitivo.addKeyListener(this);
        getContentPane().add(botaoApagarPrimitivo);
        mapaAcoes.put(botaoApagarPrimitivo, ModoDeAcao.APAGAR);

        botaoModoRecorte.setSize(150, 25);
        botaoModoRecorte.setLocation(20, 240);
        botaoModoRecorte.addActionListener(this);
        botaoModoRecorte.addKeyListener(this);
        getContentPane().add(botaoModoRecorte);
        mapaAcoes.put(botaoModoRecorte, ModoDeAcao.RECORTE);

        botaoModoPoligono.setSize(150, 25);
        botaoModoPoligono.setLocation(20, 290);
        botaoModoPoligono.addActionListener(this);
        botaoModoPoligono.addKeyListener(this);
        getContentPane().add(botaoModoPoligono);
        mapaAcoes.put(botaoModoPoligono, ModoDeAcao.POLIGONO);

        botaoModoLinhaPoligonal.setSize(150, 25);
        botaoModoLinhaPoligonal.setLocation(20, 340);
        botaoModoLinhaPoligonal.addActionListener(this);
        botaoModoLinhaPoligonal.addKeyListener(this);
        getContentPane().add(botaoModoLinhaPoligonal);
        mapaAcoes.put(botaoModoLinhaPoligonal, ModoDeAcao.LINHA_POLIGONAL);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        getContentPane().addKeyListener(this);
        setBackground(WHITE);

        microVisor.setBounds(0, 400, LIMITE_MINIMO_HORIZONTAL - 25, LIMITE_MINIMO_HORIZONTAL - 25);
        microVisor.setVisible(true);
        microVisor.addKeyListener(this);
        getContentPane().add(microVisor);

    }

    @Override
    public void paint(Graphics g) {
        paulSignac = new PaulSignac(g);
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(new Line2D.Double(LIMITE_MINIMO_HORIZONTAL, 0, LIMITE_MINIMO_HORIZONTAL, getHeight()));
        g2.draw(new Line2D.Double(0, 400, LIMITE_MINIMO_HORIZONTAL, 400));
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
        if (poligono2D != null) {
            paulSignac.desenharJanela(poligono2D);
            microVisor.atualizarVisor(poligono2D);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.modoAtual == ModoDeAcao.APAGAR && e.getX() > LIMITE_MINIMO_HORIZONTAL) {
            Ponto2D pontoClicado = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
            Borracha borracha = new Borracha(pontoClicado);
            Forma2D formaASerApagada = borracha.apagar(formas);
            if (formaASerApagada != null) {
                this.formas.remove(formaASerApagada);
                repaint();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isLeftMouseButton(e) && e.getX() > LIMITE_MINIMO_HORIZONTAL) {
            if (this.modoAtual == ModoDeAcao.POLIGONO || this.modoAtual == ModoDeAcao.LINHA_POLIGONAL) {
                if (poligono2D == null) {
                    poligono2D = new FormaPoligonal2D();
                    inicioPoligono = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
                    previousPontoPoligono = new Ponto2D(inicioPoligono, inicioPoligono.get_cor(), inicioPoligono.getModoCoordenada());
                } else {
                    nextPontoPoligono = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
                    SegmentoDeReta segmento = new SegmentoDeReta(previousPontoPoligono, nextPontoPoligono);
                    poligono2D.addSegmento(segmento);
                    previousPontoPoligono = new Ponto2D(nextPontoPoligono, nextPontoPoligono.get_cor(), nextPontoPoligono.getModoCoordenada());
                    repaint();
                }
            } else if (this.modoAtual != ModoDeAcao.APAGAR) {
                pontoA = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
            }
        }
        if (isRightMouseButton(e) && e.getX() > LIMITE_MINIMO_HORIZONTAL) {
            if (this.modoAtual == ModoDeAcao.POLIGONO) {
                if (poligono2D != null) {
                    if (poligono2D.quantidadeSegmentos() < 2) {
                        JOptionPane.showMessageDialog(null, "Crie pelo menos dois segmentos do polígono antes de fechá-lo.");
                    } else {
                        SegmentoDeReta segmento = new SegmentoDeReta(inicioPoligono, previousPontoPoligono);
                        poligono2D.addSegmento(segmento);
                        poligono2D.fechar();
                        finalizarPoligono();
                    }
                }
            }
        }
    }

    private void finalizarPoligono() {
        formas.add(poligono2D);
        poligono2D = null;
        inicioPoligono = previousPontoPoligono = nextPontoPoligono = null;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.modoAtual != ModoDeAcao.POLIGONO && this.modoAtual != ModoDeAcao.LINHA_POLIGONAL && pontoA != null && pontoB != null && e.getX() > LIMITE_MINIMO_HORIZONTAL) {
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
        if (pontoA != null && this.modoAtual != ModoDeAcao.POLIGONO && this.modoAtual != ModoDeAcao.LINHA_POLIGONAL && e.getX() > LIMITE_MINIMO_HORIZONTAL) {
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
            JOptionPane.showMessageDialog(null, "Finalize o poligono que está sendo desenhado apertando o botão direito.");
        } else {
            if (this.modoAtual == ModoDeAcao.LINHA_POLIGONAL) {
                finalizarPoligono();
            }
            mudarModoDeAcao(e);
        }
    }

    private void mudarModoDeAcao(ActionEvent e) {
        if (mapaAcoes.keySet().contains(e.getSource())) {
            this.modoAtual = mapaAcoes.get(e.getSource());
        } else {
            JOptionPane.showMessageDialog(null, "Ação não mapeada! Contacte o administrador!");
        }
    }

    private Set<Integer> keys = new HashSet<Integer>();
    
	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode() == KeyEvent.VK_CONTROL){
			keys.add(KeyEvent.VK_CONTROL);
		}
		if(k.getKeyCode() == KeyEvent.VK_S){
			if(keys.contains(KeyEvent.VK_CONTROL)){
				Saver vagnerLove = new Saver();
				vagnerLove.salva(formas);
			}
		}
		if(k.getKeyCode() == KeyEvent.VK_O){
			if(keys.contains(KeyEvent.VK_CONTROL)){
				Parser renatoAugusto = new Parser();
				this.formas = renatoAugusto.ler("Teste1.xml");
				repaint();
			}
		}
		if(k.getKeyCode() == KeyEvent.VK_DELETE){
			if(keys.contains(KeyEvent.VK_CONTROL)){
				this.formas = new ArrayList<Forma2D>();
				repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if(k.getKeyCode() == KeyEvent.VK_CONTROL || k.getKeyCode() == KeyEvent.VK_S || k.getKeyCode() == KeyEvent.VK_O){
			keys = new HashSet<Integer>();
		}
	}

	@Override
	public void keyTyped(KeyEvent k) {
		
	}

}