package com.delpozo.ud20.ud20_09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Ejercicio9 extends JFrame {

	private JPanel contentPane = new JPanel();
	private ArrayList<ImageIcon> cartas = new ArrayList<>();
	private JButton[] btCartas = new JButton[16];
	private int[] estadoCartas = new int[16];
	private int cartasReveladas;
	private int primeraCarta, segundaCarta;

	public Ejercicio9() {
		// Icono del panel del juego
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ejercicio9.class.getResource("/com/delpozo/ud20/ud20_09/imagenes/imagen1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setTitle("Juego de Parejas");
		setContentPane(contentPane);
		//Creacion del GridLayout de 4 X 4 con margen entre ellos de 2 px por cada lado
		contentPane.setLayout(new GridLayout(4, 4, 2, 2));

		//Inserta las imagenes en la lista cartas
		for (int i = 0; i < 8; i++) {
			ImageIcon imagen = new ImageIcon(
					"src/main/java/com/delpozo/ud20/ud20_09/imagenes/imagen" + (i + 1) + ".png");
			cartas.add(imagen);
			cartas.add(imagen);

		}
		// Funcion de la clase Collections encargada de barajar las cartas
		Collections.shuffle(cartas);

		//Creamos los botones los agregamos al Panel y los ponemos a la escucha
		for (int i = 0; i < 16; i++) {
			btCartas[i] = new JButton();
			btCartas[i].addActionListener(new BtCartaListener(i));
			estadoCartas[i] = 0; // 0: oculta, 1: revelada, 2: emparejada
			getContentPane().add(btCartas[i]);
		}
		setVisible(true);
	}

	private class BtCartaListener implements ActionListener {
		int index;

		public BtCartaListener(int index) {
			this.index = index;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (estadoCartas[index] == 0 && cartasReveladas < 2) {
				btCartas[index].setIcon(cartas.get(index));
				estadoCartas[index] = 1;
				cartasReveladas++;

				if (cartasReveladas == 1) {
					primeraCarta = index;
				} else {
					segundaCarta = index;
					if (cartas.get(primeraCarta).equals(cartas.get(segundaCarta))) {
						estadoCartas[primeraCarta] = 2;
						estadoCartas[segundaCarta] = 2;
						cartasReveladas = 0;
					} else {
						Timer temporizador = new Timer(200, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btCartas[primeraCarta].setIcon(null);
								btCartas[segundaCarta].setIcon(null);
								estadoCartas[primeraCarta] = 0;
								estadoCartas[segundaCarta] = 0;
								cartasReveladas = 0;
							}
						});
						temporizador.setRepeats(false);
						temporizador.start();

					}
				}
			}
		}
	}
}
