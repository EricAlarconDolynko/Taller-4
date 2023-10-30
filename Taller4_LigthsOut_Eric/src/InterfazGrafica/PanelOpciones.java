package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PanelOpciones extends JPanel implements ActionListener{

	private JLabel tamanio;
	private JLabel dificultad;
	private JLabel cruz;
	private JLabel textFacil;
	private JLabel textMedio;
	private JLabel textDificil;
	private JComboBox<String> filas;
	private JComboBox<String> columnas;
	private JToggleButton facil;
	private JToggleButton medio;
	private JToggleButton dificil;
	
	private String finalDificulty;
	private String numFila;
	private String numColumna;

	
	
	public PanelOpciones() {
		
		setPreferredSize(new Dimension(800,50));
		setBackground(Color.cyan);
		tamanio = new JLabel("Tamaño:");
		dificultad = new JLabel("Dificultad: ");
		String[] matrizOpcion = {"0","1","2","3","4","5"};
		filas = new JComboBox<String>(matrizOpcion);
		cruz = new JLabel(" X ");
		columnas = new JComboBox<String>(matrizOpcion);
		columnas.addActionListener(this);
		
		facil = new JToggleButton();
		facil.setActionCommand("FACIL");
		facil.addActionListener(this);
		textFacil = new JLabel("Facil");
		
		medio = new JToggleButton();
		medio.setActionCommand("MEDIO");
		medio.addActionListener(this);
		textMedio = new JLabel("Medio");
		
		dificil = new JToggleButton();
		dificil.setActionCommand("DIFICIL");
		dificil.addActionListener(this);
		textDificil = new JLabel("Dificil");

		
		//LAYOUT
		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		
		this.add(Box.createHorizontalStrut(30));
		add(tamanio);
		add(filas);
		add(cruz);
		add(columnas);
		this.add(Box.createHorizontalStrut(80));
		add(dificultad);
		this.add(Box.createHorizontalStrut(30));
		add(facil);
		add(textFacil);
		this.add(Box.createHorizontalStrut(10));
		add(medio);
		add(textMedio);
		this.add(Box.createHorizontalStrut(10));
		add(dificil);
		add(textDificil);
		this.add(Box.createHorizontalStrut(150));
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		String grito = e.getActionCommand();
		if (grito.equals("FACIL")){
			medio.setSelected(false);
			dificil.setSelected(false);
			this.finalDificulty = "2";
		}
		else if (grito.equals("MEDIO")){
			facil.setSelected(false);
			dificil.setSelected(false);
			this.finalDificulty = "3";
		}
		else if (grito.equals("DIFICIL")){
			medio.setSelected(false);
			facil.setSelected(false);
			this.finalDificulty = "5";
		}		
	}
	
	public ArrayList<String> estadoInicial() {
		ArrayList<String> condiciones = new ArrayList<String>();
		condiciones.add(finalDificulty);
		this.numFila = (String)filas.getSelectedItem();
		this.numColumna = (String)columnas.getSelectedItem();
		condiciones.add(numFila);
		condiciones.add(numColumna);
		return condiciones;
	}
	
	
	
	
}
