/*Andres Aguirre Alvarez A01228159
 * 28/06/18*/

package Display;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelConecta4 extends JPanel implements MouseMotionListener, MouseListener{
	private Image tablero,
				  fondo,
				  red,
				  yellow,
				  arrow;
	private int xPos,
				aXPos,
				columna,
				move=0;
	private String color;
	private boolean draw;
//	private Tablero game;
	private Espacio[][] juego;
	private int[] partida;
	
	public PanelConecta4() {
		super();
		this.juego=new Espacio[6][7];
		for(int i=0; i<this.juego.length; i++) {
			for (int j = 0; j < juego[i].length; j++) {
				this.juego[i][j]=new Espacio();
			}
		}
		this.draw=false;
		this.partida=new int[42];
		this.color="Red";
//		this.setPreferredSize(new Dimension(800, 600));
		this.setPreferredSize(getMaximumSize());
//		this.setPreferredSize(new Dimension(getMaximumSize().width-150, getMaximumSize().height));
		this.tablero=new ImageIcon("Fondo.png").getImage();
		this.fondo=new ImageIcon("wood.jpg").getImage();
		this.red=new ImageIcon("RED.png").getImage();
		this.yellow=new ImageIcon("YELLOW.png").getImage();
		this.arrow=new ImageIcon("arrow.png").getImage();
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}
	
	public void resetJuego() {
		for(int i=0; i<this.juego.length; i++) {
			for (int j = 0; j < juego[i].length; j++) {
				this.juego[i][j]=new Espacio();
			}
		}
		repaint();
	}
	
	public int nextMove(int columna, String color) {
		int fila=5;
		while (fila>=0) {
			if(this.juego[fila][columna].getFicha()==null) {
				this.juego[fila][columna].setFicha(color);
				return fila;
			}
			fila--;
		}
		return 0;//aqui poner si se pudo poner la ficha
	}
	
	public boolean win(int fila, int columna, String color) {
		int streak = 0,
			filita,
			columnita;
//		any win
//		vertical
		for (int i = 0; i < this.juego.length; i++) {
			if(this.juego[i][columna].getFicha()==color){
				streak++;
			} else { streak = 0; }
			if(streak == 4) {
				
				return true;
			}		
		}
		streak = 0;
//		Horizontal
		for (int j = 0; j < 7; j++) {
			if(this.juego[fila][j].getFicha()==color) {
				streak++;
			} else { streak = 0; }
			if(streak == 4) {
				return true;
			}		
		}
		streak = 0;
//		Diagonal \
		filita=fila;
		columnita=columna;
		while (filita > 0 && columnita > 0) {
			filita--;
			columnita--;
		}
		for (int i = filita, j = columnita; i < this.juego.length && j < this.juego[i].length; i++, j++) {
			if(this.juego[i][j].getFicha()==color) {
				streak++;
			} else { streak = 0; }
			if(streak == 4) {
				return true;
			}		
		}
		streak = 0;
//		Diagonal /
		filita=fila;
		columnita=columna;
		while (filita < 5 && columnita > 0) {
			filita++;
			columnita--;
		}
		for (int i = filita, j = columnita; i > 0 && j < this.juego[i].length; i--, j++) {
			if(this.juego[i][j].getFicha()==color) {
				streak++;
			} else { streak = 0; }
			if(streak == 4) {
				return true;
			}		
		}
		streak = 0;
		this.checkFull();
		return false;
	}
	
	public void checkFull() {
		boolean full = true;
		for (int i = 0; i < this.juego.length; i++) {
			for (int j = 0; j < this.juego[i].length; j++) {
				if(this.juego[i][j].getFicha()==null){
					full = false;
				}
			}
		}
		if (full == true) {
			this.draw=true;
		}
	}
	
	public void paintComponent(Graphics g) {
//		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawImage(this.tablero, 0, 0, this.getWidth(), this.getHeight(), this);
		if(this.move%2==0) {
			g.drawImage(this.yellow, this.xPos, 50, 100, 100, this);
		} else {
			g.drawImage(this.red, this.xPos, 50, 100, 100, this);
		}
		
//		g.drawImage(this.yellow, 410, 175, 100, 100, this);
//		g.drawImage(this.yellow, 410, 275, 100, 100, this);
//		g.drawImage(this.yellow, 410, 128+((982-128)/6), 100, 100, this);
//		g.drawImage(this.yellow, 236, 175, 100, 100, this);
//		g.drawImage(this.yellow, 236, 840, 100, 100, this);
//		g.drawImage(this.yellow, 1267, 175, 100, 100, this);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <7; j++) {
				if(this.juego[i][j].getFicha()=="Red") {
					g.drawImage(this.red, 236+(172*j), 175+(133*i), 100, 100, this);
				} else if(this.juego[i][j].getFicha()=="Yellow") {
					g.drawImage(this.yellow, 236+(172*j), 175+(133*i), 100, 100, this);
				}
			}
		}
		g.drawImage(this.arrow, this.aXPos, 120, 20, 20, this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.xPos=e.getX();
		this.repaint();
//		System.out.println(e.getY());
		if (e.getX()<this.getWidth()*.2) {
			this.aXPos=274+(172*0);
			this.repaint();
//			this.aXPos=this.getWidth()
		} else if (e.getX()<this.getWidth()*.3 && e.getX()>=this.getWidth()*.2) {
			this.aXPos=274+(172*1);
			repaint();
		} else if (e.getX()<this.getWidth()*.4 && e.getX()>=this.getWidth()*.3) {
			this.aXPos=274+(172*2);
			this.repaint();
		} else if (e.getX()<this.getWidth()*.5125 && e.getX()>=this.getWidth()*.4) {
			this.aXPos=274+(172*3);
			this.repaint();
		} else if (e.getX()<this.getWidth()*.625 && e.getX()>=this.getWidth()*.5125) {
			this.aXPos=274+(172*4);
			this.repaint();
		} else if (e.getX()<this.getWidth()*.725 && e.getX()>=this.getWidth()*.625) {
			this.aXPos=274+(172*5);
			this.repaint();
		} else if (e.getX()<this.getWidth()*.86 && e.getX()>=this.getWidth()*.725) {
			this.aXPos=274+(172*6);
			this.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		String color=null;
		if (e.getX()<this.getWidth()*.2) {
			this.columna=0;
		} else if (e.getX()<this.getWidth()*.3 && e.getX()>=this.getWidth()*.2) {
			this.columna=1;
		} else if (e.getX()<this.getWidth()*.4 && e.getX()>=this.getWidth()*.3) {
			this.columna=2;
		} else if (e.getX()<this.getWidth()*.5125 && e.getX()>=this.getWidth()*.4) {
			this.columna=3;
		} else if (e.getX()<this.getWidth()*.625 && e.getX()>=this.getWidth()*.5125) {
			this.columna=4;
		} else if (e.getX()<this.getWidth()*.725 && e.getX()>=this.getWidth()*.625) {
			this.columna=5;
		} else if (e.getX()<this.getWidth()*.86 && e.getX()>=this.getWidth()*.725) {
			this.columna=6;
		}
		move++;
		if(this.move%2==0) {
			this.color="Red";
		} else {
			this.color="Yellow";
		}
		if(this.win(this.nextMove(this.columna, this.color),this.columna,this.color)) {
			repaint();
			int input=JOptionPane.showConfirmDialog(this, "Gano " + this.color + ", desea iniciar una nueva partida?","Hello There", JOptionPane.YES_NO_OPTION);
			if(input==0) {
				for(int i=0; i<this.juego.length; i++) {
					for (int j = 0; j < juego[i].length; j++) {
						this.juego[i][j]=new Espacio();
					}
				}
				repaint();
			} else {
				System.exit(0);
			}
			
		} else if(draw) {
			int input2=JOptionPane.showConfirmDialog(this, "El tablero se lleno y hay empate, desea iniciar una nueva partida?","Hello There", JOptionPane.YES_NO_OPTION);
			if(input2==0) {
				for(int i=0; i<this.juego.length; i++) {
					for (int j = 0; j < juego[i].length; j++) {
						this.juego[i][j]=new Espacio();
					}
				}
				repaint();
			} else {
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
