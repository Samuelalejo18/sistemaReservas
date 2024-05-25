package co.edu.konradlorenz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import co.edu.konradlorenz.view.RoundButton;
import co.edu.konradlorenz.view.ViewNosotros;

public class ControllerNosotros implements ActionListener {

	ViewNosotros viewNosotros;
	RoundButton btnIniciarSesion;
	JButton btnContactanos;
	JButton btnHospedajes;
	ControllerHospedajes controllerHospedajes;
	ControllerAutenticacion controllerAutenticacion;

	public ControllerNosotros() {
		viewNosotros = new ViewNosotros();

		btnHospedajes = viewNosotros.getBtnHospedajes();
		btnContactanos = viewNosotros.getBtnContactanos();
		btnIniciarSesion = viewNosotros.getBtnIniciarSesion();
		btnIniciarSesion.addActionListener(this);
		btnHospedajes.addActionListener(this);
		btnContactanos.addActionListener(this);
		mostrarVentanaNostros(true);

	}

	public void mostrarVentanaNostros(boolean visible) {
		viewNosotros.setVisible(true);
		viewNosotros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHospedajes) {
			viewNosotros.dispose();
			controllerHospedajes = new ControllerHospedajes();
			viewNosotros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		
		if(e.getSource()== btnContactanos) {
			viewNosotros.dispose();
			ControllerContactanos controllerContactanos= new ControllerContactanos();
			viewNosotros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if (e.getSource() == btnIniciarSesion) {
			viewNosotros.dispose();
			controllerAutenticacion = new ControllerAutenticacion();
			viewNosotros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		// TODO Auto-generated method stub

	}

}
