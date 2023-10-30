package InterfazGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Luz extends JPanel{
	
	private BufferedImage image;
	private int fila;
	private int columna;
	private boolean prendido;
	
	public Luz(int fila, int columna,boolean prendido) {
		this.fila = fila;
		this.columna = columna;
		this.prendido = prendido;
	}
	
	 @Override
	 public void paint(Graphics g) {

			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			
			try {
	            image = ImageIO.read(new File("./data/luz.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
	        int coordX = 10;
	        int coordY = 10;
	        
	        if (prendido == true) {
		     g.setColor(Color.yellow);
	        }
	        else {
	         g.setColor(Color.blue);	
	        }
	        
	        g.fillRect(coordX, coordY, 80, 80);

	        if (image != null) {
	            g.drawImage(image, coordX, coordY, 80, 80, this);
	        }
	    }
}
