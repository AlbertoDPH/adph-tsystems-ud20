package com.delpozo.ud20.ud20_08;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
//import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Ejercicio8 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtResultado;
	private JButton btBorrar;
	private JButton btEurosPtas, btPtasEuro, btCambiar;
	private double cantidad;
	private final double EURO = 166.386;
	private InputMap mapaEntrda;

	/**
	 * Create the frame.
	 */
	public Ejercicio8() {
		setTitle("Calculadora cambio de monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbCantidad = new JLabel("Cantidad a covertir");
		lbCantidad.setFont(new Font("Verdana", Font.BOLD, 12));
		lbCantidad.setBounds(29, 11, 133, 23);
		contentPane.add(lbCantidad);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Verdana", Font.BOLD, 12));
		lblResultado.setBounds(296, 11, 83, 23);
		contentPane.add(lblResultado);

		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtCantidad.setBounds(168, 13, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtResultado.setColumns(10);
		txtResultado.setBounds(371, 13, 105, 20);
		contentPane.add(txtResultado);

		//Para poder subrayar las letras tenemos que poner los textos en <html> con <u> lo podemos subrayar
		btEurosPtas = new JButton("<html><u>E</u>uros a Ptas</html>");
		btEurosPtas.addActionListener(convertir);
		btEurosPtas.setFont(new Font("Verdana", Font.BOLD, 11));
		btEurosPtas.setBounds(79, 45, 130, 23);
		contentPane.add(btEurosPtas);

		btPtasEuro = new JButton("<html><u>P</u>tas a Euros</html>");
		btPtasEuro.addActionListener(convertir);
		btPtasEuro.setFont(new Font("Verdana", Font.BOLD, 11));
		btPtasEuro.setBounds(79, 45, 130, 23);
		contentPane.add(btPtasEuro);

		btCambiar = new JButton("<html>Ca<u>m</u>biar</html>");
		btCambiar.addActionListener(cambiar);
		btCambiar.setFont(new Font("Verdana", Font.BOLD, 11));
		btCambiar.setBounds(218, 46, 113, 23);
		contentPane.add(btCambiar);

		btBorrar = new JButton("<html><u>B</u>orrar</html>");
		btBorrar.addActionListener(borrar);
		btBorrar.setFont(new Font("Verdana", Font.BOLD, 11));
		btBorrar.setBounds(351, 46, 113, 23);
		contentPane.add(btBorrar);
		
		eventoTeclado();

		setVisible(true);
		
		

	}
	
	
	
	

	ActionListener convertir = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(btEurosPtas)) {
				btEurosPtas.setVisible(false);
				btPtasEuro.setVisible(true);
			} else {
				btEurosPtas.setVisible(true);
				btPtasEuro.setVisible(false);
			}
		}
	};

	ActionListener cambiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			txtResultado.setText("");
			double conversion = 0.0;

			if (e.getSource().equals(btCambiar)) {
				if (btEurosPtas.isVisible()) {
					cantidad = Double.parseDouble(txtCantidad.getText());
					conversion = Math.round((EURO * cantidad) * 100d) / 100d;
					txtResultado.setText("" + conversion);
				} else {
					conversion = Math.round((cantidad / EURO) * 100d) / 100d;
					txtResultado.setText("" + conversion);
				}
			}
		}
	};

	ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(btBorrar)) {
				txtCantidad.setText("");
				txtResultado.setText("");
			}

		}
	};

	private void eventoTeclado() {

		// Usaremos un maparEntrada para los eventos de teclado
		ComponentInputMap mapaEntrada = new ComponentInputMap(contentPane);
		contentPane.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, mapaEntrada);

		// Crear combinacion de teclas
		KeyStroke ctrlE = KeyStroke.getKeyStroke("ctrl E");

		// Asignar combinacion teclas a objeto-descripcion
		mapaEntrada.put(ctrlE, "EuroPtas");

		// Asignar descripcion a accion
		ActionMap mapaAccion = contentPane.getActionMap();
		mapaAccion.put("EuroPtas", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				convertir.actionPerformed(new ActionEvent(btEurosPtas, ActionEvent.ACTION_PERFORMED, null));
			}
		});
		
		// Configuración para btPtasEuro responda a eventos de teclado
	    KeyStroke ctrlP = KeyStroke.getKeyStroke("ctrl P");
	    mapaEntrada.put(ctrlP, "PtasEuro");

	    mapaAccion.put("PtasEuro", new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	            convertir.actionPerformed(new ActionEvent(btPtasEuro, ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	  	    
	 // Configuración para btCambiar responda a eventos de teclado
	    KeyStroke ctrlM = KeyStroke.getKeyStroke("ctrl M");
	    mapaEntrada.put(ctrlM, "Cambiar");

	    mapaAccion.put("Cambiar", new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	            cambiar.actionPerformed(new ActionEvent(btCambiar, ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	    
	 // Configuración para btBorrar responda a eventos de teclado
	    KeyStroke ctrlB = KeyStroke.getKeyStroke("ctrl B");
	    mapaEntrada.put(ctrlB, "Borrar");

	    mapaAccion.put("Borrar", new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	            borrar.actionPerformed(new ActionEvent(btBorrar, ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
