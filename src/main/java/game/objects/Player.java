package game.objects;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.core.StatsTracker;
import game.objects.interfaces.ProjectileEntity;
import game.objects.interfaces.ItemEntity;
import game.objects.projectiles.projectilebehaviors.*;
import game.utils.ImageLoader;

public class Player extends BaseObject {

	//default velocity
	protected static int Vx=4;
	protected static int Vy=4;

	//default bullet behavior
	private static double coolDownTime=0.5*1000;  //half second
	private static int bulletSpeed=0;
	private static ProjectileBehavior bulletBehavior = new SingleBulletBehavior();
	private static MissileBehavior missileBehavior;
	private static double firedTime;

	//default upgrades 
	private static int speedUps=0;
	private static int gunSpeedUps=0;
	private static int bulletSpeedUps=0;

	//default new object fields
	private int health=200;
	private boolean dead=false;
	protected BufferedImage[] shipImage;
	protected double animeCount=6.0;


	public Player(int x, int y) { 
		super(x, y);
		shipImage=new BufferedImage[6];
		getImage();
		super.setHeight(shipImage[3].getHeight());
		super.setWidth(shipImage[3].getWidth());
		StatsTracker.playerHealth=health;
	}

    //Base Object methods
	public void getImage() {
		shipImage[0]= ImageLoader.myShip0;
		shipImage[1]= ImageLoader.myShip1;
		shipImage[2]= ImageLoader.myShip2;
		shipImage[3]= ImageLoader.myShip3;
		shipImage[4]= ImageLoader.myShip4;
		shipImage[5]= ImageLoader.myShip5;
	}

	@Override
	public void render(Graphics2D g) {
		if (!dead) {
			g.drawImage(shipImage[(int) animeCount%6], x, y, null);
			animeCount+=.05;
		}
	}

	@Override
	public void update() {
		if (x>=Space.WIDTH-50&&!dead) {
			x=Space.WIDTH-50;
		}
		if (x<=0) {
			x=0;
		}
		if (y>=Space.HEIGHT-50&&!dead) {
			y=Space.HEIGHT-50;
		}
		if (y<=0) {
			y=0;
		}
		if (health<=0) {
			dead=true;
		}
	}

	public ArrayList<ProjectileEntity> shootBullet() {
		double currentTime=System.currentTimeMillis();
		if (currentTime-firedTime>coolDownTime) {
			firedTime=currentTime;
			return bulletBehavior.shootBullet(x+20, y, -Vx, -Vy-bulletSpeed, ProjectileEntity.Team.FRIENDLY);
		}
		return null;
	}

	public ArrayList<ProjectileEntity> shootMissile(int Vx) {
		double currentTime=System.currentTimeMillis();
		if (currentTime-firedTime>=coolDownTime) {
			firedTime=currentTime;
			return missileBehavior.shootMissile(x+20, y, Vx, -Vy, ProjectileEntity.Team.FRIENDLY);
		}
		return null;
	}

	public void increaseHealth() {
		if (health<200) {
			health+=20;
			StatsTracker.playerHealth=health;
		}
	}

	public void decreaseHealth() {
		if (health>0) {
			health-=20;
			StatsTracker.playerHealth=health;
		} else {
			dead=true;
		}
	}

	public boolean isDead() {
		return health<=0;
	}

	public void consume(ItemEntity upgradeEntity) {	
		switch(upgradeEntity.itemType()) {
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
		x-=Player.Vx;
	}
	public void moveRight() {
		x+=Player.Vx;
	}
	public void moveUp() {
		y-=Player.Vy;
	}
	public void moveDown() {
		y+=Player.Vy;
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
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle (x, y, shipImage[3].getWidth(), shipImage[3].getHeight());
	}

	public int getWidth() {
		return super.getWidth();
	}

	public int getHeight() {
		return super.getHeight();
	}



	/////////static methods

	public static void setGunSpeedUps(int gunSpeedUps) {
		Player.gunSpeedUps=gunSpeedUps;
		Player.coolDownTime=0.5*1000*Math.pow(0.85, gunSpeedUps);
		StatsTracker.gunRateUpgs=Player.gunSpeedUps;
	}

	public static void setBulletSpeedUps(int bulletSpeedUps) {
		Player.bulletSpeedUps=bulletSpeedUps;
		Player.bulletSpeed=4+Player.bulletSpeedUps;
	}

	public static void setSpeedUps(int speedUps) {
		Player.speedUps=speedUps;
		Player.Vx=4+Player.speedUps;
		Player.Vy=4+Player.speedUps;
		StatsTracker.movementUpgs=Player.speedUps;
	}

	public static void setBulletBehavior(ProjectileBehavior bulletBehavior) {
		Player.bulletBehavior=bulletBehavior;
	}

	public static void setMissileBehavior(MissileBehavior missileBehavior) {
		Player.missileBehavior=missileBehavior;
	}

}