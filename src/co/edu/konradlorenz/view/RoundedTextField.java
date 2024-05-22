package co.edu.konradlorenz.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedTextField extends javax.swing.JTextField {
	  private int cornerRadius;

	    public RoundedTextField(int columns, int cornerRadius) {
	        super(columns);
	        this.cornerRadius = cornerRadius;
	        setOpaque(false);
	        setBorder(new EmptyBorder(5, 10, 5, 10)); // Ajusta los márgenes internos
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(getBackground());

	        // Dibujar el fondo redondeado
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
	        
	        super.paintComponent(g2);
	        g2.dispose();
	    }

	    @Override
	    protected void paintBorder(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(getForeground());

	        // Dibujar el borde redondeado
	        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
	        
	        g2.dispose();
	    }

	    @Override
	    public void setBorder(Border border) {
	        // Ignorar el establecimiento de borde para evitar problemas con el redondeo
	    }
}
