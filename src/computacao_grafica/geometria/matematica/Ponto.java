package computacao_grafica.geometria.matematica;
public class Ponto {

	private double x;
	private double y;

	public Ponto () {
		this.x = 0;
		this.y = 0;
	}

	public Ponto (double x, double y) {
		this.x = x;
		this.y = y;
	}

	protected Ponto (Ponto p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

    public double calcularDistancia(Ponto p) {
    	if(p !=null){
    		return Math.sqrt(Math.pow((p.getY() - getY()),2) +
					     Math.pow((p.getX() - getX()),2));
    	}
    	return 0.0;
	}


}