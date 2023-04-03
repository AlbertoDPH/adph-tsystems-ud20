package com.delpozo.ud20.ud20_03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	private JPanel contentPane;
	private JLabel lbBtn1, lbBtn2;
	private JButton btBoton1, btBoton2;
	private int contBoton1 = 1;
	private int contBoton2 = 1;

	/**
	 * Create the frame.
	 */
	public Ejercicio3() {
		setTitle("Ventana con más interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbBtn1 = new JLabel("Boton 1: ");
		lbBtn1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbBtn1.setBounds(47, 22, 150, 25);
		contentPane.add(lbBtn1);

		lbBtn2 = new JLabel("Boton 2: ");
		lbBtn2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbBtn2.setBounds(253, 22, 150, 25);
		contentPane.add(lbBtn2);

		btBoton1 = new JButton("Boton 1");
		btBoton1.addActionListener(btPulsado);

		btBoton1.setBounds(98, 77, 89, 23);
		contentPane.add(btBoton1);

		btBoton2 = new JButton("Boton 2");
		btBoton2.addActionListener(btPulsado);

		btBoton2.setBounds(233, 77, 89, 23);
		contentPane.add(btBoton2);

		setVisible(true);
	}

	ActionListener btPulsado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(btBoton1))
				lbBtn1.setText("Boton 1: " + (contBoton1++) + " veces");
			
			else lbBtn2.setText("Boton 2: " + (contBoton2++) + " veces"); 
		}
	};

}
