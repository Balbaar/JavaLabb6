package main.view.drawing;
import java.awt.Color;
import java.awt.Graphics;

public class DrawableString extends Drawable {
	private final String text;
	private final int x;
	private final int y;

	public DrawableString(Color color, String text, int x, int y) {
		super(color);
		this.text = text;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawString(text, x, y);
		g.setColor(Color.BLACK);
	}
}
