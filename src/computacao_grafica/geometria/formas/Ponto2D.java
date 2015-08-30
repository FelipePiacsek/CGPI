package computacao_grafica.geometria.formas;
import java.awt.*;

import computacao_grafica.geometria.matematica.Ponto;
public class Ponto2D extends Ponto {
   Color _cor;
   String _str;
   Color _corStr;
   
   int larg = 4;
   
   public Ponto2D(Ponto p, Color cor){
	   super(p.getX(), p.getY());
	   setCor(cor);	 
	   setCorStr(Color.black);	 
	   setStr("");	 
   }
   
   public Ponto2D(int x, int y, Color cor){
      super((double)x, (double)y);
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr("");	 
   }

   public Ponto2D(int x, int y, Color cor, String str){
      super((double)x, (double)y);
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr(str);	 
   }

   Ponto2D(Ponto2D p2d, Color cor){
      super(p2d);	 
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr("");	 
  }
   
   Ponto2D(){
      super();	 
      setCor(Color.black);	 
      setCorStr(Color.black);	 
      setStr("");	 
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
   
   public void desenharPonto(Graphics g){
       g.setColor(_cor);
       g.fillOval((int)getX() -1, (int)getY() -1, 3, 3);// mais visivel (r = 3 pixels)
       
       g.setColor(_corStr);
       g.drawString(_str, (int)getX() + 5, (int)getY());
   }
}
