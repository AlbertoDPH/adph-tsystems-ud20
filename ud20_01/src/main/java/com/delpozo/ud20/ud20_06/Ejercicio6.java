package com.delpozo.ud20.ud20_06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Ejercicio6 extends JFrame {

	private JPanel contentPane;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtIMC;
	private JButton btCalcularIMC;

	/**
	 * Create the frame.
	 */
	public Ejercicio6() {
		setTitle("Indice de Masa Corporal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbAltura = new JLabel("Altura(metros)");
		lbAltura.setFont(new Font("Verdana", Font.BOLD, 13));
		lbAltura.setBounds(30, 11, 120, 26);
		contentPane.add(lbAltura);

		JLabel lbIMC = new JLabel("IMC");
		lbIMC.setFont(new Font("Verdana", Font.BOLD, 13));
		lbIMC.setBounds(250, 48, 35, 26);
		contentPane.add(lbIMC);

		JLabel lbPeso = new JLabel("Peso(kg)");
		lbPeso.setFont(new Font("Verdana", Font.BOLD, 13));
		lbPeso.setBounds(250, 11, 71, 26);
		contentPane.add(lbPeso);

		txtAltura = new JTextField();
		txtAltura.setBounds(154, 16, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(335, 16, 93, 20);
		contentPane.add(txtPeso);

		txtIMC = new JTextField();
		txtIMC.setHorizontalAlignment(SwingConstants.CENTER);
		txtIMC.setColumns(10);
		txtIMC.setBounds(291, 53, 86, 20);
		contentPane.add(txtIMC);

		btCalcularIMC = new JButton("Calcular IMC");
		btCalcularIMC.addActionListener(calcula);
		btCalcularIMC.setFont(new Font("Verdana", Font.BOLD, 13));
		btCalcularIMC.setBounds(100, 48, 140, 23);
		contentPane.add(btCalcularIMC);

		setVisible(true);
	}

	ActionListener calcula = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			double peso = Double.parseDouble(txtPeso.getText());
			double altura = Double.parseDouble(txtAltura.getText());
			double imc = peso / Math.pow(altura, 2);

			double calIMC = Math.round(imc * 100d) / 100d;

			txtIMC.setText("" + calIMC);

		}
	};

}
