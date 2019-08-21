package Display;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Interface {
	public static void Tablero() {
	JFrame ventana = new JFrame();
	JTextField texto = new JTextField("Elige la columna donde deseas poner tu ficha");
	
	ventana.setSize(820, 700);
	ventana.setTitle("Conecta 4");
	ventana.setLocationRelativeTo(null);
	ventana.setLayout(new FlowLayout());
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ventana.add(texto);
	ventana.setVisible(true);
	}
}
