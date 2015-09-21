package computacao_grafica.geometria.main;

import static computacao_grafica.geometria.main.ParametrosConfiguracao.LIMITE_MINIMO_HORIZONTAL;
import static computacao_grafica.geometria.matematica.Ponto.ModoCoordenada.ABSOLUTA_JANELA;
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
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

import computacao_grafica.geometria.arte.EdwardScissorHands;
import computacao_grafica.geometria.arte.PaulSignac;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.formas.Retangulo2D;
import computacao_grafica.geometria.formas.SegmentoDeReta2D;
import computacao_grafica.geometria.formas.Triangulo2D;

public class MainFrame extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

    private enum ModoDeAcao {
        RETA, CIRCUNFERENCIA, RETANGULO, TRIANGULO, RECORTE;
    }

    /**
     * Unique ID.
     */
    private static final long serialVersionUID = 1L;


    private JButton botaoModoReta = new JButton("Reta");

    private JButton botaoModoCircunferencia = new JButton("Circunferência");

    private JButton botaoModoRetangulo = new JButton("Retângulo");

    private JButton botaoModoTriangulo = new JButton("Triângulo");

    private JButton botaoModoRecorte = new JButton("Recorte");

    private Ponto2D pontoA, pontoB;

    private Forma2D elastico;
    
    private ModoDeAcao modoAtual = ModoDeAcao.RETA;

    private List<Forma2D> formas = new ArrayList<Forma2D>();

    private MicroVisor microVisor = new MicroVisor();

    private PaulSignac paulSignac;

    private EdwardScissorHands johnnyDepp = new EdwardScissorHands();
    
    private Set<Ponto2D> recorte;
    
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
        botaoModoReta.setLocation(20, 70);
        botaoModoReta.addActionListener(this);
        getContentPane().add(botaoModoReta);

        botaoModoCircunferencia.setSize(150, 25);
        botaoModoCircunferencia.setLocation(20, 120);
        botaoModoCircunferencia.addActionListener(this);
        getContentPane().add(botaoModoCircunferencia);

        botaoModoRetangulo.setSize(150, 25);
        botaoModoRetangulo.setLocation(20, 170);
        botaoModoRetangulo.addActionListener(this);
        getContentPane().add(botaoModoRetangulo);

        botaoModoTriangulo.setSize(150, 25);
        botaoModoTriangulo.setLocation(20, 220);
        botaoModoTriangulo.addActionListener(this);
        getContentPane().add(botaoModoTriangulo);
        
        botaoModoRecorte.setSize(150, 25);
        botaoModoRecorte.setLocation(20, 270);
        botaoModoRecorte.addActionListener(this);
        getContentPane().add(botaoModoRecorte);

        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(WHITE);

        microVisor.setBounds(0, 400, LIMITE_MINIMO_HORIZONTAL - 25, LIMITE_MINIMO_HORIZONTAL - 25);
        microVisor.setVisible(true);
        getContentPane().add(microVisor);
        

    }

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
        if(this.modoAtual != ModoDeAcao.RECORTE){
        	microVisor.atualizarVisor(formas, elastico);
        }
        if(recorte != null){
        	microVisor.atualizarVisor(recorte);
        	recorte = null;
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
    	if(e.getX() > LIMITE_MINIMO_HORIZONTAL){
    		pontoA = new Ponto2D(e.getX(), e.getY(), RED, ABSOLUTA_JANELA);
    	}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	if(pontoA != null && pontoB != null){
	        elastico = getElastico();
	        if(this.modoAtual != ModoDeAcao.RECORTE){
	        	formas.add(elastico);
	        }else{
	        	recorte = johnnyDepp.recortar(formas, (Retangulo2D) elastico);
	        }
	        elastico = null;
	        repaint();
	        pontoA = pontoB = null;
    	}
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	if(e.getX() > LIMITE_MINIMO_HORIZONTAL){
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
        if (e.getSource() == botaoModoCircunferencia) {
            this.modoAtual = ModoDeAcao.CIRCUNFERENCIA;
        }

        if (e.getSource() == botaoModoReta) {
            this.modoAtual = ModoDeAcao.RETA;
        }

        if (e.getSource() == botaoModoRetangulo) {
            this.modoAtual = ModoDeAcao.RETANGULO;
        }

        if (e.getSource() == botaoModoTriangulo) {
            this.modoAtual = ModoDeAcao.TRIANGULO;
        }
        
        if (e.getSource() == botaoModoRecorte) {
        	this.modoAtual = ModoDeAcao.RECORTE;
        }
    }
}