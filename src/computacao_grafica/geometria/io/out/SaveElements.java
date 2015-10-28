package computacao_grafica.geometria.io.out;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import computacao_grafica.geometria.formas.Ponto2D;

public class SaveElements {

	private List<Ponto2D> pontos;
	
	private Color cor;
	
	private Map<String, Object> miscellaneous;
	
	private String nome;

	public SaveElements(){
		this.pontos = new ArrayList<Ponto2D>();
		this.miscellaneous = new HashMap<String, Object>();
		this.nome = null;
		this.cor = null;
	}
	public List<Ponto2D> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto2D> pontos) {
		this.pontos = pontos;
	}

	public Color getCor() {
		return cor;
	}
	
	public Integer getR(){
		return this.cor.getRed();
	}
	
	public Integer getG(){
		return this.cor.getGreen();
	}
	
	public Integer getB(){
		return this.cor.getBlue();
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public void addElementByName(String key, Object value){
		this.miscellaneous.put(key, value);
	}

	public Object getElementByName(String key){
		return this.miscellaneous.get(key);
	}
	public void addPonto(Ponto2D ponto) {
		this.pontos.add(ponto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
