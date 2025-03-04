package game.objects.projectiles;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.objects.BaseObject;
import game.objects.interfaces.Projectile;
import game.utils.ImageLoader;

public class Bullet extends BaseObject implements Projectile {

	protected BufferedImage projectileImage;
	protected int Vx;
	private int Vy;
	protected Team team;

	public Bullet(int x, int y, int Vx, int Vy, Team team) {
		super(x, y);
		this.Vx = Vx;
		this.Vy = Vy;
		this.team = team;
		getImage();
		super.setHeight(projectileImage.getHeight());
		super.setWidth(projectileImage.getWidth());
	}

	public void getImage() {
		if (team.equals(Team.FRIENDLY)) {
			projectileImage = ImageLoader.bulletUp;
		} else if (team.equals(Team.ENEMY)) {
			projectileImage = ImageLoader.bulletDown;
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(projectileImage, x, y, null);
	}

	public void update() {
		y+= Vy;
		x+= Vx;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setVy(int Vy) {
		this.Vy = Vy;
	}

	public void setVx(int Vx) {
		this.Vx = Vx;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle (x, y, projectileImage.getWidth(), projectileImage.getHeight());
	}

	public int getDamage() {
		return 10;

	}

	@Override
	public Team team() {
		return team;
	}
}