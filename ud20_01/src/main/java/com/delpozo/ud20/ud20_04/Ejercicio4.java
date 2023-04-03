package com.delpozo.ud20.ud20_04;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;

public class Ejercicio4 extends JFrame {

	private JPanel contentPane;
	private JLabel lbEventos;
	private JTextArea taVisualiza;

	/**
	 * Create the frame.
	 */
	public Ejercicio4() {
		setTitle("Ventana oyente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lbEventos = new JLabel("Eventos");
		lbEventos.setBounds(10, 59, 53, 17);
		lbEventos.setFont(new Font("Verdana", Font.PLAIN, 13));

		taVisualiza = new JTextArea("Texto inicial");
		taVisualiza.setBounds(73, 11, 351, 128);
		contentPane.setLayout(null);

		contentPane.add(lbEventos);
		contentPane.add(taVisualiza);

		setVisible(true);

		// Instaciamos la clase Ventana
		Ventana v1 = new Ventana();

		// Ponemos JPanel a la escucha para que detecte cualquier cambio que se haga en
		// JPanel
		addWindowListener(v1);

	}

	// Clase interna adaptadora para elegir los métodos que queremos utililzar de la
	// interface WindowListener
	class Ventana extends WindowAdapter {

		public void windowOpened(WindowEvent e) {
			taVisualiza.setText(taVisualiza.getText() + "" + "\nVentana abierta primera vez");
		}

		public void windowActivated(WindowEvent e) {
			taVisualiza.setText(taVisualiza.getText() + "" + "\nVentana activada");
		}

		public void windowDeactivated(WindowEvent e) {
			taVisualiza.setText(taVisualiza.getText() + "" + "\nVentana NO activa");
		}

		public void windowDeiconified(WindowEvent e) {
			taVisualiza.setText(taVisualiza.getText() + "" + "\nVentana minimizada normal");
		}

	}

}
