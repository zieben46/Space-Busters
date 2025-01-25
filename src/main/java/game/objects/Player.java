package game.objects;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.core.Controller.StatsTracker;
import game.objects.interfaces.FireBehavior.FrontFireBehavior;
import game.objects.interfaces.Projectile;
import game.objects.interfaces.FireBehavior.SideFireBehavior;
import game.objects.projectiles.behaviors.*;
import game.utils.ImageLoader;

public class Player extends BaseObject {

	//default gun behavior
	private static double coolDownTime = 0.5*1000;  //half second
	private static int bulletSpeed = 0;
	private static FrontFireBehavior frontGunBehavior = new SingleBullet();
	private static SideFireBehavior sideGunBehavior = new Off();
	private static double firedTime;

	//default upgrades 
	private static int speedUps = 0;
	private static int gunSpeedUps = 0;
	private static int bulletSpeedUps = 0;

	//default velocity
	protected static int Vx = 4;
	protected static int Vy = 4;

	private int health = 200;
	private boolean dead = false;
	protected BufferedImage[] image;
	protected double animeCount = 6.0;


	public Player(int x, int y) { 
		super(x, y);
		image = Player.getImage();
		super.setHeight(image[3].getHeight());
		super.setWidth(image[3].getWidth());
		StatsTracker.playerHealth = health;
	}

    //Base Object methods
	public static BufferedImage[] getImage() {
		return new BufferedImage[] {
			ImageLoader.myShip0,
			ImageLoader.myShip1,
			ImageLoader.myShip2,
			ImageLoader.myShip3,
			ImageLoader.myShip4,
			ImageLoader.myShip5
		};
	}
	
	@Override
	public void render(Graphics2D g) {
		if (!dead) {
			g.drawImage(image[(int) animeCount%6], x, y, null);
			animeCount+= .05;
		}
	}

	@Override
	public void update() {
		if (x>=Space.WIDTH-50&&!dead) {
			x = Space.WIDTH-50;
		}
		if (x<=0) {
			x = 0;
		}
		if (y>=Space.HEIGHT-50&&!dead) {
			y = Space.HEIGHT-50;
		}
		if (y<=0) {
			y = 0;
		}
		if (health<=0) {
			dead = true;
		}
	}

	public ArrayList<Projectile> fire() {
		double currentTime = System.currentTimeMillis();
		if (currentTime-firedTime>coolDownTime) {
			firedTime = currentTime;
			return frontGunBehavior.fire(x+20, y, -Vx, -Vy-bulletSpeed, Projectile.Team.FRIENDLY);
		}
		return null;
	}

	public ArrayList<Projectile> shootSide(int Vx) {
		double currentTime = System.currentTimeMillis();
		if (currentTime-firedTime>= coolDownTime) {
			firedTime = currentTime;
			return sideGunBehavior.fire(x+20, y, Vx, -Vy, Projectile.Team.FRIENDLY);
		}
		return null;
	}

	public void increaseHealth() {
		if (health<200) {
			health+= 20;
			StatsTracker.playerHealth = health;
		}
	}

	public void decreaseHealth() {
		if (health>0) {
			health -= 20;
			StatsTracker.playerHealth = health;
		} else {
			dead = true;
		}
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void consume(Item item) {	
		switch(item.getType()) {
		case gunType:
			//increaseShootBehavior();
			break;
		case gunRate:
			Player.gunSpeedUps++;
			break;
		case movement:
			Player.speedUps++;
			break;
		case healthPack:
			increaseHealth();
		}
	}

	public void moveLeft() {
		x -= Player.Vx;
	}
	public void moveRight() {
		x += Player.Vx;
	}
	public void moveUp() {
		y -= Player.Vy;
	}
	public void moveDown() {
		y += Player.Vy;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle (x, y, image[3].getWidth(), image[3].getHeight());
	}

	public int getWidth() {
		return super.getWidth();
	}

	public int getHeight() {
		return super.getHeight();
	}



	/////////static methods

	public static void setGunSpeedUps(int gunSpeedUps) {
		Player.gunSpeedUps = gunSpeedUps;
		Player.coolDownTime = 0.5*1000*Math.pow(0.85, gunSpeedUps);
		StatsTracker.gunRateUpgs = Player.gunSpeedUps;
	}

	public static void setBulletSpeedUps(int bulletSpeedUps) {
		Player.bulletSpeedUps = bulletSpeedUps;
		Player.bulletSpeed = 4+Player.bulletSpeedUps;
	}

	public static void setSpeedUps(int speedUps) {
		Player.speedUps = speedUps;
		Player.Vx = 4+Player.speedUps;
		Player.Vy = 4+Player.speedUps;
		StatsTracker.movementUpgs = Player.speedUps;
	}

	public static void setBulletBehavior(FrontFireBehavior frontGunBehavior) {
		Player.frontGunBehavior = frontGunBehavior;
	}

	public static void setMissileBehavior(SideFireBehavior sideGunBehavior) {
		Player.sideGunBehavior = sideGunBehavior;
	}

}