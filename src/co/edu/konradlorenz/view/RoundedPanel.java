package co.edu.konradlorenz.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;



public class RoundedPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private int radius;

	public RoundedPanel(int radius) {
		super();
		this.radius = radius;
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
	}
}