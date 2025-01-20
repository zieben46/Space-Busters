package game.objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.objects.interfaces.ItemEntity;
import game.utils.ImageLoader;

public class Item extends BaseObject implements ItemEntity {

	protected BufferedImage upgradeImage;
	protected int Vx;
	protected int Vy;
	private ItemType itemType;

	public Item(int x, int y, ItemType itemType) {
		super(x, y);
		Vx=0;
		Vy=1;
		this.itemType=itemType;
		getImage();
		super.setHeight(upgradeImage.getHeight());
		super.setWidth(upgradeImage.getWidth());
	}

	@Override
	public void getImage() {
		switch (itemType) {
		case movement :
			upgradeImage= ImageLoader.yellowUpgrade;
			break;
		case gunType :
			upgradeImage= ImageLoader.purpleUpgrade;
			break;
		case gunRate :
			upgradeImage= ImageLoader.greenUpgrade;
			break;
		case healthPack :
			upgradeImage= ImageLoader.healthPack;
			break;
		}
	}

	@Override
	public void update() {
		x+=Vx;
		y+=Vy;
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(upgradeImage, x, y, null);;

	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public ItemType itemType() {
		return itemType;
	}
}