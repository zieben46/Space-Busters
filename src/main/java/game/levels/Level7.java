package game.levels;

import java.util.LinkedList;
import java.util.Random;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level7 extends LevelBase {
	private Random random;
	private int enemyTypes = 2;

	public Level7(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		gapTime = 10*1000;
		totalEnemies = 50;
		enemyRate = 7;
		random = new Random();
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			int r = random.nextInt(enemyTypes)+1;
			switch (r) {
			case 1:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));
				break;
			case 2:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.MediumSuicide));
				break;
			}
			enemiesAdded++;
		}
	}
}
