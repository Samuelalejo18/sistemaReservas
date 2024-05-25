package co.edu.konradlorenz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import co.edu.konradlorenz.view.RoundButton;
import co.edu.konradlorenz.view.ViewContactanos;
import co.edu.konradlorenz.view.ViewNosotros;

public class ControllerContactanos implements ActionListener {
	ViewContactanos viewContactanos;
	RoundButton btnIniciarSesion;
	JButton btnNosotros;
	JButton btnHospedajes;
	ControllerHospedajes controllerHospedajes;
	ControllerAutenticacion controllerAutenticacion;

	public ControllerContactanos() {
		viewContactanos = new ViewContactanos ();

		btnHospedajes = 	viewContactanos.getBtnHospedajes();
		btnNosotros = 	viewContactanos.getBtnNosotros();
		btnIniciarSesion = 	viewContactanos.getBtnIniciarSesion();
		btnIniciarSesion.addActionListener(this);
		btnHospedajes.addActionListener(this);
		btnNosotros.addActionListener(this);
		mostrarVentanaContactanos(true);
	}

	public void mostrarVentanaContactanos(boolean visible) {
		viewContactanos .setVisible(true);
		viewContactanos .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHospedajes) {
			viewContactanos.dispose();
			controllerHospedajes = new ControllerHospedajes();
			viewContactanos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	
		if(e.getSource()==  btnNosotros) {
			viewContactanos.dispose();
			ControllerNosotros controllerNosotros= new ControllerNosotros();
			viewContactanos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if (e.getSource() == btnIniciarSesion) {
			viewContactanos.dispose();
			controllerAutenticacion = new ControllerAutenticacion();
			viewContactanos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
