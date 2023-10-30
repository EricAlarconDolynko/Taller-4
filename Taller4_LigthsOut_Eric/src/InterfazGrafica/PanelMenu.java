package InterfazGrafica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener{

	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton cambiarJugador;
	private PanelOpciones panelOpciones;
	private InterfazGeneral interfazGeneral;
	private ArrayList<String> condiciones;
	
	public PanelMenu(PanelOpciones panelOpciones,InterfazGeneral interfazGeneral){
		this.interfazGeneral = interfazGeneral;
		this.panelOpciones = panelOpciones;
		this.setPreferredSize(new Dimension(250,550));
		
		nuevo = new JButton("              NUEVO              ");
		nuevo.setPreferredSize(new Dimension(150,100));
		nuevo.setActionCommand("NUEVO");
		nuevo.addActionListener(this);
		
		reiniciar = new JButton("            REINICIAR           ");
		reiniciar.setPreferredSize(new Dimension(150,40));
		reiniciar.setActionCommand("REINICIAR");
		reiniciar.addActionListener(this);
 
		top10 = new JButton("               TOP 10              ");
		top10.setPreferredSize(new Dimension(150,40));
		top10.setActionCommand("TOP10");
		top10.addActionListener(this);
		
		cambiarJugador = new JButton("   CAMBIAR JUGADOR   ");
		cambiarJugador.setPreferredSize(new Dimension(150,40));
		cambiarJugador.setActionCommand("JUGADOR");
		cambiarJugador.addActionListener(this);
		
		//Layout
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		
		this.add(Box.createVerticalStrut(30));
		this.add(Box.createVerticalStrut(30));
		this.add(Box.createVerticalStrut(30));
		add(nuevo);
		this.add(Box.createVerticalStrut(30));
		add(reiniciar);
		this.add(Box.createVerticalStrut(30));
		add(top10);
		this.add(Box.createVerticalStrut(30));
		add(cambiarJugador);
		this.add(Box.createVerticalStrut(30));
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if (grito.equals("NUEVO")) {
			this.condiciones = panelOpciones.estadoInicial();
			generarNuevoTablero();
		}
		else if (grito.equals("TOP10")) {
			interfazGeneral.mostrarTop10();
		}
		else if (grito.equals("REINICIAR")) {
			interfazGeneral.reiniciarTablero();
		}
		else if (grito.equals("JUGADOR")) {
			interfazGeneral.cambiarJugador();
		}
	}

	public void generarNuevoTablero() {
		interfazGeneral.crearTablero(condiciones);
	}
	
	
}
