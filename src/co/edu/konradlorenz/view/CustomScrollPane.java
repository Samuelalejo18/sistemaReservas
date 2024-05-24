package co.edu.konradlorenz.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JScrollPane;

class CustomScrollPane extends JScrollPane {
    private int radius;

    public CustomScrollPane(Component view, int radius) {
        super(view);
        this.radius = radius;
        setOpaque(false); // Ensure background is painted correctly
        getViewport().setOpaque(false); // Ensure viewport is transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension arcs = new Dimension(radius, radius);
        int width = getWidth();
        int height = getHeight();

        // Draw rounded border
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }
}