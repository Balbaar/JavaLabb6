package main.view.drawing;
import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	private final ArrayList<Drawable> drawables;

	public DrawingPanel(ArrayList<Drawable> drawables, int width, int height, Color bgColor) {
		this.drawables = drawables;
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(bgColor);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		synchronized (drawables) {
			for (Drawable d : drawables) {
				d.draw(g);
			}
		}
	}
}
