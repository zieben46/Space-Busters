package game.objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.utils.ImageLoader;

public class Item extends BaseObject {

	public enum ItemType {
		gunType,
		gunRate,
		movement,
		healthPack
	}

	protected BufferedImage image;
	protected int Vx;
	protected int Vy;
	private ItemType itemType;

	public Item(int x, int y, ItemType itemType) {
		super(x, y);
		Vx=0;
		Vy=1;
		this.itemType=itemType;
		image=Item.getImage(itemType);
		super.setHeight(image.getHeight());
		super.setWidth(image.getWidth());
	}

	public static BufferedImage getImage(ItemType itemType) {
		return switch (itemType) {
			case movement -> ImageLoader.yellowUpgrade;
			case gunType -> ImageLoader.purpleUpgrade;
			case gunRate -> ImageLoader.greenUpgrade;
			case healthPack -> ImageLoader.healthPack;
			default -> throw new IllegalArgumentException("Unexpected ItemType: " + itemType);
		};
	}

	public ItemType getItemType() {
        return itemType;
    }
	
	@Override
	public void update() {
		x+=Vx;
		y+=Vy;
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