/*Andres Aguirre Alvarez A01228159
 * 28/06/18*/

package Display;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelControlConecta4 extends JPanel implements ActionListener{
	private JButton jb;
	private PanelConecta4 pd;
	
	public PanelControlConecta4(PanelConecta4 pd){
		super();
		setPreferredSize(new Dimension(300, getMaximumSize().height));
		this.pd=pd;
		
		this.jb=new JButton("Nueva Partida");
		this.jb.setPreferredSize(new Dimension(250, 50));
		this.jb.addActionListener(this);
		
		this.add(jb);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.pd.resetJuego();
	}
}
