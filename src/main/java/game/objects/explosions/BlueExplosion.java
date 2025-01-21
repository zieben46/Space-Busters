package game.objects.explosions;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.utils.ImageLoader;

public class BlueExplosion extends BaseExplosion {
	public BlueExplosion(Point point) {
		super(point);
	}

	@Override
	public void setImage() {
		int width = 50;
		int height = 50;
		imageArray = new BufferedImage[46];
		images = ImageLoader.blueSprite;
		
		int counter = 0;
		for (int y = 251; y>= 1; y = y-height) {
			for (int x = 251; x>= 1; x = x-width) {
				imageArray[counter] = images.getSubimage(x, y, 49, 49);
				counter++;
			}
		}
	}
}
