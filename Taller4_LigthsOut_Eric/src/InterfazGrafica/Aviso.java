package InterfazGrafica;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aviso extends JDialog{
	
	
	public Aviso(InterfazGeneral interfaz) {
		
	   	JPanel panel = new JPanel();
	    panel.add(new JLabel("GANASTE!!!!!!"));
	    getContentPane().add(panel);    
	    setSize(300, 150);
	    setLocationRelativeTo(interfaz);
	
	
}
	
}
