package game.objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.core.Controller;
import game.core.Game;
import game.utils.ImageLoader;

public class Space {
	public static final int WIDTH = Game.WIDTH;
	public static final int HEIGHT = Game.HEIGHT;

	private int x;
	private int y;
	private BufferedImage background;
	private BufferedImage canvas;  //draws onto this
	private Controller controller;

	public Space(int x, int y, int levelNumber) {
		this.x = x;
		this.y = y;
		background = ImageLoader.spaceBackground;	
		canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		controller = new Controller(levelNumber);
	}


	public void render(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) canvas.getGraphics();
		g2.drawImage(background, 0, 0, null);		
		controller.render(g2);	
		g.drawImage(canvas, x, y, null);
		g2.dispose();
	}

	public void update() {
		controller.update();
	}
}
