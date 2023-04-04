package com.delpozo.ud20.ud20_05;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Ejercicio5 extends JFrame {

	private JPanel contentPane;
	private JTextArea taEventosRaton;

	/**
	 * Create the frame.
	 */
	public Ejercicio5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btLimpiar = new JButton("Limpiar");
		btLimpiar.addActionListener(limpiar);

		btLimpiar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btLimpiar.setBounds(178, 11, 89, 23);
		contentPane.add(btLimpiar);

		taEventosRaton = new JTextArea();
		taEventosRaton.addMouseListener(evento);
		
		taEventosRaton.setBounds(0, 45, 434, 216);
		contentPane.add(taEventosRaton);

		setVisible(true);

	}
	
	MouseAdapter evento = new MouseAdapter() {
		
		public void mouseClicked(MouseEvent e) {
			taEventosRaton.setText(taEventosRaton.getText()+"\nHas soltado el botón del ratón");
		}

		public void mousePressed(MouseEvent e) {
			taEventosRaton.setText(taEventosRaton.getText()+"\nHas presionado el botón del ratón");
		}

		public void mouseEntered(MouseEvent e) {
			taEventosRaton.setText(taEventosRaton.getText()+"\nHas entrado con el ratón en el TextArea");
		}

		public void mouseExited(MouseEvent e) {
			taEventosRaton.setText(taEventosRaton.getText()+"\nHas salido con el ratón del TextArea");
		}
		
	};

	ActionListener limpiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			taEventosRaton.setText("");
		}
	};

}
