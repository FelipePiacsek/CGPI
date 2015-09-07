package computacao_grafica.geometria.formas;
import static computacao_grafica.geometria.main.MainFrame.LIMITE_MINIMO_HORIZONTAL;

import java.awt.Color;
import java.awt.Graphics;

import computacao_grafica.geometria.matematica.Ponto;
public class Ponto2D extends Ponto implements Forma2D{
   
   private Color _cor;
   
   private String _str;
   
   private Color _corStr;
   
   private Graphics g;
   
   int larg = 4;
   
   public Ponto2D(Ponto p, Color cor, Graphics g){
	   super(p.getX(), p.getY());
	   setCor(cor);	 
	   setCorStr(Color.black);	 
	   setStr("");	
	   this.g = g;
   }
   
   public Ponto2D(int x, int y, Color cor, Graphics g){
      super((double)x, (double)y);
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr("");	 
      this.g = g;
   }

   public Ponto2D(int x, int y, Color cor, String str, Graphics g){
      super((double)x, (double)y);
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr(str);	 
      this.g = g;
   }

   Ponto2D(Ponto2D p2d, Color cor, Graphics g){
      super(p2d);	 
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr("");	 
      this.g = g;
  }
   
   Ponto2D(Graphics g){
      super();	 
      setCor(Color.black);	 
      setCorStr(Color.black);	 
      setStr("");	 
      this.g = g;
  }
   
   private void setCor(Color cor){
   	  _cor = cor;
   }
   private void setCorStr(Color corStr){
   	  _corStr = corStr;
   }
   private void setStr(String str){
   	  _str = str;
   }
   
   private void desenharPonto(){
       int x =  (int)getX();
       if(x > LIMITE_MINIMO_HORIZONTAL){
    	   g.setColor(_cor);
    	   g.fillOval(x, (int)getY() -1, 3, 3);// mais visivel (r = 3 pixels)
    	   g.setColor(_corStr);
    	   g.drawString(_str, (int)getX() + 5, (int)getY());
       }
   }

	@Override
	public void desenhar() {
		this.desenharPonto();
	}
}
