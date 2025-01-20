package game.core;
import java.awt.Rectangle;

import game.objects.interfaces.Drawable;

public class Physics {

	public static boolean Collision(Drawable ent1, Drawable ent2) {
		return (ent1.getBounds().intersects(ent2.getBounds()));
	}
	
	public static Rectangle getIntersection(Drawable ent1, Drawable ent2) {
		Rectangle r1=ent1.getBounds();
		Rectangle r2=ent2.getBounds();
		return r1.intersection(r2);
	}
}
