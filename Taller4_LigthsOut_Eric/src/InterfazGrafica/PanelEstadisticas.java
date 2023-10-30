package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class PanelEstadisticas extends JPanel{
	
	private JLabel jugadas;
	private JLabel jugador;
	
	private JLabel numJugadas;
	private JLabel nomJugador;
	
	private int numJ;
	private String nomJ;
	
	
	
	public PanelEstadisticas(){
		this.nomJ = "AAA";
		this.numJ = 0;
		
		setPreferredSize(new Dimension(800,50));
		setBackground(Color.cyan);

		jugadas = new JLabel("Jugadas: ");
		jugador = new JLabel("jugador: ");
		numJugadas = new JLabel(Integer.toString(numJ));
		nomJugador = new JLabel(nomJ);
		
		//Layout
		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		
		this.add(Box.createHorizontalStrut(30));
		add(jugadas);
		this.add(Box.createHorizontalStrut(10));
		add(numJugadas);
		this.add(Box.createHorizontalStrut(250));
		add(jugador);
		this.add(Box.createHorizontalStrut(10));
		add(nomJugador);
		this.add(Box.createHorizontalStrut(30));

		
	}
	public void reiniciarJugadas() {
		remove(jugadas);
		remove(numJugadas);
		remove(jugador);
		remove(nomJugador);
		this.numJ = 0;
		
		numJugadas.setText(Integer.toString(numJ));
		
		add(jugadas);
		add(numJugadas);
		add(jugador);
		add(nomJugador);
	}
	
	public void changeJugadas() {
	    remove(jugadas);
		remove(numJugadas);
		remove(jugador);
		remove(nomJugador);
		this.numJ = numJ +1;
		
		numJugadas.setText(Integer.toString(numJ));
		
		add(jugadas);
		add(numJugadas);
		add(jugador);
		add(nomJugador);
	}
	
	public void changeJugador(String nombre) {
		 	remove(jugadas);
			remove(numJugadas);
			remove(jugador);
			remove(nomJugador);
			this.nomJ = nombre;
			
			nomJugador.setText(nomJ);
			
			add(jugadas);
			add(numJugadas);
			add(jugador);
			add(nomJugador);
	}
	 
	public void guardarScore(Top10 registro) {
		registro.agregarRegistro(nomJ, numJ);
	}
}
