package game.objects.enemy;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import game.core.Game;
import game.objects.BaseObject;
import game.objects.interfaces.EnemyEntity;
import game.objects.interfaces.ProjectileEntity;
import game.objects.interfaces.ProjectileEntity.Team;
import game.objects.projectiles.projectilebehaviors.ProjectileBehavior;

public abstract class BaseEnemy extends BaseObject implements EnemyEntity {
	protected BufferedImage shipImage;
	protected Random random=new Random();
	protected boolean isDead;
	protected double firedTime;
	
	protected int Vx;
	protected int Vy;
	protected int health;
	protected ProjectileBehavior bulletBehavior;
	protected int bulletSpeed;
	protected double bulletCoolDownTime;
	protected double moveCoolDownTime;
	
	public BaseEnemy() {
		super();
		getImage();
		random=new Random();
		super.setHeight(shipImage.getHeight());
		super.setWidth(shipImage.getWidth());
	}
	
	public abstract void getImage();
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(shipImage, x, y, null);
	}
	
	@Override
	public ArrayList<ProjectileEntity> randomBullet() {
		double currentTime=System.currentTimeMillis();
		if ((currentTime-firedTime)>bulletCoolDownTime&&wantsTo()) {
			firedTime=currentTime;
			return bulletBehavior.shootBullet(x+(getWidth()/2-5), y+getHeight(), Vx, Vy+bulletSpeed, Team.ENEMY);
		}
		return null;
	}
	
	@Override
	public void update() {
		y+=Vy;
		x+=Vx;	
		randomMove();
	}
	
	protected void randomMove() {
		//hook method
	}
	
	protected boolean wantsTo() {
		int r=random.nextInt(5);
		return r==0;
	}
	
	public void takeDamage(int damage) {
		health-=damage;
		if (health<=0) {
			isDead=true;
		}
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setNewPosition() {
		y=-random.nextInt(200)-300;
		x=random.nextInt(Game.WIDTH);
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle (x, y, shipImage.getWidth(), shipImage.getHeight());
	}
}