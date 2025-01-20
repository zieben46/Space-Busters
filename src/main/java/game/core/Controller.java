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
import game.levels.LevelEntity;
import game.levels.LevelFactory;
import game.levels.Popup;
import game.objects.Player;
import game.objects.Item;
import game.objects.collisionsprite.BigYellowExplosion;
import game.objects.collisionsprite.BlueExplosion;
import game.objects.collisionsprite.YellowExplosion;
import game.objects.enemy.Radar;
import game.objects.interfaces.EnemyEntity;
import game.objects.interfaces.ExplosionEntity;
import game.objects.interfaces.ProjectileEntity;
import game.objects.interfaces.ItemEntity;
import game.objects.interfaces.ProjectileEntity.Team;
import game.objects.interfaces.ItemEntity.ItemType;
import game.objects.projectiles.Beam;
import game.utils.LoadAndSaver;
import game.utils.Sound;
import game.utils.Sound.soundEnum;

public class Controller {

	private LinkedList<ProjectileEntity> projectileEntities = new LinkedList<ProjectileEntity>();
	private LinkedList<EnemyEntity> enemyEntities = new LinkedList<EnemyEntity>();
	private LinkedList<ItemEntity> upgradeEntities = new LinkedList<ItemEntity>();
	private LinkedList<ExplosionEntity> explosionEntities = new LinkedList<ExplosionEntity>();

	private Player player;

	private int gunTypeUpgradeSpawn=-1;
	private int gunRateUpgradeSpawn=-1;
	private int movementUpgradeSpawn=-1;
	private int healthPackSpawn;
	private Random random = new Random();
	private LevelEntity level;
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

	public Controller() {
		this(1);
	}

	public Controller(int levelNumber) {
		this.levelNumber=levelNumber;
		player=new Player(420, 600);
		levelFactory=new LevelFactory(enemyEntities, player);
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

			for (int i=0; i<projectileEntities.size(); i++) {
				ProjectileEntity projectileEntity=projectileEntities.get(i);
				projectileHit(projectileEntity);
				projectileBounds(projectileEntity);
				checkBeam(projectileEntity);
				projectileEntity.update();
			}

			for (int i=0; i<enemyEntities.size(); i++) {
				EnemyEntity enemyEntity=enemyEntities.get(i);
				testCollision(enemyEntity);
				checkDeadEnemy(enemyEntity);			
				enemyBounds(enemyEntity);
				randomShoot(enemyEntity);
				enemyEntity.update();
			}

			for (int i=0; i<upgradeEntities.size(); i++) {
				ItemEntity upGradeEntity=upgradeEntities.get(i);
				pickUp(upGradeEntity);
				upgradeBounds(upGradeEntity);
				upGradeEntity.update();
			}

			for (int i=0; i<explosionEntities.size(); i++) {
				ExplosionEntity explosionEntity=explosionEntities.get(i);
				checkRendering(explosionEntity);
			}

			level.update();
			Radar.update();
			checkComplete();
			inGap=level.getInGap();

			if (player.isDead()) {

				if (!explosionRendered) {
					explosionEntities.add(new BigYellowExplosion(new Point
							(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2)));
					explosionRendered=true;
				}
			}
		}
		checkKeys();
	}

	private void checkRendering(ExplosionEntity explosionEntity) {
		if (!explosionEntity.isRendering()) {
			explosionEntities.remove(explosionEntity);
		}
	}

	private void checkBeam(ProjectileEntity projectileEntity) {
		if (projectileEntity.getClass().equals(Beam.class)) {
			projectileEntities.remove(projectileEntity);
		}
	}

	public void render(Graphics2D g) {
		projectileEntities.stream().forEach(e -> e.render(g));
		enemyEntities.stream().forEach(e -> e.render(g));
		upgradeEntities.stream().forEach(e -> e.render(g));
		player.render(g);


		explosionEntities.stream().forEach(e -> e.render(g));

		if (inGap) {
			popup.renderWarning(g);
		}

		if (player.isDead()) {
			popup.renderDeadMessage(g);
			playerDead=true;
			//			if (!explosionRendered) {
			//				explosionEntities.add(new BigYellowExplosion(new Point
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

	private void randomShoot(EnemyEntity enemyEntity) {
		ArrayList<ProjectileEntity> newProjectiles=enemyEntity.randomBullet();
		if (newProjectiles!=null) {
			projectileEntities.addAll(newProjectiles);
		}
	}

	private void  projectileHit(ProjectileEntity projectileEntity) {    //test player hits enemy
		if (projectileEntity.team().equals(Team.FRIENDLY)) {
			for (int i=0; i<enemyEntities.size(); i++) {
				EnemyEntity enemyEntity=enemyEntities.get(i);
				if (Physics.Collision(projectileEntity, enemyEntity)) {

					enemyEntity.takeDamage(projectileEntity.getDamage());
					explosionEntities.add(new YellowExplosion(new Point
							(projectileEntity.getX()+player.getWidth()/2, projectileEntity.getY()+player.getHeight()/2)));
					Sound.playSound(soundEnum.SMALLEXPLOSION);
					projectileEntities.remove(projectileEntity);
				}
			}
		} else if (projectileEntity.team().equals(Team.ENEMY)){   //test enemy hits player
			if (Physics.Collision(player, projectileEntity) && !player.isDead()) {
				projectileEntities.remove(projectileEntity);
				player.decreaseHealth();
				explosionEntities.add(new BlueExplosion(new Point
						(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2)));
				Sound.playSound(soundEnum.SMALLEXPLOSION);
			}
		}
	}

	private void checkDeadEnemy(EnemyEntity enemyEntity) {
		if (enemyEntity.isDead()) {
			enemyEntities.remove(enemyEntity);
			enemiesKilled++;
			spawnUpgrade(enemyEntity.getX(), enemyEntity.getY());    //move?
			level.addEnemy();
		}
	}

	private void testCollision(EnemyEntity enemyEntity) {    //test for enemy player collision
		if (Physics.Collision(player, enemyEntity) && !player.isDead()) {
			Sound.playSound(soundEnum.SMALLEXPLOSION);
			player.decreaseHealth();
			Rectangle union=Physics.getIntersection(player, enemyEntity);
			explosionEntities.add(new BlueExplosion(new Point((int) union.getX(),(int) union.getY())));
			enemyEntities.remove(enemyEntity);
			enemiesKilled++;
			level.addEnemy();
		}
	}

	private void projectileBounds(ProjectileEntity ProjectileEntity) {
		if (ProjectileEntity.getY()<-20||ProjectileEntity.getY()>1000||
				ProjectileEntity.getX()<-100||ProjectileEntity.getX()>900) {
			projectileEntities.remove(ProjectileEntity);
		}
	}

	private void upgradeBounds(ItemEntity itemEntity) {
		if (itemEntity.getY()<-20||itemEntity.getY()>1000||
				itemEntity.getX()<-100||itemEntity.getX()>900) {
			upgradeEntities.remove(itemEntity);
		}
	}

	private void enemyBounds(EnemyEntity enemyEntity) {
		int x=enemyEntity.getX();
		int y=enemyEntity.getY();

		if (x>Game.WIDTH+60) {
			enemyEntity.setX(-30);
		}
		else if (x<-60) {
			enemyEntity.setX(Game.WIDTH+30);

		} else if (y>Game.HEIGHT+400) {
			enemyEntity.setNewPosition();
		}
	}

	private void checkComplete() {
		if (level.levelComplete()&&levelNumber<TOTAL_LEVELS) {
			levelNumber++;
			initializeLevel();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////

	private void pickUp(ItemEntity itemEntity) {
		if ((Physics.Collision(player, itemEntity))) {
			upgradeEntities.remove(itemEntity);
			player.consume(itemEntity);
		}
	}

	private void spawnUpgrade(int x, int y) {  //move
		int r=random.nextInt(100);
		if (r<=gunTypeUpgradeSpawn&&StatsTracker.gunTypeUpgs<3) {
			upgradeEntities.add(new Item(x, y, ItemType.gunType));
		}
		r=random.nextInt(100);
		if (r<=gunRateUpgradeSpawn&&StatsTracker.gunRateUpgs<10) {
			upgradeEntities.add(new Item(x, y, ItemType.gunRate));
		} 
		r=random.nextInt(100);
		if (r<=movementUpgradeSpawn&&StatsTracker.movementUpgs<3) {
			upgradeEntities.add(new Item(x, y, ItemType.movement));
		}
		r=random.nextInt(100);
		if (r<=healthPackSpawn) {
			upgradeEntities.add(new Item(x, y, ItemType.healthPack));
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
			ArrayList<ProjectileEntity> newProjectiles= new ArrayList<>();
			newProjectiles=player.shootBullet();
			if (newProjectiles!=null) {
				projectileEntities.addAll(newProjectiles);
			}
		}

		if (Keyboard.typed(KeyEvent.VK_A)&&!paused&&!playerDead) {
			ArrayList<ProjectileEntity> newProjectiles=player.shootMissile(-30);
			if (newProjectiles!=null) {
				projectileEntities.addAll(newProjectiles);
			}
		}

		if (Keyboard.typed(KeyEvent.VK_D)&&!paused&&!playerDead) {
			ArrayList<ProjectileEntity> newProjectiles=player.shootMissile(30);
			if (newProjectiles!=null) {
				projectileEntities.addAll(newProjectiles);
			}
		}

		if (Keyboard.EnterPressed()&&!paused&&playerDead) {
			player=new Player(420, 600);
			enemyEntities.clear();
			upgradeEntities.clear();
			projectileEntities.clear();
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