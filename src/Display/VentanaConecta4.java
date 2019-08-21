/*Andres Aguirre Alvarez A01228159
 * 28/06/18*/

package Display;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaConecta4 extends JFrame{
	private PanelConecta4 pc;
	
	public VentanaConecta4() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pc=new PanelConecta4();
		this.add(pc,BorderLayout.CENTER);
		this.add(new PanelControlConecta4(pc), BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		VentanaConecta4 v=new VentanaConecta4();
	}
}
