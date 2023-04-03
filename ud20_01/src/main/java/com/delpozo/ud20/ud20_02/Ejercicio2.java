package com.delpozo.ud20.ud20_02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	private JPanel contentPane;
	private String textPulsado = "";
	private JButton btBoton1, btBoton2;
	private JLabel lbPrincipal;

	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		setTitle("Ventana con interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbPrincipal = new JLabel("Has pulsado: ");
		lbPrincipal.setBounds(40, 24, 124, 27);
		contentPane.add(lbPrincipal);

		btBoton1 = new JButton("Boton 1");
		btBoton1.addActionListener(pulsado);

		btBoton1.setBounds(186, 26, 89, 23);
		contentPane.add(btBoton1);

		btBoton2 = new JButton("Boton 2");
		btBoton2.addActionListener(pulsado);

		btBoton2.setBounds(310, 26, 89, 23);
		contentPane.add(btBoton2);

		setVisible(true);
	}

	ActionListener pulsado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(btBoton1))
				lbPrincipal.setText("Has pulsado: " + btBoton1.getText().toString());
			else
				lbPrincipal.setText("Has pulsado: " + btBoton2.getText().toString());

		}
	};

}
