package game.levels;

import java.util.LinkedList;
import java.util.Random;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level6 extends LevelBase {
	private Random random;
	private int enemyTypes = 2;

	public Level6(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies = 40;
		enemyRate = 6;
		random = new Random();
	}

	// @Override
	// public void addEnemy() {
	// 	if (enemiesAdded<totalEnemies) {
	// 		enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));
	// 		enemiesAdded++;
	// 	}
	// }

	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			int r =  random.nextInt(10);
			if (r < 8) {
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));

			} else {
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy3));
			}
			enemiesAdded++;
		}
	}
}
