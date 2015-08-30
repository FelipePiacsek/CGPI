package computacao_grafica.geometria.main;

import javax.swing.*;

import computacao_grafica.geometria.formas.Ponto2D;

import java.awt.*;
import java.awt.event.*;

public class Programa extends JFrame implements MouseMotionListener, MouseListener {

	int _x, _y;
	
	public Programa() {

		/**
		 * Definicoes de janela
		 */
		super("Programa");

		// Eventos de mouse
		addMouseListener(this);
		addMouseMotionListener(this);

	}

    public void paint(Graphics g) {
    	  	   	
	    Ponto2D p; 

        // Cria um ponto
		p = new Ponto2D(_x, _y, Color.blue, "P");

    	// Desenha o ponto
		p.desenharPonto(g);

    }

	
	public static void main(String args[]) {
		Programa p = new Programa();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(500,500);
		p.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		setTitle("Programa"+" (" + e.getX() + ", " + e.getY() + ")");
	}
	public void mousePressed(MouseEvent mouseevent) {
		if (mouseevent.getButton() == 1) {
			_x = mouseevent.getX();
			_y = mouseevent.getY();
		}
		repaint(); // redesenha
	}

	public void mouseClicked(MouseEvent mouseevent)	{
	}

	public void mouseEntered(MouseEvent mouseevent) {
	}

	public void mouseExited(MouseEvent mouseevent) {
	}

	public void mouseReleased(MouseEvent mouseevent) {
	}

}
