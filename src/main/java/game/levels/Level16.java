package game.levels;

import java.util.LinkedList;
import java.util.Random;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level16 extends LevelBase {
	private Random random;
	private int enemyTypes;

	public Level16(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies = 500;
		enemyRate = 20;
		enemyTypes = 2;
		random = new Random();
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			int r = random.nextInt(enemyTypes)+1;
			switch (r) {
			case 1:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.BeamEasy));
				break;
			case 2:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.MediumSuicide));
				break;
			}
		}
		enemiesAdded++;
	}
}
