package co.edu.konradlorenz.view;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends javax.swing.JButton {
	public RoundButton(String label) {
		super(label);
		setContentAreaFilled(false);
		setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		// Use anti-aliasing for smoother edges
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Background color
		if (getModel().isArmed()) {
			g2.setColor(getBackground().darker());
		} else {
			g2.setColor(getBackground());
		}
		// Draw the rounded rectangle
		g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

		// Draw the button's label
		FontMetrics fm = g2.getFontMetrics();
		Rectangle r = getBounds();
		String text = getText();
		int x = (r.width - fm.stringWidth(text)) / 2;
		int y = (r.height - fm.getHeight()) / 2 + fm.getAscent();
		g2.setColor(getForeground());
		g2.drawString(text, x, y);

		g2.dispose();
		super.paintComponent(g);

	}
}
