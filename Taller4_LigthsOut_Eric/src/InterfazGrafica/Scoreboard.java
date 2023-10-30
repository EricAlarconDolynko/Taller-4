package InterfazGrafica;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class Scoreboard extends JDialog{
	private static int num;
	private ArrayList<JLabel> listaLabel;
	private InterfazGeneral interfaz;
	
	public Scoreboard(InterfazGeneral interfaz) {
		num = 0;
		this.interfaz = interfaz;
		this.listaLabel = new ArrayList<JLabel>();
}
	
	public void agregarRegistro(RegistroTop10 registro) {
		String nombre = registro.darNombre();
		String puntaje = Integer.toString(registro.darPuntos());
		num += 1;
		JLabel label = new JLabel(num+". "+nombre+" "+ puntaje);
		if (num <= 3) {
		label.setForeground(Color.green);
		}
		else if (num > 3 && num <= 7) {
		label.setForeground(Color.orange);
		}
		else {
		label.setForeground(Color.red); 
		}
		listaLabel.add(label);
	}
	
	public void mostrarRegistro() {
	    JPanel panel = new JPanel();
	    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	    panel.setLayout(boxLayout);
	    
	    for (JLabel adiciones: listaLabel) {
	    	JPanel labelPanel = new JPanel(); 
	        labelPanel.add(adiciones); 
	        panel.add(labelPanel); 
	    }
	    
	    BoxLayout mainBoxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
	    getContentPane().setLayout(mainBoxLayout);

	    getContentPane().add(Box.createVerticalGlue()); 
	    getContentPane().add(panel); 
	    getContentPane().add(Box.createVerticalGlue()); 
	    getContentPane().add(panel);
	    setSize(600, 600);
	    setLocationRelativeTo(interfaz);
	    
	    
	}
}
