package game.gameobjects;
import java.awt.Rectangle;
import java.util.Random;

import game.core.Game;
import game.gameobjects.interfaces.Drawable;

public abstract class BaseObject implements Drawable {
	protected int x;
	protected int y;
	int width;
	int height;
	Random random;

	public BaseObject(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public BaseObject() {
		random=new Random();
		x=random.nextInt(Game.WIDTH);
		y=-random.nextInt(300);
		//y=-40;
	}

	public Rectangle getBounds() {
		return new Rectangle (x, y, width, height);
	}
	
	public void setWidth(int width) {
		this.width=width;
	}
	
	public void setHeight(int height) {
		this.height=height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}