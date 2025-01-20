package game.objects.interfaces;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Drawable {
	public void update();
	public void render(Graphics2D g);
	public int getX();
	public int getY();
	public Rectangle getBounds();
	public void getImage();
}
