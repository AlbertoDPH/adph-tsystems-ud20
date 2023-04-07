package com.delpozo.ud20.ud20_09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;

public class Ejercicio9 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Ejercicio9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 2, 2));
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("New button");
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("New button");
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_8 = new JButton("New button");
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_11 = new JButton("New button");
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_7 = new JButton("New button");
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_10 = new JButton("New button");
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_13 = new JButton("New button");
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		contentPane.add(btnNewButton_15);
		
		setVisible(true);
	}

}
