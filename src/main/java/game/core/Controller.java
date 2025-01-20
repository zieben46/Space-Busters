package game.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

import game.input.Keyboard;
import game.levels.Level;
import game.levels.LevelFactory;
import game.levels.Popup;
import game.objects.Player;
import game.objects.enemies.Radar;
import game.objects.Item;
import game.objects.explosions.YellowBigExplosion;
import game.objects.explosions.BlueExplosion;
import game.objects.explosions.YellowExplosion;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Explosion;
import game.objects.interfaces.Projectile;
import game.objects.Item.ItemType;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Beam;
import game.utils.LoadAndSaver;
import game.utils.Sound;
import game.utils.Sound.soundEnum;

public class Controller {

	private LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private LinkedList<Item> items = new LinkedList<Item>();
	private LinkedList<Explosion> explosions = new LinkedList<Explosion>();

	private Player player;

	private int gunTypeUpgradeSpawn=-1;
	private int gunRateUpgradeSpawn=-1;
	private int movementUpgradeSpawn=-1;
	private int healthPackSpawn;
	private Random random = new Random();
	private Level level;
	private LevelFactory levelFactory;
	private boolean inGap;
	private Popup popup;
	private boolean paused;
	private boolean playerDead;
	private boolean explosionRendered=false;

	private final int TOTAL_LEVELS=16;
	private int levelNumber;

	private int enemiesKilled;
	private int totalEnemies;

	public class StatsTracker {
		public static int playerHealth=100*2;
		public static int movementUpgs=0;
		public static int gunRateUpgs=0;
		public static int gunTypeUpgs=0;
		public static int level=0;
	}

	public Controller() {
		this(1);
	}

	public Controller(int levelNumber) {
		this.levelNumber=levelNumber;
		player=new Player(420, 600);
		levelFactory=new LevelFactory(enemies, player);
		initializeLevel();
		healthPackSpawn=level.getHeathSpawnRate();
	}

	private void initializeLevel() {
		new Radar(player);
		playerDead=false;
		explosionRendered=false;
		level=levelFactory.newLevel(levelNumber);
		totalEnemies=level.getTotalEnemies();
		enemiesKilled=0;
		StatsTracker.level=levelNumber;
		popup=new Popup(levelNumber);
	}

	public synchronized void update() {
		if (!paused) {
			player.update();

			for (int i=0; i<projectiles.size(); i++) {
				Projectile projectile=projectiles.get(i);
				projectileHit(projectile);
				projectileBounds(projectile);
				checkBeam(projectile);
				projectile.update();
			}

			for (int i=0; i<enemies.size(); i++) {
				Enemy enemy=enemies.get(i);
				testCollision(enemy);
				checkDeadEnemy(enemy);			
				enemyBounds(enemy);
				randomShoot(enemy);
				enemy.update();
			}

			for (int i=0; i<items.size(); i++) {
				Item item=items.get(i);
				pickUp(item);
				upgradeBounds(item);
				item.update();
			}

			for (int i=0; i<explosions.size(); i++) {
				Explosion explosion=explosions.get(i);
				checkRendering(explosion);
			}

			level.update();
			Radar.update();
			checkComplete();
			inGap=level.getInGap();

			if (player.isDead()) {

				if (!explosionRendered) {
					explosions.add(new YellowBigExplosion(new Point
							(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2)));
					explosionRendered=true;
				}
			}
		}
		checkKeys();
	}

	private void checkRendering(Explosion explosion) {
		if (!explosion.isRendering()) {
			explosions.remove(explosion);
		}
	}

	private void checkBeam(Projectile projectile) {
		if (projectile.getClass().equals(Beam.class)) {
			projectiles.remove(projectile);
		}
	}

	public void render(Graphics2D g) {
		projectiles.stream().forEach(e -> e.render(g));
		enemies.stream().forEach(e -> e.render(g));
		items.stream().forEach(e -> e.render(g));
		player.render(g);


		explosions.stream().forEach(e -> e.render(g));

		if (inGap) {
			popup.renderWarning(g);
		}

		if (player.isDead()) {
			popup.renderDeadMessage(g);
			playerDead=true;
			//			if (!explosionRendered) {
			//				explosions.add(new BigYellowExplosion(new Point
			//						(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2)));
			//				explosionRendered=true;
			//			}
		}

		if (paused) {
			popup.renderPauseMessage(g);
		}

		renderKillCounter(g);
	}

	private void renderKillCounter(Graphics2D g) {
		g.setFont(new Font("AR DESTINE",Font.BOLD, 45 ));
		g.setColor(Color.white);
		g.drawString(enemiesKilled+"/"+totalEnemies, Game.WIDTH-130, Game.HEIGHT-20);
	}

	private void randomShoot(Enemy enemy) {
		ArrayList<Projectile> newProjectiles=enemy.randomBullet();
		if (newProjectiles!=null) {
			projectiles.addAll(newProjectiles);
		}
	}

	private void  projectileHit(Projectile projectile) {    //test player hits enemy
		if (projectile.team().equals(Team.FRIENDLY)) {
			for (int i=0; i<enemies.size(); i++) {
				Enemy enemy=enemies.get(i);
				if (Physics.Collision(projectile, enemy)) {

					enemy.takeDamage(projectile.getDamage());
					explosions.add(new YellowExplosion(new Point
							(projectile.getX()+player.getWidth()/2, projectile.getY()+player.getHeight()/2)));
					Sound.playSound(soundEnum.SMALLEXPLOSION);
					projectiles.remove(projectile);
				}
			}
		} else if (projectile.team().equals(Team.ENEMY)){   //test enemy hits player
			if (Physics.Collision(player, projectile) && !player.isDead()) {
				projectiles.remove(projectile);
				player.decreaseHealth();
				explosions.add(new BlueExplosion(new Point
						(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2)));
				Sound.playSound(soundEnum.SMALLEXPLOSION);
			}
		}
	}

	private void checkDeadEnemy(Enemy enemy) {
		if (enemy.isDead()) {
			enemies.remove(enemy);
			enemiesKilled++;
			spawnUpgrade(enemy.getX(), enemy.getY());    //move?
			level.addEnemy();
		}
	}

	private void testCollision(Enemy enemy) {    //test for enemy player collision
		if (Physics.Collision(player, enemy) && !player.isDead()) {
			Sound.playSound(soundEnum.SMALLEXPLOSION);
			player.decreaseHealth();
			Rectangle union=Physics.getIntersection(player, enemy);
			explosions.add(new BlueExplosion(new Point((int) union.getX(),(int) union.getY())));
			enemies.remove(enemy);
			enemiesKilled++;
			level.addEnemy();
		}
	}

	private void projectileBounds(Projectile ProjectileEntity) {
		if (ProjectileEntity.getY()<-20||ProjectileEntity.getY()>1000||
				ProjectileEntity.getX()<-100||ProjectileEntity.getX()>900) {
			projectiles.remove(ProjectileEntity);
		}
	}

	private void upgradeBounds(Item item) {
		if (item.getY()<-20||item.getY()>1000||
				item.getX()<-100||item.getX()>900) {
					items.remove(item);
		}
	}

	private void enemyBounds(Enemy enemy) {
		int x=enemy.getX();
		int y=enemy.getY();

		if (x>Game.WIDTH+60) {
			enemy.setX(-30);
		}
		else if (x<-60) {
			enemy.setX(Game.WIDTH+30);

		} else if (y>Game.HEIGHT+400) {
			enemy.setNewPosition();
		}
	}

	private void checkComplete() {
		if (level.levelComplete()&&levelNumber<TOTAL_LEVELS) {
			levelNumber++;
			initializeLevel();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////

	private void pickUp(Item item) {
		if ((Physics.Collision(player, item))) {
			items.remove(item);
			player.consume(item);
		}
	}

	private void spawnUpgrade(int x, int y) {  //move
		int r=random.nextInt(100);
		if (r<=gunTypeUpgradeSpawn&&StatsTracker.gunTypeUpgs<3) {
			items.add(new Item(x, y, ItemType.gunType));
		}
		r=random.nextInt(100);
		if (r<=gunRateUpgradeSpawn&&StatsTracker.gunRateUpgs<10) {
			items.add(new Item(x, y, ItemType.gunRate));
		} 
		r=random.nextInt(100);
		if (r<=movementUpgradeSpawn&&StatsTracker.movementUpgs<3) {
			items.add(new Item(x, y, ItemType.movement));
		}
		r=random.nextInt(100);
		if (r<=healthPackSpawn) {
			items.add(new Item(x, y, ItemType.healthPack));
		}
	}

	private void checkKeys() {
		if (Keyboard.typed(KeyEvent.VK_LEFT)&&!paused&&!playerDead) {
			player.moveLeft();
		}
		if (Keyboard.typed(KeyEvent.VK_RIGHT)&&!paused&&!playerDead) {
			player.moveRight();
		}
		if (Keyboard.typed(KeyEvent.VK_UP)&&!paused&&!playerDead) {
			player.moveUp();
		}
		if (Keyboard.typed(KeyEvent.VK_DOWN)&&!paused&&!playerDead) {
			player.moveDown();
		}
		if (Keyboard.typed(KeyEvent.VK_SPACE)&&!paused&&!playerDead) {
			ArrayList<Projectile> newProjectiles= new ArrayList<>();
			newProjectiles=player.fire();
			if (newProjectiles!=null) {
				projectiles.addAll(newProjectiles);
			}
		}

		if (Keyboard.typed(KeyEvent.VK_A)&&!paused&&!playerDead) {
			ArrayList<Projectile> newProjectiles=player.shootSide(-30);
			if (newProjectiles!=null) {
				projectiles.addAll(newProjectiles);
			}
		}

		if (Keyboard.typed(KeyEvent.VK_D)&&!paused&&!playerDead) {
			ArrayList<Projectile> newProjectiles=player.shootSide(30);
			if (newProjectiles!=null) {
				projectiles.addAll(newProjectiles);
			}
		}

		if (Keyboard.EnterPressed()&&!paused&&playerDead) {
			player=new Player(420, 600);
			enemies.clear();
			items.clear();
			projectiles.clear();
			healthPackSpawn=level.getHeathSpawnRate();
			initializeLevel();
		}

		if (Keyboard.PPressed()) {
			paused=true;	
		}

		if (Keyboard.RPressed()) {
			paused=false;
		}

		if (Keyboard.escapePressed()&&paused) {
			int input=JOptionPane.showConfirmDialog(null, "Exit game and return to menu?");
			if (input==0) {
				Game.state=Game.STATE.MENU;
				//Sound.stopBackgroundMusic();
			}
			Keyboard.resetEscape();
		}

		if (Keyboard.SPressed()&&paused) {
			int input=JOptionPane.showConfirmDialog(null, "Save game?");
			if (input==0) {
				LoadAndSaver.Save(levelNumber);
			}
			Keyboard.resetS();
		}
	}
}