package game.objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.utils.ImageLoader;

public class Item extends BaseObject {

	public enum Type {
		gunType,
		gunRate,
		movement,
		healthPack
	} 

	protected BufferedImage image;
	protected int Vx;
	protected int Vy;
	private Type type;

	public Item(int x, int y, Type type) {
		super(x, y);
		Vx = 0;
		Vy = 1;
		this.type = type;
		image = Item.getImage(type);
		super.setHeight(image.getHeight());
		super.setWidth(image.getWidth());
	}

	public static BufferedImage getImage(Type type) {
		return switch (type) {
			case movement -> ImageLoader.yellowUpgrade;
			case gunType -> ImageLoader.purpleUpgrade;
			case gunRate -> ImageLoader.greenUpgrade;
			case healthPack -> ImageLoader.healthPack;
			default -> throw new IllegalArgumentException("Unexpected Item Type: " + type);
		};
	}

	public Type getType() {
        return type;
    }
	
	@Override
	public void update() {
		x+= Vx;
		y+= Vy;
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(image, x, y, null);;

	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

}