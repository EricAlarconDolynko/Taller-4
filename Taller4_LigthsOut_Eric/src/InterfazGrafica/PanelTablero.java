package InterfazGrafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTablero extends JPanel implements ActionListener, MouseListener{

	private int fila;
	private int columna;
	private InterfazGeneral interfaz;
	
	public PanelTablero(int tamanio,Tablero tablero,InterfazGeneral interfazGeneral) {
		this.interfaz = interfazGeneral;
		this.fila = tamanio;
		this.columna = tamanio;
		addMouseListener(this);
		
		//Layout
		if (fila != 0 || columna != 0) {
		
		GridLayout matriz = new GridLayout(fila,columna);
		setLayout(matriz);
		boolean[][] miniMatriz = tablero.darTablero();
		
		for (int f = 1;f <= fila; f++) {
			for (int c = 1; c <= columna; c++) {
				boolean prendido = miniMatriz[f-1][c-1];
				Luz casilla = new Luz(f,c,prendido);
				add(casilla);
			}
		}
	  }
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    int mouseX = e.getX();
	    int mouseY = e.getY();
	    int cellWidth = getWidth() / columna; 
	    int cellHeight = getHeight() /fila; 
	    int clickedColumn = mouseX / cellWidth;
	    int clickedRow = mouseY / cellHeight;
	    cambiarColor(clickedRow,clickedColumn);
	    
	}
	
	public void cambiarColor(int row, int column) {
		interfaz.cambiarFichas(row, column);
		System.out.println("CAMBIAR "+row + ";" + column) ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	//EXTRAS DEL MOUSE
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}
