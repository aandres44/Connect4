package Display;

public class Fichas {
//	Atributos
	private String color;
	private int columna;
//	Constructores
	public Fichas() {
		this.setColor(null);
	}
//	Métodos de Acceso
	public String getColor() {
		return color;
	}
	public String setColor(String color) {
		this.color = color;
		return color;
	}
	public int getColumna() {
		return columna;
	}
	public int setColumna(int columna) {
		this.columna = columna;
		return columna;
	}

	
	
}
