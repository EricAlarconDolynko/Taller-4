package InterfazGrafica;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

public class InterfazGeneral extends JFrame{
	private Jugador jugador;
	private Scoreboard leaderBoard;
	private Aviso ganador;
	private RegistroTop10 registro10;
	private Top10 top10;
	private Tablero tablero;
	private int tamanio;
	private int dificultad;
	private PanelOpciones panelOpciones;
	private PanelMenu panelMenu;
	private PanelEstadisticas panelEstadistica;
	private PanelTablero panelTablero;
	
	public InterfazGeneral(){
		this.top10 = new Top10();
		this.jugador = new Jugador();
		top10.cargarRecords(new File("./data/top10.csv"));
		this.tamanio = 2;
		this.tablero = new Tablero(tamanio);
		panelOpciones = new PanelOpciones();
		panelMenu = new PanelMenu(panelOpciones,this);
		panelEstadistica = new PanelEstadisticas();
		panelTablero = new PanelTablero(tamanio,tablero,this);
		
		add(panelOpciones,BorderLayout.NORTH);
		add(panelTablero);
		add(panelMenu,BorderLayout.EAST);
		add(panelEstadistica,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		setTitle("LIGHTS OUT");
		setVisible(true);
	} 
	
	public void crearTablero(ArrayList<String> condicion) {
		remove(panelTablero);
		panelEstadistica.reiniciarJugadas();
		this.tamanio = Integer.parseInt(condicion.get(1));
		this.tablero = new Tablero(tamanio);
		if (condicion.get(0) == null){
			this.dificultad = 1;
		}
		else {
			dificultad = Integer.parseInt(condicion.get(0));
		}
		tablero.desordenar(dificultad);
		this.panelTablero = new PanelTablero(tamanio,tablero,this);
		add(panelTablero);
	}
	
	public void cambiarFichas(int row, int columna) {
		remove(panelTablero);
		tablero.jugar(row, columna);
		this.panelTablero = new PanelTablero(tamanio,tablero,this);
		add(panelTablero);
		panelEstadistica.changeJugadas();
		if (tablero.tableroIluminado() == true) {
			panelEstadistica.guardarScore(top10);
			ganador = new Aviso(this);
			ganador.setVisible(true);
		}
	}
	
	public void reiniciarTablero() {
		ArrayList<String> condicionVieja = new ArrayList<String>();
		condicionVieja.add(Integer.toString(dificultad));
		condicionVieja.add(Integer.toString(tamanio));
		crearTablero(condicionVieja);
		
	}
	
	public void mostrarTop10(){
		this.top10 = new Top10();
		top10.cargarRecords(new File("./data/top10.csv"));
		Collection<RegistroTop10> lista = top10.darRegistros();
		this.leaderBoard = new Scoreboard(this);
		for (RegistroTop10 registro: lista) {
			leaderBoard.agregarRegistro(registro);
		}
		leaderBoard.mostrarRegistro();
		leaderBoard.setVisible(true);
	}
	
	public void cambiarJugador() {
		jugador.cambiarJugador();
	}
	
	
	public static void main(String[] args) {
		InterfazGeneral lightsOut = new InterfazGeneral();
	}
	
}
