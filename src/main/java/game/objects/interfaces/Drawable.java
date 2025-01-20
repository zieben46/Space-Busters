package game.objects.interfaces;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Drawable {
	void update();
	void render(Graphics2D g);
	int getX();
	int getY();
	Rectangle getBounds();
}
