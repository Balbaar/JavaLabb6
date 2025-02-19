package main.view.drawing;

import java.awt.Color;
import java.awt.Graphics;

public class DrawableCircle extends Drawable {
	private final int x;
	private final int y;
	private final int size;
	
	public DrawableCircle(Color color, int x, int y, int size) {
		super(color);
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x - size/2, y - size/2, size, size);
		g.setColor(Color.BLACK);
	}

}
