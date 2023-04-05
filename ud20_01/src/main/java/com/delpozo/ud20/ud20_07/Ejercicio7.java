package com.delpozo.ud20.ud20_07;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio7 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtResultado;
	private JButton btEurosPtas, btPtasEuro, btCambiar;
	private double cantidad;
	private final double EURO = 166.386;

	/**
	 * Create the frame.
	 */
	public Ejercicio7() {
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

		btEurosPtas = new JButton("Euros a ptas");
		btEurosPtas.addActionListener(convertir);
		btEurosPtas.setFont(new Font("Verdana", Font.BOLD, 11));
		btEurosPtas.setBounds(127, 45, 127, 23);
		contentPane.add(btEurosPtas);

		btPtasEuro = new JButton("Ptas a Euro");
		btPtasEuro.addActionListener(convertir);
		btPtasEuro.setFont(new Font("Verdana", Font.BOLD, 11));
		btPtasEuro.setBounds(127, 45, 113, 23);
		contentPane.add(btPtasEuro);

		btCambiar = new JButton("Cambiar");
		btCambiar.addActionListener(cambiar);
		btCambiar.setFont(new Font("Verdana", Font.BOLD, 11));
		btCambiar.setBounds(266, 46, 113, 23);
		contentPane.add(btCambiar);

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

}
