package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.enemies.EnemyFactory;
import game.objects.interfaces.Enemy;

public abstract class Level implements LevelEntity {
	protected EnemyFactory enemyFactory;
	protected int totalEnemies;
	protected int enemyRate;
	protected int enemiesPresent;
	protected LinkedList<Enemy> enemyEntities;
	protected Player player;
	protected int enemiesAdded;
	protected int healthPackSpawn=25;
	protected boolean running=false;
	protected boolean activated=false;
	protected long gapTime=7*1000;
	protected double startTime;
	protected boolean inGap;

	public Level(LinkedList<Enemy> enemyEntities, Player player) {
		this.enemyEntities=enemyEntities;
		enemyFactory=new EnemyFactory();
		this.player=player;
		startTime=System.currentTimeMillis();
		inGap=true;
	}

	@Override
	public void initialize() {
		for (int i=1; i<=enemyRate; i++) {
			addEnemy();
		}
	}

	@Override
	public abstract void addEnemy();

	public int getTotalEnemies() {
		return totalEnemies;
	}

	public void update() {
		if (inGap==true) {
			double currentTime=System.currentTimeMillis();
			if (currentTime-startTime>=gapTime) {
				initialize();
				inGap=false;
			}
		}
	}

	@Override
	public boolean levelComplete() {
		return enemyEntities.isEmpty()&&!inGap;
	}

	public int getHeathSpawnRate() {
		return healthPackSpawn;
	}
	
	public boolean getInGap() {
		return inGap;
	}
}
